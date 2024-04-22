package collections.gift;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import collections.sweets.Sweet;
public class Gift {
    private List<Sweet> sweets;

    public Gift() {
        sweets = new ArrayList<>();
    }
    public List<Sweet> getSweets() {
        return sweets;
    }
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Sweet sweet : sweets) {
            totalWeight += sweet.getWeight();
        }
        return totalWeight;
    }

    public void sortSweetsBySugarContent() {
        Collections.sort(sweets, Comparator.comparingDouble(Sweet::getSugarContent));
    }

    public Sweet findSweetBySugarContentRange(double minSugar, double maxSugar) {
        for (Sweet sweet : sweets) {
            if (sweet.getSugarContent() >= minSugar && sweet.getSugarContent() <= maxSugar) {
                return sweet;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "sweets=" + sweets +
                '}';
    }
}