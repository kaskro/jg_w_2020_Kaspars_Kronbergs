package lv.javaguru.homework.lesson11.level1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingListTest {

    private List<Product> mockList;
    private ShoppingList shoppingList;

    @BeforeEach
    void setUp() {
        mockList = new ArrayList<>();
        shoppingList = new ShoppingList(mockList);
    }

    @Test
    void shouldAddProduct() {
        Product orange = new Product("Orange", new BigDecimal("2.30"), Category.FOOD);
        shoppingList.addProduct(orange);

        assertEquals(1, shoppingList.getShoppingList().size());
    }

    @Test
    void shouldDeleteProductByName() {
        Product orange = new Product("Orange", new BigDecimal("2.30"), Category.FOOD);
        mockList.add(orange);

        shoppingList.deleteProductByName("Orange");
        assertFalse(shoppingList.getShoppingList().contains(orange));
    }

    @Test
    void shouldGetProductsInGivenPriceRange() {
        Product orange = new Product("Orange", new BigDecimal("2.30"), Category.FOOD);
        createMockWithProducts();

        shoppingList.printToConsole();

        assertEquals(1, shoppingList.getProductsInPriceRange(new BigDecimal("2.29"), new BigDecimal("2.32")).size());
        assertEquals(orange, shoppingList.getProductsInPriceRange(new BigDecimal("2.29"), new BigDecimal("2.32")).get(0));
    }

    @Test
    void shouldGetProductListByCategory() {
        Product radio = new Product("Radio", new BigDecimal("23.99"), Category.ELECTRONICS);
        Product laptop = new Product("Laptop", new BigDecimal("340.99"), Category.ELECTRONICS);
        createMockWithProducts();

        List<Product> testList = new ArrayList<>();
        testList.add(radio);
        testList.add(laptop);

        assertEquals(testList, shoppingList.getProductsByCategory(Category.ELECTRONICS));
    }

    @Test
    void shouldPrintListToConsole() {
        createMockWithProducts();

        shoppingList.printToConsole();
    }

    @Test
    void shouldSaveShoppingListToFile() {
        createMockWithProducts();

        File testFile = new File("resource/shoppingList");
        shoppingList.saveListInFile(testFile);
        assertTrue(testFile.exists());
        assertTrue(testFile.length() > 0);
    }

    @Test
    void shouldLoadShoppingListFromAFile() {
        createMockWithProducts();

        File testFile = new File("resource/shoppingList");
        ShoppingList resultList = new ShoppingList(new ArrayList<>());
        resultList.loadListFromFile(testFile);
        assertEquals(shoppingList.getShoppingList(), resultList.getShoppingList());
    }

    private void createMockWithProducts() {
        Product orange = new Product("Orange", new BigDecimal("2.30"), Category.FOOD);
        Product banana = new Product("Banana", new BigDecimal("1.40"), Category.FOOD);
        Product milk = new Product("Orange", new BigDecimal("1.25"), Category.FOOD);
        Product radio = new Product("Radio", new BigDecimal("23.99"), Category.ELECTRONICS);
        Product laptop = new Product("Laptop", new BigDecimal("340.99"), Category.ELECTRONICS);


        mockList.add(orange);
        mockList.add(banana);
        mockList.add(milk);
        mockList.add(radio);
        mockList.add(laptop);
    }
}