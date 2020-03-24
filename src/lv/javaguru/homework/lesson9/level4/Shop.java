package lv.javaguru.homework.lesson9.level4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Shop {

    private List<Product> products;

    Shop() {
        products = new ArrayList<>();
    }

    Shop(List<Product> products) {
        this.products = products;
    }

    public void add(Product product) {
        products.add(product);
    }

    public void addAll(List<Product> products) {
        this.products.addAll(products);
    }

    public void removeProductByName(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    //arī šeit labak izmantot Optional līdzīgi kā iepriekšējā uzdevumā
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return new Product("", new BigDecimal("0.00"));
    }

    //metodes nosaukums mulsina, labāk findProducts un atgriežamais tips List<Product>
    public Shop findProduct(BigDecimal minPrice, BigDecimal maxPrice) {
        Shop resultList = new Shop();
        for (Product product : products) {
            if (product.getPrice().compareTo(minPrice) == 1 && product.getPrice().compareTo(maxPrice) == -1) {
                resultList.add(product);
            }
        }
        return resultList;
    }

    public List<Product> getProducts() {
        return products;
    }

    public int size() {
        return products.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shop)) return false;
        Shop shop = (Shop) o;
        return Objects.equals(products, shop.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }
}
