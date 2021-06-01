package Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Order implements Serializable {
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

    public LocalTime getTime() {
        return LocalTime.of(date.getHour(), date.getMinute(), date.getSecond());
    }
}
