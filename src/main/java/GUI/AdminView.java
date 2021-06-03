package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminView {
    private static AdminView adminView = new AdminView();
    public static AdminView getInstance(){
        return adminView;
    }

    public JFrame frameAdmin = new JFrame();
    public JPanel panelAdmin = new JPanel();

    // ----- main Panel
    public JPanel panelMain = new JPanel();
    public JButton btnBack = new JButton("Back");                       // listener

    JLabel lblTitle = new JLabel("Administrator");

    public JPanel panelMenu = new JPanel(new GridLayout(2, 2));
        public JButton btnManage = new JButton("Manage products");      // listener
        public JButton btnMenu = new JButton("Create menu");            // listener
        public JButton btnReport = new JButton("Generate reports");
        public JButton btnLogout = new JButton("Log out");              // listener

    // ----- view products
    public JPanel panelTableProd = new JPanel();
        public JTable tableProducts = new JTable();

    // ----- manage Panel
    public JPanel panelManage = new JPanel();                                   // not visible
        JLabel lblManage = new JLabel("Manage products");

        JPanel panelManageButtons = new JPanel(new GridLayout(2, 2));
            public JButton btnAdd = new JButton("Add product");         // listener
            public JButton btnImport = new JButton("Import products");  // listener
            public JButton btnRemove = new JButton("Remove product");   // listener
            public JButton btnModify = new JButton("Modify product");   // listener


    // ----- create menu Panel
    public JPanel panelCompProd = new JPanel();                                 // not visible
        JLabel lblCompProd = new JLabel("Add order");
        JPanel panelId = new JPanel();
            JLabel lblId = new JLabel("Id:");
            public JComboBox<Integer> cmbId = new JComboBox<>();
        public JTextField txtCompProdTitle = new JTextField("title");
        public JTextField txtCompProdPrice = new JTextField("price");
        public JButton btnAddToComp = new JButton("Add product");
        public JButton btnCreate = new JButton("Place order");              // listener

    // ----- add Product Panel                                                  // not visible
    public JPanel panelAdd = new JPanel();
        JLabel lblAdd = new JLabel("Add product");

        public JTextField txtTitle = new JTextField("Title");
        public JTextField txtPrice = new JTextField("Price");
        public JTextField txtCalories = new JTextField("Calories");
        public JTextField txtProtein = new JTextField("Protein");
        public JTextField txtFat = new JTextField("Fat");
        public JTextField txtSodium = new JTextField("Sodium");

        public JButton btnAddProduct = new JButton("Add");                  // listener

    // ----- remove Product Panel                                               // not visible
    public JPanel panelRemove = new JPanel();
        JLabel lblRemove = new JLabel("Remove Product");
        public JTextField txtRemove = new JTextField("product id");
        public JButton btnRemoveProduct = new JButton("Remove");            // listener

    // ----- add Modify Panel                                                  // not visible
    public JPanel panelModify = new JPanel();
        JLabel lblModify = new JLabel("Modify product");

        public JTextField txtModId = new JTextField("Product id");
        public JTextField txtModTitle = new JTextField("Title");
        public JTextField txtModPrice = new JTextField("Price");
        public JTextField txtModCalories = new JTextField("Calories");
        public JTextField txtModProtein = new JTextField("Protein");
        public JTextField txtModFat = new JTextField("Fat");
        public JTextField txtModSodium = new JTextField("Sodium");

    public JButton btnModifyProduct = new JButton("Modify");                // listener

    // ----- generate reports Panel
    public JPanel panelReport = new JPanel();                                   // not visible
        JLabel lblReport = new JLabel("Generate reports");
        public JTextField txtTimesOrdered = new JTextField("times ordered");
        public JComboBox cmbOptions = new JComboBox();
        public JButton btnGenerateReport = new JButton("Generate report");
        public JTextField txtMinPrice = new JTextField("minimal order value");
        public JTextField txtTimeBegin = new JTextField("start time");
        public JTextField txtTimeEnd = new JTextField("end time");
        public JTextField txtDate = new JTextField("date");

        public Elements elements = new Elements();

    public AdminView(){

        frameAdmin.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameAdmin.setSize(1000, 600);

// ------------------------ MAIN MENU
        panelMain.setBackground(elements.colours.get(4));

        lblTitle.setForeground(elements.colours.get(0));
        lblTitle.setFont(elements.fonts.get(1));
        lblTitle.setAlignmentX(0.5f);

        btnManage.setFont(elements.fonts.get(0));
        btnManage.setForeground(elements.colours.get(3));

        btnMenu.setFont(elements.fonts.get(0));
        btnMenu.setForeground(elements.colours.get(3));

        btnReport.setFont(elements.fonts.get(0));
        btnReport.setForeground(elements.colours.get(3));

        btnLogout.setFont(elements.fonts.get(0));
        btnLogout.setForeground(elements.colours.get(3));

        panelMenu.setBackground(elements.colours.get(4));
            panelMenu.add(btnManage);
            panelMenu.add(btnMenu);
            panelMenu.add(btnReport);
            panelMenu.add(btnLogout);
        panelMenu.setBorder(new EmptyBorder(40, 30, 40, 30));

// ------------------------ MANAGE PRODUCTS
        lblManage.setForeground(elements.colours.get(1));
        lblManage.setFont(elements.fonts.get(1));
        lblManage.setAlignmentX(0.5f);

        btnAdd.setFont(elements.fonts.get(0));
        btnAdd.setForeground(elements.colours.get(3));

        btnRemove.setFont(elements.fonts.get(0));
        btnRemove.setForeground(elements.colours.get(3));

        btnModify.setFont(elements.fonts.get(0));
        btnModify.setForeground(elements.colours.get(3));

        btnImport.setFont(elements.fonts.get(0));
        btnLogout.setForeground(elements.colours.get(3));

        panelManageButtons.setBackground(elements.colours.get(4));
            panelManageButtons.add(btnAdd);
            panelManageButtons.add(btnImport);
            panelManageButtons.add(btnRemove);
            panelManageButtons.add(btnModify);

        panelManage.add(lblManage);
        panelManage.add(panelManageButtons);
        panelManage.setLayout(new BoxLayout(panelManage, BoxLayout.Y_AXIS));

        panelManage.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelManage.setVisible(false);

// ------------------------ ADD PRODUCT
        lblAdd.setForeground(elements.colours.get(1));
        lblAdd.setFont(elements.fonts.get(1));
        lblAdd.setAlignmentX(0.5f);

        txtTitle.setFont(elements.fonts.get(0));
        txtTitle.setColumns(30);
        txtTitle.setMaximumSize(new Dimension(200, 20));

        txtPrice.setFont(elements.fonts.get(0));
        txtPrice.setColumns(30);
        txtPrice.setMaximumSize(new Dimension(200, 20));

        txtCalories.setFont(elements.fonts.get(0));
        txtCalories.setColumns(30);
        txtCalories.setMaximumSize(new Dimension(200, 20));

        txtProtein.setFont(elements.fonts.get(0));
        txtProtein.setColumns(30);
        txtProtein.setMaximumSize(new Dimension(200, 20));

        txtFat.setFont(elements.fonts.get(0));
        txtFat.setColumns(30);
        txtFat.setMaximumSize(new Dimension(200, 20));

        txtSodium.setFont(elements.fonts.get(0));
        txtSodium.setColumns(30);
        txtSodium.setMaximumSize(new Dimension(200, 20));

        btnAddProduct.setFont(elements.fonts.get(0));
        btnAddProduct.setForeground(elements.colours.get(3));
        btnAddProduct.setAlignmentX(0.5f);

        panelAdd.add(lblAdd);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtTitle);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtPrice);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtCalories);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtProtein);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtFat);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(txtSodium);
            panelAdd.add(new JLabel(" "));
        panelAdd.add(btnAddProduct);
            panelAdd.add(new JLabel(" "));
        panelAdd.setBackground(elements.colours.get(4));
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));

        panelAdd.setVisible(false);

