package GUI.Controller;

import Bussiness.DeliveryService;
import GUI.AdminView;
import Model.BaseProduct;
import Model.MenuItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AdminController implements Controller{
    private static AdminController adminController = new AdminController();
    public static AdminController getInstance(){
        return adminController;
    }

    public AdminView adminView;

    boolean isModify = false;

    List<BaseProduct> compProd = new ArrayList<>();

    public AdminController(){
        adminView = AdminView.getInstance();

        adminView.btnLogout.addActionListener(new LogoutListener());
        adminView.btnManage.addActionListener(new ManageListener());
        adminView.btnBack.addActionListener(new BackListener());
        adminView.btnAdd.addActionListener(new AddListener());
            adminView.btnAddProduct.addActionListener(new CreateProductListener());
        adminView.btnRemove.addActionListener(new RemoveListener());
            adminView.btnRemoveProduct.addActionListener(new RemoveProductListener());
        adminView.btnModify.addActionListener(new ModifyListener());
            adminView.btnModifyProduct.addActionListener(new ModifyProductListener());
        adminView.btnImport.addActionListener(new ImportListener());
        adminView.btnMenu.addActionListener(new GenerateCompProdListener());
            adminView.btnAddToComp.addActionListener(new AddToCompListener());
            adminView.btnCreate.addActionListener(new CreateCompProductListener());
        adminView.btnReport.addActionListener(new ReportListener());
            adminView.btnGenerateReport.addActionListener(new GenReportListener());

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
        if(!isModify){
            String title = adminView.txtTitle.getText();
            if(title.equals("Title") || title.equals("")){
                JOptionPane.showMessageDialog(null, "Title: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Title: incorrect input");
            }

            String calories = adminView.txtCalories.getText();
            if(calories.equals("Calories") || calories.equals("")){
                JOptionPane.showMessageDialog(null, "Calories: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Calories: incorrect input");
            }

            String protein = adminView.txtProtein.getText();
            if(protein.equals("Protein") || protein.equals("")){
                JOptionPane.showMessageDialog(null, "Protein: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Protein: incorrect input");
            }

            String fat = adminView.txtFat.getText();
            if(fat.equals("Fat") || fat.equals("")){
                JOptionPane.showMessageDialog(null, "Fat: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Fat: incorrect input");
            }

            String sodium = adminView.txtSodium.getText();
            if(sodium.equals("Sodium") || sodium.equals("")){
                JOptionPane.showMessageDialog(null, "Sodium: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Sodium: incorrect input");
            }

            String price = adminView.txtPrice.getText();
            if(price.equals("Price") || price.equals("")){
                JOptionPane.showMessageDialog(null, "Price: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
                throw new Exception("Price: incorrect input");
            }

            BaseProduct baseProduct = new BaseProduct(title, 0, Integer.parseInt(calories), Integer.parseInt(protein), Integer.parseInt(fat), Integer.parseInt(sodium), Double.parseDouble(price));
            DeliveryService.getInstance().addProduct(baseProduct);

            showProducts();
            return baseProduct;
        }

        String title = adminView.txtModTitle.getText();
        if(title.equals("Title") || title.equals("")){
            JOptionPane.showMessageDialog(null, "Title: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Title: incorrect input");
        }

        String calories = adminView.txtModCalories.getText();
        if(calories.equals("Calories") || calories.equals("")){
            JOptionPane.showMessageDialog(null, "Calories: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Calories: incorrect input");
        }

        String protein = adminView.txtModProtein.getText();
        if(protein.equals("Protein") || protein.equals("")){
            JOptionPane.showMessageDialog(null, "Protein: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Protein: incorrect input");
        }

        String fat = adminView.txtModFat.getText();
        if(fat.equals("Fat") || fat.equals("")){
            JOptionPane.showMessageDialog(null, "Fat: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Fat: incorrect input");
        }

        String sodium = adminView.txtModSodium.getText();
        if(sodium.equals("Sodium") || sodium.equals("")){
            JOptionPane.showMessageDialog(null, "Sodium: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Sodium: incorrect input");
        }

        String price = adminView.txtModPrice.getText();
        if(price.equals("Price") || price.equals("")){
            JOptionPane.showMessageDialog(null, "Price: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Price: incorrect input");
        }

        String id = adminView.txtModId.getText();
        if(id.equals("Id") || id.equals("")){
            JOptionPane.showMessageDialog(null, "Price: incorrect input", "Error", JOptionPane.ERROR_MESSAGE);
            throw new Exception("Price: incorrect input");
        }

        BaseProduct baseProduct = new BaseProduct(title, 0, Integer.parseInt(calories), Integer.parseInt(protein), Integer.parseInt(fat), Integer.parseInt(sodium), Double.parseDouble(price));
        DeliveryService.getInstance().modifyProduct(Integer.parseInt(id), baseProduct);

        showProducts();
        return baseProduct;
    }


    public class BackListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.panelManage.setVisible(false);
            adminView.panelCompProd.setVisible(false);
            adminView.panelReport.setVisible(false);
            adminView.panelAdd.setVisible(false);
            adminView.panelRemove.setVisible(false);
            adminView.panelModify.setVisible(false);
            adminView.panelCompProd.setVisible(false);
            adminView.panelReport.setVisible(false);

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

    public class AddToCompListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            compProd.add((BaseProduct) DeliveryService.getInstance().findById((Integer) adminView.cmbId.getSelectedItem()));
        }
    }

    public class CreateCompProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String confirmOrder = "The components:\n";
            for(MenuItem item: compProd){
                confirmOrder += item.toString() + "\n";
            }

            int confirmed = JOptionPane.showConfirmDialog(null, confirmOrder, "Confirm new product", JOptionPane.YES_NO_OPTION);
            if (confirmed == JOptionPane.YES_OPTION) {
                DeliveryService.getInstance().createCompositeProduct(compProd, adminView.txtCompProdTitle.getText(), Double.parseDouble(adminView.txtCompProdPrice.getText()));
                JOptionPane.showMessageDialog(null, "Product created successfully!");
                compProd.removeAll(compProd);
            }
        }
    }

    public class GenerateCompProdListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            populateComboBox();
            adminView.panelMenu.setVisible(false);
            adminView.panelCompProd.setVisible(true);
        }
    }

    public class CreateProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            isModify = false;
            try {
                checkInput();
                JOptionPane.showMessageDialog(null, "Product created successfully!", "Product created", JOptionPane.OK_OPTION);

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public class ModifyProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            isModify = true;
            try {
                checkInput();
                JOptionPane.showMessageDialog(null, "Product modified successfully!", "Product modification", JOptionPane.OK_OPTION);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public class RemoveProductListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            DeliveryService.getInstance().deleteProduct(Integer.parseInt(adminView.txtRemove.getText()));
            showProducts();
            JOptionPane.showMessageDialog(null, "Product removed successfully!", "Product removal", JOptionPane.OK_OPTION);
        }
    }

    public class ReportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            adminView.cmbOptions.addItem("TIME INTERVAL");
            adminView.cmbOptions.addItem("TIMES ORDERED");
            adminView.cmbOptions.addItem("CLIENTS");
            adminView.cmbOptions.addItem("DATE AND TIMES ORDERED");

            adminView.panelReport.setVisible(true);
            adminView.panelMenu.setVisible(false);
        }
    }

    public class GenReportListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String option = (String) adminView.cmbOptions.getSelectedItem();
            System.out.println(option);
            if(option.equals("TIMES ORDERED")){
                int timesOrdered = Integer.parseInt(adminView.txtTimesOrdered.getText());
                DeliveryService.getInstance().generateReportByTimesOrdered(timesOrdered);
            }
            else if(option.equals("CLIENTS")){
                int timesOrdered = Integer.parseInt(adminView.txtTimesOrdered.getText());
                double minPrice = Double.parseDouble(adminView.txtMinPrice.getText());
                DeliveryService.getInstance().generateClientsReport(timesOrdered, minPrice);
            }
            else if(option.equals("TIME INTERVAL")){
                LocalTime startTime = LocalTime.parse(adminView.txtTimeBegin.getText());
                LocalTime endTime = LocalTime.parse(adminView.txtTimeEnd.getText());
                DeliveryService.getInstance().generateReportByTimeInterval(startTime, endTime);
            }
            else if(option.equals("DATE AND TIMES ORDERED")){
                LocalDate date = LocalDate.parse(adminView.txtDate.getText());
                int timesOrdered = Integer.parseInt(adminView.txtTimesOrdered.getText());
                DeliveryService.getInstance().generateReportByDateAndTimesOrdered(date, timesOrdered);
            }
        }
    }

    public void populateComboBox(){
        List<MenuItem> allItems = DeliveryService.getInstance().fetchMenuItems();
        for(MenuItem item: allItems){
            adminView.cmbId.addItem(item.getId());;
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
