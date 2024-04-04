package app.entities;

public class OrderLine {
    private int orderLineId;
    private int antal;
    private int price;
    private String topping;
    private String bund;


    public OrderLine(int orderLineId, int antal, int price, String topping, String bund) {
        this.orderLineId = orderLineId;
        this.antal = antal;
        this.price = price;
        this.topping = topping;
        this.bund = bund;
    }

    // Getters
    public int getOrderLineId() {
        return orderLineId;
    }

    public int getAntal() {
        return antal;
    }

    public int getPrice() {
        return price;
    }

    public String getTopping() {
        return topping;
    }

    public String getBund() {
        return bund;
    }


    // Setters
    public void setOrderLineId(int orderLineId) {
        this.orderLineId = orderLineId;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setBund(String bund) {
        this.bund = bund;
    }



    // toString method
    @Override
    public String toString() {
        return "OrderLine{" +
                "orderLineId=" + orderLineId +
                ", topping=" + topping +
                ", bund=" + bund +
                ", antal='" + antal + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}


