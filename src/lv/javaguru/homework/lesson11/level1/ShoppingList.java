package lv.javaguru.homework.lesson11.level1;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingList {

    private List<Product> shoppingList;

    public ShoppingList(List<Product> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public List<Product> getShoppingList() {
        return shoppingList;
    }

    public void addProduct(Product product) {
        shoppingList.add(product);
    }

    public void deleteProductByName(String name) {
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).getName().equals(name)) {
                shoppingList.remove(i);
            }
        }
    }

    public void printToConsole() {
        int i = 1;
        for (Product product : shoppingList) {
            System.out.println(i + ". "
                    + product.getName() + " price is "
                    + product.getPrice() + " and category: \""
                    + product.getCategory() + "\";");
        }
    }

    public List<Product> getProductsInPriceRange(BigDecimal from, BigDecimal to) {
        List<Product> result = new ArrayList<>();
        for (Product product : shoppingList) {
            if (product.getPrice().compareTo(from) > 0 && product.getPrice().compareTo(to) < 0) {
                result.add(product);
            }
        }
        return result;
    }

    public List<Product> getProductsByCategory(Category category) {
        List<Product> result = new ArrayList<>();
        for (Product product : shoppingList) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }


}
