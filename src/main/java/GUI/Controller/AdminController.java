package GUI.Controller;

import GUI.AdminView;

public class AdminController {
    private static AdminController adminController = new AdminController();
    public static AdminController getInstance(){
        return adminController;
    }

    public AdminView adminView;

    public AdminController(){
        adminView = AdminView.getInstance();
    }
}
