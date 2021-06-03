package GUI.Controller;

import Bussiness.DeliveryService;
import Data.Serialization;
import GUI.ClientView;
import Model.MenuItem;
import Model.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ClientController implements Controller{
    private static ClientController clientController = new ClientController();
    public static ClientController getInstance(){
        return clientController;
    }

    public ClientView clientView;

    public List<MenuItem> newOrder = new ArrayList<>();

    public ClientController(){
        clientView = ClientView.getInstance();

        clientView.btnRefresh.addActionListener(new RefreshListener());
        clientView.btnAdd.addActionListener(new AddListener());
        clientView.btnFinish.addActionListener(new PlaceOrderListener());
        clientView.btnSearch.addActionListener(new SearchListener());
        clientView.btnLogout.addActionListener(new LogoutListener());

        final CloseAction closeAction = new CloseAction(clientView.frameClient);
        clientView.frameClient.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeAction.confirmClosing();
            }
        });
    }

    public class RefreshListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            populateComboBox();
            populateTable();
        }
    }

    public class AddListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("in add listener");
            System.out.println(clientView.cmbId.getSelectedItem());
            newOrder.add(DeliveryService.getInstance().findById((Integer) clientView.cmbId.getSelectedItem()));

        }
    }

    public class PlaceOrderListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String confirmOrder = "Your order:\n";
            for(MenuItem item: newOrder){
                confirmOrder += item.toString() + "\n";
            }

            int confirmed = JOptionPane.showConfirmDialog(null, confirmOrder, "Confirm order", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                DeliveryService.getInstance().newOrder(LoginController.getInstance().currentClient, newOrder);
                JOptionPane.showMessageDialog(null, "Order placed successfully!");
                newOrder.removeAll(newOrder);
            }
        }
    }

    public class SearchListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                checkInput();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public class LogoutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginController loginController = LoginController.getInstance();
            clientView.frameClient.setVisible(false);
            loginController.loginView.frameMain.setVisible(true);
        }
    }


    @Override
    public Object checkInput() throws Exception {
        String keyword = clientView.txtKeyword.getText();
        if(keyword.equals(" ")){
            //String rating = clientView.txtRating.getText();
            //if(rating.equals(" ")){
                JOptionPane.showMessageDialog(null, "There is no search parameter", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("No search parameter");
            //}
            //searchByRating(Double.parseDouble(rating));
        }
        searchByKeyword(keyword);
        return null;
    }

    public void searchByRating(Double rating){
        List<MenuItem> searchedItems = DeliveryService.getInstance().fetchMenuItems().stream().filter(t-> t.getRating() >= rating).collect(toList());
        String productsColumns[] = {"ID", "Title", "Rating", "Price", "Calories", "Protein", "Fat", "Sodium"};
        DefaultTableModel model = new DefaultTableModel(productsColumns, 0);
        clientView.tableProducts.setModel(model);


        for(MenuItem item: searchedItems){
            String[] currentProduct = {
                    Integer.toString(item.getId()), item.getTitle(), Double.toString(item.getPrice()),
                    Double.toString(item.getRating()), Integer.toString(item.getCalories()), Integer.toString(item.getProtein()),
                    Integer.toString(item.getFat()), Integer.toString(item.getSodium())
            };
            model.addRow(currentProduct);
        }

        clientView.tableProducts.setBounds(20, 20, 800, 200);
        JScrollPane scrollPane = new JScrollPane(clientView.tableProducts);
        clientView.panelTableProd.add(scrollPane);
    }

    public void searchByKeyword(String keyword){
        List<MenuItem> searchedItems = DeliveryService.getInstance().fetchMenuItems().stream().filter(t-> t.getTitle().toLowerCase().contains(keyword.toLowerCase())).collect(toList());
        String productsColumns[] = {"ID", "Title", "Rating", "Price", "Calories", "Protein", "Fat", "Sodium"};
        DefaultTableModel model = new DefaultTableModel(productsColumns, 0);
        clientView.tableProducts.setModel(model);


        for(MenuItem item: searchedItems){
            String[] currentProduct = {
                    Integer.toString(item.getId()), item.getTitle(), Double.toString(item.getPrice()),
                    Double.toString(item.getRating()), Integer.toString(item.getCalories()), Integer.toString(item.getProtein()),
                    Integer.toString(item.getFat()), Integer.toString(item.getSodium())
            };
            model.addRow(currentProduct);
        }

        clientView.tableProducts.setBounds(20, 20, 800, 200);
        JScrollPane scrollPane = new JScrollPane(clientView.tableProducts);
        clientView.panelTableProd.add(scrollPane);
    }

    public void populateComboBox(){
        DeliveryService.getInstance().importProducts();
        List<MenuItem> products = DeliveryService.getInstance().fetchMenuItems();
        for(MenuItem item: products){
            clientView.cmbId.addItem(item.getId());
        }
    }

    public void populateTable(){
        DeliveryService.getInstance().importProducts();
        String productsColumns[] = {"ID", "Title", "Rating", "Price", "Calories", "Protein", "Fat", "Sodium"};
        DefaultTableModel model = new DefaultTableModel(productsColumns, 0);
        clientView.tableProducts.setModel(model);

        List<MenuItem> allItems = DeliveryService.getInstance().fetchMenuItems();
        for(MenuItem item: allItems){
            String[] currentProduct = {
                    Integer.toString(item.getId()), item.getTitle(), Double.toString(item.getPrice()),
                    Double.toString(item.getRating()), Integer.toString(item.getCalories()), Integer.toString(item.getProtein()),
                    Integer.toString(item.getFat()), Integer.toString(item.getSodium())
            };
            model.addRow(currentProduct);
        }

        clientView.tableProducts.setBounds(20, 20, 800, 200);
        JScrollPane scrollPane = new JScrollPane(clientView.tableProducts);
        clientView.panelTableProd.add(scrollPane);
    }
}
