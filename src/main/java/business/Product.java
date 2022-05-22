package business;

public class Product {

    //private long id;
    //private String name;
    private NamesOfItems name;
    private double price;
    private ShippedFrom shippedFrom;
    private double weight;
    private int quantity;

    public Product(NamesOfItems name, double price, ShippedFrom shippedFrom, double weight, int quantity) {
        this.name = name;
        this.price = price;
        this.shippedFrom = shippedFrom;
        this.weight = weight;
        this.quantity = quantity;
    }

    public NamesOfItems getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ShippedFrom getShippedFrom() {
        return shippedFrom;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public String toString() {
//        return "{" + "name=" + name + ", price=" + price + ", shippedFrom=" + shippedFrom +
//                ", weight=" + weight + ", quantity=" + quantity + "}";
//    }

    public String toString() {
        return name + " x " + quantity;
    }

}
