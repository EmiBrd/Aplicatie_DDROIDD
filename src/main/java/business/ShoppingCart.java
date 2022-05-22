package business;

import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private Map<NamesOfItems, Product> productMap;
    // Extra 1
    private boolean specialOffer;

    public ShoppingCart(boolean specialOffer1) {
        this.productMap = new HashMap<>();
        this.specialOffer = specialOffer1;
    }

    // adaugare produs in shopping cart
    public void addToCart(Product product){
        // daca produsul e in cosulet, crestem cantitatea acelui produs cu 1
        if(productMap.get(product.getName()) != null)
            productMap.get(product.getName()).setQuantity(productMap.get(product.getName()).getQuantity() + 1);

        // daca produsul nu e in cosulet, il introducem cu cantitatea 1
        else
            productMap.put(product.getName(), new Product(product.getName(), product.getPrice(), product.getShippedFrom(),
                    product.getWeight(), 1));

        // scadem cu 1 cantitatea produsului din magazin
        product.setQuantity(product.getQuantity() - 1);
    }

    // scoatere produs din shopping cart
    public void removeFromCart(Product product) {
        // daca produsul nu exista in cosuletul de cumparaturi, aruncam o exceptie sugestiva ca programul sa poata
        // rula in continuare
        if(!productMap.containsKey(product.getName())){
            try {
                throw new Exception("Product doesn't exist");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // verific daca produsul exista in cosuletul de cumparaturi
        if(productMap.get(product.getName()) != null){
            // decrementam cantitatea produsului cu 1
            productMap.get(product.getName()).setQuantity(productMap.get(product.getName()).getQuantity() - 1);

            // daca, dupa decrementare, cantitate este 0, scoatem produsul din hashMap
            if(productMap.get(product.getName()).getQuantity() <= 0)
                productMap.remove(product.getName());

            // incrementam cu 1 cantitatea produsului din magazin
            product.setQuantity(product.getQuantity() + 1);
        }
    }

    // afisare produse din shopping cart
    public void displayShoppingCart(){
        for(Map.Entry<NamesOfItems, Product> entry: productMap.entrySet()){
            System.out.println(entry.getValue());
        }
        System.out.println();
    }

    // Extra 3
    // calculare VAT
    public double calculateVAT(){
        final double VAT = 0.19;
        double valueOfVAT = 0;
        for(Map.Entry<NamesOfItems, Product> entry: productMap.entrySet()) {
            valueOfVAT += entry.getValue().getPrice() * entry.getValue().getQuantity() * VAT;
        }
        return  valueOfVAT;
    }

    // calculare pret subtotal
    public double calculateSubtotalPrice(boolean specialOffer1){
        double subtotalPrice = 0;

        for(Map.Entry<NamesOfItems, Product> entry: productMap.entrySet()) {
            subtotalPrice += entry.getValue().getPrice() * entry.getValue().getQuantity();
        }

        if(specialOffer1 == true){
            if(productMap.containsKey(NamesOfItems.KEYBOARD))
                subtotalPrice -= productMap.get(NamesOfItems.KEYBOARD).getPrice() * 0.1 * productMap.get(NamesOfItems.KEYBOARD).getQuantity();

            if(productMap.containsKey(NamesOfItems.MONITOR) && productMap.get(NamesOfItems.KEYBOARD.MONITOR).getQuantity() >= 2 &&
                    productMap.containsKey(NamesOfItems.DESK_LAMP))
                subtotalPrice -= productMap.get(NamesOfItems.DESK_LAMP).getPrice() / 2;
        }
        return subtotalPrice;
    }

    // calculare rata de livrare
    public double calculateShippingRate(double weight, ShippedFrom shippedFrom){
        double rate = 0;
        // am aplicat regula de 3 simpla pentru fiecare dintre cele 3 cazuri
        if(shippedFrom.equals(ShippedFrom.RO))
            rate = weight * 10;

        if(shippedFrom.equals(ShippedFrom.UK))
            rate = weight * 10 * 2;

        if(shippedFrom.equals(ShippedFrom.US))
            rate = weight * 10 * 3;

        return rate;
    }

    // calculare pret de livrare
    public int calculateTotalShippingRate(boolean specialOffer1){
        int shippingCost = 0;

        for (Map.Entry<NamesOfItems, Product> entry : productMap.entrySet()) {
            shippingCost += (int) calculateShippingRate(entry.getValue().getWeight(), entry.getValue().getShippedFrom()) *
                    entry.getValue().getQuantity();
        }

        if(specialOffer1 == true){
            if(productMap.size() >= 2)
                shippingCost -= 10;

            if(shippingCost < 0)
                shippingCost = 0;
        }
        return shippingCost;
    }

    // afisare factura
    public void displayInvoice(){
        System.out.println("Generate invoice:");
        double valueOfVAT = calculateVAT();
        if(this.specialOffer == false) {
            double totalPrice = calculateSubtotalPrice(false) + calculateTotalShippingRate(false) + valueOfVAT;
            System.out.println("Subtotal: $" + this.calculateSubtotalPrice(false));
            System.out.println("Shipping: $" + this.calculateTotalShippingRate(false));
            System.out.println("VAT: $" + valueOfVAT);
            System.out.println("Total: $" + totalPrice);
        }
        // Extra 2
        else {
            double totalPrice = calculateSubtotalPrice(true) + calculateTotalShippingRate(true) + valueOfVAT;
            System.out.println("Subtotal: $" + this.calculateSubtotalPrice(false));
            System.out.println("Shipping: $" + this.calculateTotalShippingRate(false));
            System.out.println("VAT: $" + valueOfVAT);

            System.out.println("\nDiscounts:");
            if(productMap.containsKey("Keyboard"))
                System.out.println("10% off keyboards: -$4.09");
            if(productMap.size() >= 2)
                System.out.println("$10 off shipping: -$10");

            System.out.println("\nTotal: $" + totalPrice);
        }
        System.out.println();
    }



}
