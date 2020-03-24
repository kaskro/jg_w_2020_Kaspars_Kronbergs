package lv.javaguru.homework.lesson9.level4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void add() {
        shop.add(makeProduct("Test", "10.00"));
        assertEquals(1, shop.size());
    }

    @Test
    void addAll() {
        addThreeProducts();

        Shop secondShop = new Shop();
        secondShop.add(makeProduct("Test4", "13.00"));
        secondShop.addAll(shop.getProducts());

        assertEquals(4, secondShop.size());
    }

    @Test
    void removeProductByName() {
        addThreeProducts();
        shop.add(makeProduct("Test2", "14.00"));

        shop.removeProductByName("Test2");
        assertEquals(2, shop.size());
    }

    @Test
    void getProductByName() {
        shop.add(makeProduct("Test2", "11.00"));
        assertEquals("Test2", shop.getProductByName("Test2").getName());
    }

    @Test
    void getNotProductByWrongName() {
        shop.add(makeProduct("Test2", "11.00"));
        assertEquals("", shop.getProductByName("Test").getName());
    }

    @Test
    void findProduct() {
        addThreeProducts();
        Shop resultList = new Shop();
        resultList.add(makeProduct("Test2", "11.00"));
        assertEquals(resultList, shop.findProduct(new BigDecimal("10.00"), new BigDecimal("12.00")));
    }

    private Product makeProduct(String name, String value) {
        return new Product(name, new BigDecimal(value));
    }

    private void addThreeProducts() {
        shop.add(makeProduct("Test1", "10.00"));
        shop.add(makeProduct("Test2", "11.00"));
        shop.add(makeProduct("Test3", "12.00"));
    }
}