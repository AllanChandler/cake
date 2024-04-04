package app.entities;

public class Bund {

    private String bundName;
    private double bundPrice;

    public Bund(String bundName, double bundPrice) {

        this.bundName = bundName;
        this.bundPrice = bundPrice;
    }

    public String getBundName() {
        return bundName;
    }

    public void setBundName(String bundName) {
        this.bundName = bundName;
    }

    public double getBundPrice() {
        return bundPrice;
    }

    public void setBundPrice(double bundPrice) {
        this.bundPrice = bundPrice;
    }

    public String toString() {
        return "Bund{" +
                ", bundName='" + bundName + '\'' +
                ", bundPrice=" + bundPrice +
                '}';
    }

}
