package lv.javaguru.homework.lesson11.level1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        //šeit labāk izmanto forEach
        for (int i = 0; i < shoppingList.size(); i++) {
            if (shoppingList.get(i).getName().equals(name)) {
                shoppingList.remove(i);
            }
        }
    }

    public void printToConsole() {
        int i = 1;
        for (Product product : shoppingList) {
            System.out.println(i + ". " //"i" ir japalielina par 1
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

    public void saveListInFile(File file) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            for (Product product : shoppingList) {
                fileWriter.write(getFormattedString(product));
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }

    private String getFormattedString(Product product) {
        return product.getName() + "#-#"
                + product.getPrice() + "#-#"
                + product.getCategory() + "\n";
    }

    public void loadListFromFile(File file) {
        try {
            Product tempProduct;
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String[] data = myReader.nextLine().split("#-#");
                tempProduct = new Product(data[0], new BigDecimal(data[1]), Category.valueOf(data[2]));
                shoppingList.add(tempProduct);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

}
