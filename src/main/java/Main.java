import business.CatalogOfProducts;
import business.ShoppingCart;

public class Main {

    public static void main(String[] args) {

        // 1
        CatalogOfProducts.loadProductList();
        CatalogOfProducts.displayCatalogOfProducts();

        // 2
        ShoppingCart shoppingCart = new ShoppingCart(false);

        shoppingCart.addToCart(CatalogOfProducts.getProductList().get(0));
        shoppingCart.addToCart(CatalogOfProducts.getProductList().get(2));
        shoppingCart.addToCart(CatalogOfProducts.getProductList().get(2));

        shoppingCart.displayShoppingCart();

        // scoatere produse din shopping cart
//        shoppingCart.removeFromCart(CatalogOfProducts.getProductList().get(0));
//        shoppingCart.removeFromCart(CatalogOfProducts.getProductList().get(0));
//        shoppingCart.removeFromCart(CatalogOfProducts.getProductList().get(2));
//        shoppingCart.removeFromCart(CatalogOfProducts.getProductList().get(2));
//        shoppingCart.displayShoppingCart();


        // 3
        shoppingCart.displayInvoice();
        System.out.println();

        // Extra
        // 1, 2, 3
        ShoppingCart shoppingCart2 = new ShoppingCart(true);

        shoppingCart2.addToCart(CatalogOfProducts.getProductList().get(1));
        shoppingCart2.addToCart(CatalogOfProducts.getProductList().get(2));
        shoppingCart2.addToCart(CatalogOfProducts.getProductList().get(2));

        shoppingCart2.displayShoppingCart();
        shoppingCart2.displayInvoice();


    }

}
