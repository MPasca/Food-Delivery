package Data;

import java.util.ArrayList;
import java.util.List;

public class Client extends User{
    private int id;
    private String firstName;
    private String lastName;
    private String deliveryAddress;
    private String telephoneNumber;

    private List<Order> orderList = new ArrayList<>();

    public Client(String firstName, String lastName, String deliveryAddress, String telephoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.telephoneNumber = telephoneNumber;
    }


    public void createClient(String username, String password){
        if(username.equals("admin")){
            System.out.println("Unavailable username");
        }

        this.username = username;
        this.password = password;
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

    public int getId() {
        return id;
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
