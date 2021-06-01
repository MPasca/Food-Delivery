package Data;

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime date;
    private boolean isPlaced = false;

    private int clientId;
    private int orderId;

    private double totalPrice = 0;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getId() {
        return orderId;
    }

    public void setId(int orderId) {
        this.orderId = orderId;
    }

    public void placeOrder(){
        date = LocalDateTime.now();
        isPlaced = true;
    }

    public LocalDateTime getDate(){
        if(isPlaced){
            return date;
        }
        else{
            return null;
        }
    }

    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice(){
        return totalPrice;
    }

}