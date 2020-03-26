package lv.javaguru.homework.lesson9.level4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//OK
class ShopTest {

    private Shop shop;

    @BeforeEach
    void setUp() {
        shop = new Shop();
    }

    @Test
    void shouldAddProduct() {
        shop.add(makeProduct("Test", "10.00"));
        assertEquals(1, shop.size());
    }

    @Test
    void shouldAddAllProducts() {
        addThreeProducts();

        Shop secondShop = new Shop();
        secondShop.add(makeProduct("Test4", "13.00"));
        secondShop.addAll(shop.getProducts());

        assertEquals(4, secondShop.size());
    }

    @Test
    void shouldRemoveProductByName() {
        addThreeProducts();
        shop.add(makeProduct("Test2", "14.00"));

        shop.removeProductByName("Test2");
        assertEquals(2, shop.size());
    }

    @Test
    void shouldGetProductByName() {
        Product test = makeProduct("Test2", "11.00");
        shop.add(test);
        assertEquals(Optional.of(test), shop.getProductByName("Test2"));
    }

    @Test
    void shouldNotGetProductByWrongName() {
        Product test = makeProduct("Test2", "11.00");
        shop.add(test);
        assertNotEquals(Optional.of(test), shop.getProductByName("Test"));
    }

    @Test
    void shouldFindProductsInRange() {
        addThreeProducts();
        List<Product> resultList = new ArrayList<>();
        resultList.add(makeProduct("Test2", "11.00"));
        assertEquals(resultList, shop.findProducts(new BigDecimal("10.00"), new BigDecimal("12.00")));
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