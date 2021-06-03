package Model;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String telephoneNumber;
    private int timesOrdered = 0;

    private List<Order> orderList = new ArrayList<>();

    public Client(String username, String password, String firstName, String lastName, String deliveryAddress, String telephoneNumber){
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public void incTimesOrdered(){
        timesOrdered++;
    }

    public int getNumberOfOrders() {
        return timesOrdered;
    }

    public void changePassword(String newPassword){
        this.password = newPassword;
    }

    public void addOrder(Order newOrder){
        orderList.add(newOrder);
    }

    public List<Order> fetchOrders(){
        return orderList;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }
}
