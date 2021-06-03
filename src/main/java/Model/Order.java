package Model;

import Bussiness.DeliveryService;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Observable;

/**
 * The type Order.
 */
public class Order extends Observable implements Serializable {
    private LocalDateTime date;
    private boolean isPlaced = false;

    private int clientId;
    private int orderId;

    private double totalPrice = 0;

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return orderId;
    }

    /**
     * Sets id.
     *
     * @param orderId the order id
     */
    public void setId(int orderId) {
        this.orderId = orderId;
    }

    /**
     * Place order.
     */
    public void placeOrder(){
        date = LocalDateTime.now();
        isPlaced = true;
    }

    /**
     * Get date time local date time.
     *
     * @return the local date time
     */
    public LocalDateTime getDateTime(){
        if(isPlaced){
            return date;
        }
        else{
            return null;
        }
    }

    /**
     * Set total price.
     *
     * @param totalPrice the total price
     */
    public void setTotalPrice(double totalPrice){
        this.totalPrice = totalPrice;
    }

    /**
     * Get total price double.
     *
     * @return the double
     */
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public LocalTime getTime() {
        return LocalTime.of(date.getHour(), date.getMinute(), date.getSecond());
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return LocalDate.of(date.getYear(), date.getMonth(), date.getDayOfMonth());
    }

    @Override
    public int hashCode(){
        return orderId;
    }

    @Override
    public boolean equals(Object otherOrder){
        if(((Order)otherOrder).getId() == orderId){
            return true;
        }
        return false;
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss, dd/MM/yyyy");

        String result = "Order no #" + orderId + "\n";
        result += formatter.format(date) + "\n";
        result += "Client id #" + clientId + "\n";
        result += "Total price: " + totalPrice + "\n";

        return result;
    }

}