// ------------------------ REMOVE PRODUCT
        lblRemove.setForeground(elements.colours.get(1));
        lblRemove.setFont(elements.fonts.get(1));
        lblRemove.setAlignmentX(0.5f);

        txtRemove.setFont(elements.fonts.get(0));
        txtRemove.setColumns(30);
        txtRemove.setMaximumSize(new Dimension(200, 20));

        btnRemoveProduct.setFont(elements.fonts.get(0));
        btnRemoveProduct.setForeground(elements.colours.get(3));
        btnRemoveProduct.setAlignmentX(0.5f);

        panelRemove.add(lblRemove);
            panelRemove.add(new JLabel(" "));
        panelRemove.add(txtRemove);
            panelRemove.add(new JLabel(" "));
        panelRemove.add(btnRemoveProduct);
        panelRemove.setBackground(elements.colours.get(4));
        panelRemove.setLayout(new BoxLayout(panelRemove, BoxLayout.Y_AXIS));

        panelRemove.setVisible(false);

// ------------------------ MODIFY PRODUCT
        lblModify.setForeground(elements.colours.get(1));
        lblModify.setFont(elements.fonts.get(1));
        lblModify.setAlignmentX(0.5f);

        txtModId.setFont(elements.fonts.get(0));
        txtModId.setColumns(30);
        txtModId.setMaximumSize(new Dimension(200, 20));

        txtModTitle.setFont(elements.fonts.get(0));
        txtModTitle.setColumns(30);
        txtModTitle.setMaximumSize(new Dimension(200, 20));

        txtModPrice.setFont(elements.fonts.get(0));
        txtModPrice.setColumns(30);
        txtModPrice.setMaximumSize(new Dimension(200, 20));

        txtModCalories.setFont(elements.fonts.get(0));
        txtModCalories.setColumns(30);
        txtModCalories.setMaximumSize(new Dimension(200, 20));

        txtModProtein.setFont(elements.fonts.get(0));
        txtModProtein.setColumns(30);
        txtModProtein.setMaximumSize(new Dimension(200, 20));

        txtModFat.setFont(elements.fonts.get(0));
        txtModFat.setColumns(30);
        txtModFat.setMaximumSize(new Dimension(200, 20));

        txtModSodium.setFont(elements.fonts.get(0));
        txtModSodium.setColumns(30);
        txtModSodium.setMaximumSize(new Dimension(200, 20));

        btnModifyProduct.setFont(elements.fonts.get(0));
        btnModifyProduct.setForeground(elements.colours.get(3));
        btnModifyProduct.setAlignmentX(0.5f);

        panelModify.add(lblModify);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModId);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModTitle);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModPrice);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModCalories);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModProtein);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModFat);
            panelModify.add(new JLabel(" "));
        panelModify.add(txtModSodium);
            panelModify.add(new JLabel(" "));
        panelModify.add(btnModifyProduct);
            panelModify.add(new JLabel(" "));
        panelModify.setBackground(elements.colours.get(4));
        panelModify.setLayout(new BoxLayout(panelModify, BoxLayout.Y_AXIS));

        panelModify.setVisible(false);

