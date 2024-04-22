package collections.test;
import collections.gift.Gift;
import collections.sweets.Candy;
import collections.sweets.Sweet;

import java.util.Scanner;
 class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Gift gift = new Gift();

        gift.addSweet(new Candy("Шоколадка", 50, 30));
        gift.addSweet(new Candy("Ириска", 30, 20));
        gift.addSweet(new Candy("Мармелад", 40, 40));

        double minSugar = 20;
        double maxSugar = 35;

        gift.sortSweetsBySugarContent();

        System.out.println("Подарок: ");
        System.out.println(gift);
        System.out.println("Общий вес подарка: " + gift.getTotalWeight() + " г");

        Sweet foundSweet = gift.findSweetBySugarContentRange(minSugar, maxSugar);
        if (foundSweet != null) {
            System.out.println("Конфета с содержанием сахара от " + minSugar + " до " + maxSugar + " г: " + foundSweet.getName());
        } else {
            System.out.println("Конфета с таким содержанием сахара не найдена.");
        }
    }
}