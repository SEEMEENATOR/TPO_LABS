package collections.GiftTest;


import collections.gift.Gift;
import collections.sweets.Candy;
import collections.sweets.Sweet;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class GiftTest {

    @Test
    void testGetTotalWeight() {
        Gift gift = new Gift();
        gift.addSweet(new Candy("Шоколадка", 50, 30));
        gift.addSweet(new Candy("Ириска", 30, 20));
        gift.addSweet(new Candy("Мармелад", 40, 40));

        assertEquals(120.0, gift.getTotalWeight(), 0.001);

    }

    @Test
    void testSortSweetsBySugarContent() {
        Gift gift = new Gift();
        gift.addSweet(new Candy("Шоколадка", 50, 30));
        gift.addSweet(new Candy("Ириска", 30, 20));
        gift.addSweet(new Candy("Мармелад", 40, 40));

        gift.sortSweetsBySugarContent();

        assertEquals("Ириска", gift.getSweets().get(0).getName());
        assertEquals("Шоколадка", gift.getSweets().get(1).getName());
        assertEquals("Мармелад", gift.getSweets().get(2).getName());
    }
}