// ------------------------ CREATE COMPOSITE ITEM
        btnAddToComp.setFont(elements.fonts.get(0));
        btnAddToComp.setForeground(elements.colours.get(3));

        btnCreate.setFont(elements.fonts.get(0));
        btnCreate.setForeground(elements.colours.get(3));

        lblCompProd.setForeground(elements.colours.get(1));
        lblCompProd.setFont(elements.fonts.get(1));
        lblCompProd.setAlignmentX(0.5f);

        panelId.setBackground(elements.colours.get(4));
            lblId.setFont(elements.fonts.get(0));
            lblId.setForeground(elements.colours.get(1));
            cmbId.setFont(elements.fonts.get(0));
            cmbId.setForeground(elements.colours.get(3));
        panelId.add(lblId);
        panelId.add(cmbId);

        txtCompProdTitle.setFont(elements.fonts.get(0));
        txtCompProdTitle.setColumns(30);
        txtCompProdTitle.setMaximumSize(new Dimension(200, 20));

        txtCompProdPrice.setFont(elements.fonts.get(0));
        txtCompProdPrice.setColumns(30);
        txtCompProdPrice.setMaximumSize(new Dimension(200, 20));

        panelCompProd.setBackground(elements.colours.get(4));
            panelCompProd.add(lblAdd);
                panelCompProd.add(new JLabel(" "));
            panelCompProd.add(panelId);
                panelCompProd.add(new JLabel(" "));
            panelCompProd.add(btnAddToComp);
                panelCompProd.add(new JLabel(" "));
            panelCompProd.add(txtCompProdTitle);
                panelCompProd.add(new JLabel(" "));
            panelCompProd.add(txtCompProdPrice);
                panelCompProd.add(new JLabel(" "));
            panelCompProd.add(btnCreate);
        panelCompProd.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelCompProd.setLayout(new BoxLayout(panelCompProd, BoxLayout.Y_AXIS));

        panelCompProd.setVisible(false);

