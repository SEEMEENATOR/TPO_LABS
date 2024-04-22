package threads;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class PortTest {

    @Test
    public void testPortSimulation() throws InterruptedException {
        threads.Port port = new threads.Port(1000, 3);
        PortSimulation simulation = new PortSimulation(port); // Используем PortSimulation, а не threads.PortSimulation

        Thread simulationThread = new Thread(simulation);
        simulationThread.start();

        simulationThread.join();

        assertEquals(0, port.getDockedShipsCount());
    }

    private class PortSimulation implements Runnable {
        private threads.Port port; // Используем threads.Port, так как Port находится в том же пакете

        public PortSimulation(threads.Port port) {
            this.port = port;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                threads.Ship ship = new threads.Ship("Ship " + i, 200, port);
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
}
