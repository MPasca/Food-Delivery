package GUI.Controller;

import Bussiness.DeliveryService;
import GUI.AdminView;
import Model.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AdminController implements Controller{
    private static AdminController adminController = new AdminController();
    public static AdminController getInstance(){
        return adminController;
    }

    public AdminView adminView;

    public AdminController(){
        adminView = AdminView.getInstance();

        adminView.btnLogout.addActionListener(new LogoutListener());
        adminView.btnManage.addActionListener(new ManageListener());
        adminView.btnBack.addActionListener(new BackListener());
        adminView.btnAdd.addActionListener(new AddListener());
        adminView.btnRemove.addActionListener(new RemoveListener());
        adminView.btnModify.addActionListener(new ModifyListener());
        adminView.btnImport.addActionListener(new ImportListener());

        final CloseAction closeAction = new CloseAction(adminView.frameAdmin);
        adminView.frameAdmin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirmClosing();
            }
        });
    }

    @Override
    public Object checkInput() throws Exception {
        return null;
    }

    public class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            showProducts();
            adminView.panelManage.setVisible(false);
            adminView.panelCompProd.setVisible(false);
            adminView.panelReport.setVisible(false);
            adminView.panelAdd.setVisible(false);
            adminView.panelRemove.setVisible(false);
            adminView.panelModify.setVisible(false);

            adminView.panelMenu.setVisible(true);
        }
    }

    public class LogoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginController loginController = LoginController.getInstance();
            adminView.frameAdmin.setVisible(false);
            loginController.loginView.frameMain.setVisible(true);
        }
    }

    public class ManageListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.panelMenu.setVisible(false);
            adminView.panelManage.setVisible(true);
        }
    }

    public class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.panelManage.setVisible(false);
            adminView.panelAdd.setVisible(true);
        }
    }

    public class RemoveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.panelManage.setVisible(false);
            adminView.panelRemove.setVisible(true);
        }
    }

    public class ModifyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.panelModify.setVisible(true);
            adminView.panelManage.setVisible(false);
        }
    }

    public class ImportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DeliveryService.getInstance().importProducts();
            showProducts();
        }
    }

    public void showProducts(){
        String productsColumns[] = {"ID", "Title", "Rating", "Price", "Calories", "Protein", "Fat", "Sodium"};
        DefaultTableModel model = new DefaultTableModel(productsColumns, 0);
        adminView.tableProducts.setModel(model);

        List<MenuItem> allItems = DeliveryService.getInstance().fetchMenuItems();
        for(MenuItem item: allItems){
            String[] currentProduct = {
                    Integer.toString(item.getId()), item.getTitle(), Double.toString(item.getPrice()),
                    Double.toString(item.getRating()), Integer.toString(item.getCalories()), Integer.toString(item.getProtein()),
                    Integer.toString(item.getFat()), Integer.toString(item.getSodium())
            };
            model.addRow(currentProduct);
        }

        adminView.tableProducts.setBounds(20, 20, 800, 200);
        adminView.tableProducts.setFont(adminView.elements.fonts.get(3));
        JScrollPane scrollPane = new JScrollPane(adminView.tableProducts);
        adminView.panelTableProd.add(scrollPane);
    }
}
