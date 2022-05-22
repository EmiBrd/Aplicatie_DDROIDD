package business;

import java.util.ArrayList;
import java.util.List;

public class CatalogOfProducts {

    private static final List<Product> productList = new ArrayList<>();

    public static List<Product> getProductList() {
        return productList;
    }

    public static void loadProductList(){
        Product product1 = new Product(NamesOfItems.MOUSE, 10.99, ShippedFrom.RO, 0.2, 20);
        Product product2 = new Product(NamesOfItems.KEYBOARD, 40.99, ShippedFrom.UK, 0.7, 25);
        Product product3 = new Product(NamesOfItems.MONITOR, 164.99, ShippedFrom.US, 1.9, 15);
        Product product4 = new Product(NamesOfItems.WEBCAM, 84.99, ShippedFrom.RO, 0.2, 18);
        Product product5 = new Product(NamesOfItems.HEADPHONES, 59.99, ShippedFrom.US, 0.6, 50);
        Product product6 = new Product(NamesOfItems.DESK_LAMP, 89.99, ShippedFrom.UK, 1.3, 14);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
    }

    public static void displayCatalogOfProducts(){
        for(Product product: productList){
            System.out.println(product.getName() + " - $" + product.getPrice());
        }
        System.out.println();
    }

}
