package tacoLoco.model;

public class Total {
    private double total;
    private int numberOrdered;
    private boolean discount = false;

    public Total(){}

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNumberOrdered() {
        return numberOrdered;
    }

    public void setNumberOrdered(int numberOrdered) {
        this.numberOrdered = numberOrdered;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }
}
