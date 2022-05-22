import static org.junit.Assert.*;

import business.NamesOfItems;
import business.Product;
import business.ShippedFrom;
import business.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

// 4
public class TestShippingCart {

    private ShoppingCart shoppingCart;
    private Product product;

    @Before
    public void setup(){
        this.shoppingCart = new ShoppingCart(false);
        this.product = new Product(NamesOfItems.MONITOR, 164.99, ShippedFrom.US, 1.9, 30);
    }

    @Test
    public void testSubtotalPrice(){
        // given
        Product product1 = new Product(NamesOfItems.MOUSE, 10.99, ShippedFrom.RO, 0.2, 40);
        shoppingCart.addToCart(product1);
        shoppingCart.addToCart(product);

        // when
        double expectedSubtotalPrice = this.product.getPrice() + product1.getPrice();
        double actualSubtotalPrice = shoppingCart.calculateSubtotalPrice(false);

        // then
        assertEquals(expectedSubtotalPrice, actualSubtotalPrice, 0.1);
    }

    @Test
    public void testTotalShippingCost(){
        // given
        Product product1 = new Product(NamesOfItems.MOUSE, 10.99, ShippedFrom.RO, 0.2, 40);
        shoppingCart.addToCart(product1);
        shoppingCart.addToCart(product);

        // when
        double shippingRate = shoppingCart.calculateShippingRate(this.product.getWeight(), this.product.getShippedFrom());
        double shippingRate1 = shoppingCart.calculateShippingRate(product1.getWeight(), product1.getShippedFrom());

        double expectedTotalShippingCost = shippingRate + shippingRate1;
        double actualTotalShippingCost = shoppingCart.calculateTotalShippingRate(false);

        // then
        assertEquals(expectedTotalShippingCost, actualTotalShippingCost, 0.1);
    }

    @Test
    public void testTotalPrice(){
        // given
        Product product1 = new Product(NamesOfItems.MOUSE, 10.99, ShippedFrom.RO, 0.2, 40);
        shoppingCart.addToCart(product1);
        shoppingCart.addToCart(product);
        final double VAT = 0.19;

        // when
        double subtotalPrice = shoppingCart.calculateSubtotalPrice(false);
        double calcVAT = shoppingCart.calculateVAT();

        double shippingRate = shoppingCart.calculateShippingRate(this.product.getWeight(), this.product.getShippedFrom());
        double shippingRate1 = shoppingCart.calculateShippingRate(product1.getWeight(), product1.getShippedFrom());

        double expectedTotalPrice = (this.product.getPrice() + product1.getPrice()) +
                (this.product.getPrice() + product1.getPrice()) * VAT;
        expectedTotalPrice += shippingRate + shippingRate1;

        double actualTotalPrice = subtotalPrice + shippingRate + shippingRate1 + calcVAT;

        // then
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.1);
    }

}
