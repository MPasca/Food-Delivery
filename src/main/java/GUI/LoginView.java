package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginView {
    private static LoginView loginView = new LoginView();
    public static LoginView getInstance(){
        return loginView;
    }

    public JFrame frameMain = new JFrame();
    public JPanel panelMain = new JPanel();

    public JLabel lblTitle = new JLabel("Food Delivery");

    public JPanel panelCredentials = new JPanel();
    public JPanel panelUsername = new JPanel();
    public JPanel panelPassword = new JPanel();
        public JLabel lblUsername = new JLabel("Username:");
        public JLabel lblPassword = new JLabel("Password:");
        public JTextField txtUsername = new JTextField(10);
        public JTextField txtPassword = new JTextField(10);
        public JButton btnLogin = new JButton("Log in");

    public JPanel panelSignup = new JPanel();
    public JLabel lblSignup = new JLabel("Not a member? Register now");
    public JButton btnSignup = new JButton("Sign up");

    public LoginView(){
        Elements elements = new Elements();

        frameMain.setSize(300, 150);
        frameMain.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        panelMain.setBackground(elements.colours.get(4));

        lblTitle.setForeground(elements.colours.get(0));
        lblTitle.setFont(elements.fonts.get(1));
        lblTitle.setAlignmentX(0.5f);

        // ----- Credentials
        lblUsername.setFont(elements.fonts.get(0));
        lblUsername.setForeground(elements.colours.get(1));
        lblPassword.setFont(elements.fonts.get(0));
        lblPassword.setForeground(elements.colours.get(1));

        txtUsername.setFont(elements.fonts.get(0));
        txtUsername.setColumns(30);
        txtUsername.setMaximumSize(new Dimension(200, 20));
        txtUsername.setForeground(elements.colours.get(3));
        txtPassword.setFont(elements.fonts.get(0));
        txtPassword.setForeground(elements.colours.get(3));
        txtPassword.setColumns(30);
        txtPassword.setMaximumSize(new Dimension(200, 20));

        panelUsername.setBackground(elements.colours.get(4));
        panelUsername.add(lblUsername);
        panelUsername.add(txtUsername);

        panelPassword.setBackground(elements.colours.get(4));
        panelPassword.add(lblPassword);
        panelPassword.add(txtPassword);

        btnLogin.setFont(elements.fonts.get(0));
        btnLogin.setForeground(elements.colours.get(3));
        btnLogin.setAlignmentX(0.5f);

        panelCredentials.setBackground(elements.colours.get(4));
        panelCredentials.setBorder(new EmptyBorder(40, 0, 20, 0));
            panelCredentials.add(panelUsername);
            panelCredentials.add(panelPassword);
            panelCredentials.add(btnLogin);
        panelCredentials.setLayout(new BoxLayout(panelCredentials, BoxLayout.Y_AXIS));

        // ----- Sign up
        lblSignup.setFont(elements.fonts.get(2));
        lblSignup.setAlignmentX(0.5f);;
        lblSignup.setForeground(elements.colours.get(3));

        btnSignup.setFont(elements.fonts.get(2));
        btnSignup.setForeground(elements.colours.get(3));
        btnSignup.setAlignmentX(0.5f);

        panelSignup.setBackground(elements.colours.get(4));
        panelSignup.setBorder(new EmptyBorder(20, 0, 20, 0));
        panelSignup.add(lblSignup);
        panelSignup.add(btnSignup);
        panelSignup.setLayout(new BoxLayout(panelSignup, BoxLayout.Y_AXIS));

        panelMain.add(new JLabel(" "));
        panelMain.add(lblTitle);
        panelMain.add(panelCredentials);
        panelMain.add(panelSignup);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        frameMain.add(panelMain);
        frameMain.setSize(400, 400);

        frameMain.setVisible(true);
    }


    }
