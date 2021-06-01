package GUI;

import javax.swing.*;
import java.awt.*;

public class SignupView {
    private static SignupView signupView = new SignupView();
    public static SignupView getInstance(){
        return signupView;
    }

    public JLabel lblTitle = new JLabel("Create a new account");

    public JPanel panelUsername = new JPanel();
        public JLabel lblUsername = new JLabel("Username:");
        public JTextField txtUsername = new JTextField(10);

    public JPanel panelPassword = new JPanel();
        public JLabel lblPassword = new JLabel("Password:");
        public JTextField txtPassword = new JTextField(10);

    public JPanel panelFirstName = new JPanel();
        public JLabel lblFirstName = new JLabel("First Name:");
        public JTextField txtFirstName = new JTextField(10);

    public JPanel panelLastName = new JPanel();
        public JLabel lblLastName = new JLabel("Last Name:");
        public JTextField txtLastName = new JTextField(10);

    public JPanel panelTelephone = new JPanel();
        public JLabel lblTelephone = new JLabel("Telephone:");
        public JTextField txtTelephone = new JTextField(10);

    public JPanel panelAddress = new JPanel();
        public JLabel lblAddress = new JLabel("Address:");
        public JTextField txtAddress = new JTextField(10);

    public JButton btnSignup = new JButton("Sign up");

    public JPanel panelMain = new JPanel();
    public JFrame frameSignup = new JFrame();

    public SignupView(){
        Elements elements = new Elements();
        frameSignup.setSize(500, 600);
        //frameSignup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain.setBackground(elements.colours.get(4));

        lblTitle.setForeground(elements.colours.get(0));
        lblTitle.setFont(elements.fonts.get(1));
        lblTitle.setAlignmentX(0.5f);

        panelUsername.setBackground(elements.colours.get(4));
            lblUsername.setFont(elements.fonts.get(0));
            lblUsername.setForeground(elements.colours.get(1));
            txtUsername.setFont(elements.fonts.get(0));
            txtUsername.setColumns(30);
            txtUsername.setMaximumSize(new Dimension(200, 20));
            txtUsername.setForeground(elements.colours.get(3));
        panelUsername.add(lblUsername);
        panelUsername.add(txtUsername);


        panelPassword.setBackground(elements.colours.get(4));
            lblPassword.setFont(elements.fonts.get(0));
            lblPassword.setForeground(elements.colours.get(1));
            txtPassword.setFont(elements.fonts.get(0));
            txtPassword.setForeground(elements.colours.get(3));
            txtPassword.setColumns(30);
            txtPassword.setMaximumSize(new Dimension(200, 20));
        panelPassword.add(lblPassword);
        panelPassword.add(txtPassword);

        panelFirstName.setBackground(elements.colours.get(4));
            lblFirstName.setFont(elements.fonts.get(0));
            lblFirstName.setForeground(elements.colours.get(1));
            txtFirstName.setFont(elements.fonts.get(0));
            txtFirstName.setForeground(elements.colours.get(3));
            txtFirstName.setColumns(30);
            txtFirstName.setMaximumSize(new Dimension(200, 20));
        panelFirstName.add(lblFirstName);
        panelFirstName.add(txtFirstName);

        panelLastName.setBackground(elements.colours.get(4));
            lblLastName.setFont(elements.fonts.get(0));
            lblLastName.setForeground(elements.colours.get(1));
            txtLastName.setFont(elements.fonts.get(0));
            txtLastName.setForeground(elements.colours.get(3));
            txtLastName.setColumns(30);
            txtLastName.setMaximumSize(new Dimension(200, 20));
        panelLastName.add(lblLastName);
        panelLastName.add(txtLastName);

        panelTelephone.setBackground(elements.colours.get(4));
            lblTelephone.setFont(elements.fonts.get(0));
            lblTelephone.setForeground(elements.colours.get(1));
            txtTelephone.setFont(elements.fonts.get(0));
            txtTelephone.setForeground(elements.colours.get(3));
            txtTelephone.setColumns(30);
            txtTelephone.setMaximumSize(new Dimension(200, 20));
        panelTelephone.add(lblTelephone);
        panelTelephone.add(txtTelephone);

        panelAddress.setBackground(elements.colours.get(4));
            lblAddress.setFont(elements.fonts.get(0));
            lblAddress.setForeground(elements.colours.get(1));
            txtAddress.setFont(elements.fonts.get(0));
            txtAddress.setForeground(elements.colours.get(3));
            txtAddress.setColumns(30);
            txtAddress.setMaximumSize(new Dimension(200, 20));
        panelAddress.add(lblAddress);
        panelAddress.add(txtAddress);

        btnSignup.setFont(elements.fonts.get(0));
        btnSignup.setForeground(elements.colours.get(3));
        btnSignup.setAlignmentX(0.5f);

        panelMain.add(lblTitle);
        panelMain.add(panelUsername);
        panelMain.add(panelPassword);
        panelMain.add(panelFirstName);
        panelMain.add(panelLastName);
        panelMain.add(panelTelephone);
        panelMain.add(panelAddress);
        panelMain.add(btnSignup);
        panelMain.add(new JLabel(" "));

        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        frameSignup.add(panelMain);
        frameSignup.setVisible(false);
    }
}
