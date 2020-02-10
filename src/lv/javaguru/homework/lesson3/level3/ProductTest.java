package lv.javaguru.homework.lesson3.level3;

public class ProductTest {
    public static void main(String[] args) {

        Product product = new Product();
        product.setName("milk");
        product.setRegularPrice(0.8);
        product.setDiscount(20);

        product.printInformation();
    }
}
