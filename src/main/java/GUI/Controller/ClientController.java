package GUI.Controller;

import GUI.ClientView;

public class ClientController implements Controller{
    private static ClientController clientController = new ClientController();
    public static ClientController getInstance(){
        return clientController;
    }

    public ClientView clientView;

    public ClientController(){
        clientView = ClientView.getInstance();
    }

    @Override
    public Object checkInput() throws Exception {
        return null;
    }
}
