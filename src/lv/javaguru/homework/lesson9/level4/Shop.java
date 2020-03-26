package lv.javaguru.homework.lesson9.level4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public Optional<Product> getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    public List<Product> findProducts(BigDecimal minPrice, BigDecimal maxPrice) {
        List<Product> resultList = new ArrayList<>();
        for (Product product : products) {
            if (isInRange(minPrice, maxPrice, product)) {
                resultList.add(product);
            }
        }
        return resultList;
    }

    private boolean isInRange(BigDecimal minPrice, BigDecimal maxPrice, Product product) {
        return product.getPrice().compareTo(minPrice) > 0 && product.getPrice().compareTo(maxPrice) < 0;
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
