package Bussiness.Validators;

import Bussiness.DeliveryService;
import Model.Client;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

class UsernameValidator implements Serializable {
    private static UsernameValidator singleInstance = new UsernameValidator();

    public static UsernameValidator getValidator() {
        return singleInstance;
    }

    protected void validate(String username){
        if(username.equals("admin")){
            JOptionPane.showMessageDialog(null, "Not a valid username.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new IllegalArgumentException("Not a valid username.");
        }

        DeliveryService deliveryService = DeliveryService.getInstance();
        for(Client client: deliveryService.getClients()){
            if(username.equals(client.getUsername())){
                JOptionPane.showMessageDialog(null, "Username already in use.", "Error", JOptionPane.ERROR_MESSAGE);
                throw new IllegalArgumentException("Username already in use.");
            }
        }
    }
}