// ------------------------ GENERATE REPORTS
        btnGenerateReport.setFont(elements.fonts.get(0));
        btnGenerateReport.setForeground(elements.colours.get(3));

        lblReport.setForeground(elements.colours.get(1));
        lblReport.setFont(elements.fonts.get(1));
        lblReport.setAlignmentX(0.5f);

        txtTimesOrdered.setFont(elements.fonts.get(0));
        txtTimesOrdered.setColumns(30);
        txtTimesOrdered.setMaximumSize(new Dimension(200, 20));

        txtMinPrice.setFont(elements.fonts.get(0));
        txtMinPrice.setColumns(30);
        txtMinPrice.setMaximumSize(new Dimension(200, 20));

        txtTimeBegin.setFont(elements.fonts.get(0));
        txtTimeBegin.setColumns(30);
        txtTimeBegin.setMaximumSize(new Dimension(200, 20));

        txtTimeEnd.setFont(elements.fonts.get(0));
        txtTimeEnd.setColumns(30);
        txtTimeEnd.setMaximumSize(new Dimension(200, 20));

        txtDate.setFont(elements.fonts.get(0));
        txtDate.setColumns(30);
        txtDate.setMaximumSize(new Dimension(200, 20));

        cmbOptions.setFont(elements.fonts.get(0));
        cmbOptions.setForeground(elements.colours.get(3));

        panelReport.setBackground(elements.colours.get(4));
            panelReport.add(lblReport);
                panelReport.add(new JLabel(" "));
            panelReport.add(txtTimesOrdered);
                panelReport.add(new JLabel(" "));
            panelReport.add(txtMinPrice);
                panelReport.add(new JLabel(" "));
            panelReport.add(txtTimeBegin);
                panelReport.add(new JLabel(" "));
            panelReport.add(txtTimeEnd);
                panelReport.add(new JLabel(" "));
            panelReport.add(txtDate);
                panelReport.add(new JLabel(" "));
            panelReport.add(cmbOptions);
                panelReport.add(new JLabel(" "));
            panelReport.add(btnGenerateReport);
        panelReport.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelReport.setLayout(new BoxLayout(panelReport, BoxLayout.Y_AXIS));

        panelCompProd.setVisible(false);

// ------------------------ MAIN FRAME
        btnBack.setFont(elements.fonts.get(0));
        btnBack.setForeground(elements.colours.get(3));
        btnBack.setAlignmentX(0.5f);

        panelMain.add(lblTitle);
        panelMain.add(panelMenu);
        panelMain.add(panelManage);
        panelMain.add(panelAdd);
        panelMain.add(panelRemove);
        panelMain.add(panelModify);
        panelMain.add(panelCompProd);
        panelMain.add(panelReport);

        panelMain.add(btnBack);
        panelMain.setBorder(new EmptyBorder(20, 0, 20, 0));

        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelAdmin.add(panelMain);

        tableProducts.setSize(new Dimension(1000, 400));
        panelTableProd.add(tableProducts);
        panelAdmin.add(panelTableProd);

        frameAdmin.add(panelAdmin);
        frameAdmin.setVisible(true);
    }
}
