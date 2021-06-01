package GUI;

import javax.swing.*;

public class AdminView {
    private static AdminView adminView = new AdminView();
    public static AdminView getInstance(){
        return adminView;
    }

    public JFrame frameAdmin = new JFrame();

    // ----- main Panel
    JPanel panelMain = new JPanel();

    JLabel lblTitle = new JLabel("Administrator");

    JButton btnManage = new JButton("Manage products");
    JButton btnMenu = new JButton("Create menu");
    JButton btnReport = new JButton("Generate reports");
    JButton btnLogout = new JButton("Log out");

    // ----- manage Panel
    JPanel panelManage = new JPanel();

    JLabel lblManage = new JLabel("Manage products");

    JButton btnAdd = new JButton("Add product");
    JButton btnRemove = new JButton("Remove product");
    JButton btnModify = new JButton("Modify product");


    // ----- create menu Panel
    JPanel panelMenu = new JPanel();

    JLabel lblMenu = new JLabel("Create menu");

    JButton btnCreate = new JButton("Create");

    // ----- generate reports Panel
    JPanel panelReport = new JPanel();

    JLabel lblReport = new JLabel("Generate reports");

    JComboBox cmbOptions = new JComboBox();
    JTable tableReport = new JTable();

    public AdminView(){
        frameAdmin.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameAdmin.setSize(500, 600);
    }
}
