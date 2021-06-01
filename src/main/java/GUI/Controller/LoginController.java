package GUI.Controller;

import Bussiness.DeliveryService;
import Data.Serialization;
import GUI.ClientView;
import GUI.LoginView;
import Model.Admin;
import Model.Client;
import Model.User;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.List;

public class LoginController implements Controller{
    private static LoginController loginController = new LoginController();
    public static LoginController getInstance(){
        return loginController;
    }

    public LoginView loginView;
    private DeliveryService deliveryService;

    public LoginController(){

        this.loginView = LoginView.getInstance();
        this.deliveryService = DeliveryService.getInstance();

        loginView.btnLogin.addActionListener(new LoginListener());
        loginView.btnSignup.addActionListener(new SignupListener());

        final CloseAction closeAction = new CloseAction(loginView.frameMain);
        loginView.frameMain.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirmClosing();
            }
        });
    }

    @Override
    public User checkInput() throws Exception {
        String username = loginView.txtUsername.getText();
        String password = loginView.txtPassword.getText();
        if(username.equals("")){
            JOptionPane.showMessageDialog(null, "The username is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Username field is empty");
        }
        if(password.equals("")){
            JOptionPane.showMessageDialog(null, "The password is missing", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Password field is empty");
        }

        if(username.equals("admin")){
            if(password.equals("admin")){
                return new Admin();
            }
        }

        List<Client> clients = deliveryService.getClients();
        Client currentClient = null;
        for(Client client: clients){
            if(client.getUsername().equals(username)){
                currentClient = client;
                break;
            }
        }
        if(currentClient == null){
            JOptionPane.showMessageDialog(null, "This user does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("This user doesn't exist");
        }

        if(!currentClient.getPassword().equals(password)){
            JOptionPane.showMessageDialog(null, "Incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Wrong password");
        }

        return currentClient;
    }

    class LoginListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            User currentUser= null;
            try {
                currentUser = checkInput();
                if(currentUser != null){
                    loginView.frameMain.setVisible(false);
                    if(currentUser instanceof Client){
                        ClientController.getInstance().clientView.frameClient.setVisible(true);
                    }else if(currentUser instanceof Admin){
                        AdminController.getInstance().adminView.frameAdmin.setVisible(true);
                    }
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    class SignupListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SignupController signupController = SignupController.getInstance();
            loginView.frameMain.setVisible(false);
            signupController.signupView.frameSignup.setVisible(true);
        }
    }

    class CloseAction extends AbstractAction {
        private JFrame mainFrame;

        public CloseAction(JFrame mainFrame) {
            super("Exit");
            putValue(MNEMONIC_KEY, KeyEvent.VK_X);
            this.mainFrame = mainFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            confirmClosing();
        }

        public void confirmClosing() {
            int confirmed = JOptionPane.showConfirmDialog(mainFrame, "Are you sure you want to quit?", "Confirm quit", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                Serialization serialization = Serialization.getInstance();
                try {
                    serialization.exportData(deliveryService);
                    System.out.println("serialization ended");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }
}
