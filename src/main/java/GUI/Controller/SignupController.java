package GUI.Controller;

import Bussiness.DeliveryService;
import GUI.SignupView;
import Model.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SignupController implements Controller{
    private static SignupController signupController = new SignupController();
    public static SignupController getInstance(){
        return signupController;
    }

    public SignupView signupView;
    public DeliveryService deliveryService;

    public SignupController(){
        signupView = SignupView.getInstance();
        deliveryService = DeliveryService.getInstance();

        signupView.btnSignup.addActionListener(new SignupListener());

        final CloseAction closeAction = new CloseAction(signupView.frameSignup);
        signupView.frameSignup.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirmClosing();
            }
        });

    }

    @Override
    public Object checkInput() throws Exception {
        String username = signupView.txtUsername.getText();
        String password = signupView.txtPassword.getText();
        String firstName = signupView.txtFirstName.getText();
        String lastName = signupView.txtLastName.getText();
        String telephone = signupView.txtTelephone.getText();
        String address = signupView.txtAddress.getText();

        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "The username is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Username field is empty");
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null, "The password is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Password field is empty");
        }
        if(firstName.equals("")){
            JOptionPane.showMessageDialog(null, "The firstName is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("firstName field is empty");
        }
        if(lastName.equals("")){
            JOptionPane.showMessageDialog(null, "The lastName is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("lastName field is empty");
        }
        if(telephone.equals("")){
            JOptionPane.showMessageDialog(null, "The telephone is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("telephone field is empty");
        }
        if(address.equals("")){
            JOptionPane.showMessageDialog(null, "The address is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("address field is empty");
        }


        return new Client(username, password, firstName, lastName, address, telephone);
    }

    public class SignupListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Client newClient = null;
            try {
                newClient = (Client) checkInput();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            deliveryService.createUser(newClient);
            if(newClient.getId() != 0){
                JOptionPane.showMessageDialog(null, "User created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                signupView.frameSignup.setVisible(false);
                LoginController loginController = LoginController.getInstance();
                loginController.loginView.frameMain.setVisible(true);
            }
        }
    }
}
