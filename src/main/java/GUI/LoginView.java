package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginView {
    private JFrame frameMain = new JFrame();
    private JPanel panelMain = new JPanel();

    private JLabel lblTitle = new JLabel("Thunder");

    private JPanel panelCredentials = new JPanel();
    private JLabel lblUsername = new JLabel("Username:");
    private JLabel lblPassword = new JLabel("Password:");

    private JTextField txtUsername = new JTextField(10);
    private JTextField txtPassword = new JTextField(10);

    private JButton btnLogin = new JButton("Log in");

    private JLabel lblSignup = new JLabel("Not a member? Register now");
    private JButton btnSignup = new JButton("Sign up");

    public LoginView(){
        Elements elements = new Elements();

        frameMain.setSize(300, 300);
        frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelMain.setBackground(elements.colours.get(4));

        lblTitle.setForeground(elements.colours.get(0));
        lblTitle.setFont(elements.fonts.get(1));

        // ----- Credentials
        lblUsername.setFont(elements.fonts.get(0));
        lblPassword.setFont(elements.fonts.get(0));

        txtUsername.setFont(elements.fonts.get(0));
        txtPassword.setFont(elements.fonts.get(0));

        // ----- Sign up
        lblSignup.setFont(elements.fonts.get(2));
        lblSignup.setForeground(elements.colours.get(3));

        btnSignup.setFont(elements.fonts.get(2));
        btnSignup.setForeground(elements.colours.get(3));
        btnSignup.setBorder(new EmptyBorder(2, 2, 2, 2));
    }
}
