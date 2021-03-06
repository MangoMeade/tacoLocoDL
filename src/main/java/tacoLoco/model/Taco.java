package tacoLoco.model;

public class Taco {

    private String name;
    private double price;
    private int ordered;

    public Taco() {
    }

    public Taco(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
