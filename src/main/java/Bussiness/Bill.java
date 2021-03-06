package Bussiness;

import Model.*;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Bill implements Serializable {
    public void printBill(Order order, Client client, List<MenuItem> orderedItems){
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss, dd/MM/yyyy");
            FileWriter billWriter = new FileWriter("Bill #" + order.getId() + ".txt");

            billWriter.write("Order #" + order.getId() + "\n");
            billWriter.write(formatter.format(order.getDateTime()) + "\n");
            billWriter.write("_______________________________\n");

            billWriter.write("Client #" + client.getId() + "\n");
            billWriter.write("Name: " + client.getFirstName() + " " + client.getLastName() + "\n");
            billWriter.write("Telephone: " + client.getTelephoneNumber() + "\n");
            billWriter.write("Address: " + client.getDeliveryAddress() + "\n");
            billWriter.write("_______________________________\n");

            billWriter.write("Ordered items:\n");
            for(MenuItem item: orderedItems){
                billWriter.write(item.toString());
            }
            billWriter.write("_______________________________\n");

            billWriter.write("Total: " + order.getTotalPrice());
            billWriter.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "There has been an error printing the receipt.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
