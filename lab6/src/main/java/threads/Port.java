package threads;
import  java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

class Port {
    private int capacity;
    private Semaphore dockSemaphore;
    private AtomicInteger dockedShipsCount;

    public Port(int capacity, int dockCount) {
        this.capacity = capacity;
        this.dockSemaphore = new Semaphore(dockCount, true);
        this.dockedShipsCount = new AtomicInteger(0);
    }

    public void dockShip(Ship ship) throws InterruptedException {
        dockSemaphore.acquire();
        System.out.println(ship.getShipName() + " docked at the port.");
        dockedShipsCount.incrementAndGet();
    }

    public void undockShip(Ship ship) {
        dockSemaphore.release();
        System.out.println(ship.getShipName() + " undocked from the port.");
        dockedShipsCount.decrementAndGet();
    }

    public synchronized void loadContainer(int amount) {
        System.out.println("Loading " + amount + " containers.");
    }

    public synchronized void unloadContainer(int amount) {
        System.out.println("Unloading " + amount + " containers.");
    }

    public int getCapacity() {
        return capacity;
    }

    public int getDockedShipsCount() {
        return dockedShipsCount.get();
    }
}

class Ship extends Thread {
    private String shipName;
    private int capacity;
    private Port port;

    public Ship(String name, int capacity, Port port) {
        this.shipName = name;
        this.capacity = capacity;
        this.port = port;
    }

    public String getShipName() {
        return shipName;
    }

    @Override
    public void run() {
        try {
            port.dockShip(this);

            int containersToLoad = ThreadLocalRandom.current().nextInt(1, capacity + 1); // Random number of containers to load
            int containersToUnload = ThreadLocalRandom.current().nextInt(1, capacity + 1); // Random number of containers to unload

            System.out.println(shipName + " is loading " + containersToLoad + " containers and unloading " + containersToUnload + " containers.");

            port.loadContainer(containersToLoad);
            Thread.sleep(10000);
            port.unloadContainer(containersToUnload);

            port.undockShip(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class PortSimulation {
    public static void main(String[] args) {
        Port port = new Port(1000, 3);
        for (int i = 1; i <= 5; i++) {
            Ship ship = new Ship("Ship " + i, 200, port);
            ship.start();
        }

        while (port.getDockedShipsCount() > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
