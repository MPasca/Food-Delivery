package GUI;

import javax.swing.*;


public class ClientView {
    private static ClientView clientView = new ClientView();
    public static ClientView getInstance(){
        return clientView;
    }

    public JFrame frameClient = new JFrame();
    public JPanel panelMain = new JPanel();

    public ClientView(){
        frameClient.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameClient.setSize(300, 150);

        frameClient.setVisible(false);
    }
}
