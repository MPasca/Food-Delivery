package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class ClientView {
    private static ClientView clientView = new ClientView();
    public static ClientView getInstance(){
        return clientView;
    }

    public JFrame frameClient = new JFrame();
    public JPanel panelClient = new JPanel();
    public JButton btnRefresh = new JButton("Refresh");
    public JButton btnLogout = new JButton("Log out");              // listener

    public JPanel panelMain = new JPanel();
    JLabel lblTitle = new JLabel("Client");

    public JPanel panelAdd = new JPanel();
        JLabel lblAdd = new JLabel("Add order");
        JPanel panelId = new JPanel();
            JLabel lblId = new JLabel("Id:");
            public JComboBox<Integer> cmbId = new JComboBox<>();
        public JButton btnAdd = new JButton("Add product");
        public JButton btnFinish = new JButton("Place order");

    public JPanel panelSearch = new JPanel();
        JLabel lblSearch = new JLabel("Search items");
        public JTextField txtKeyword = new JTextField("search by keyword", 30);
        //public JTextField txtRating = new JTextField("search by rating", 30);
        public JButton btnSearch = new JButton("Search");

    public JPanel panelTableProd = new JPanel();
    public JTable tableProducts = new JTable();
    public Elements elements = new Elements();

    public ClientView(){

        frameClient.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frameClient.setSize(900, 600);

        lblTitle.setForeground(elements.colours.get(0));
        lblTitle.setFont(elements.fonts.get(1));
        lblTitle.setAlignmentX(0.5f);

// --------------- SEARCH PANEL
        btnSearch.setFont(elements.fonts.get(0));
        btnSearch.setForeground(elements.colours.get(3));

        lblSearch.setForeground(elements.colours.get(1));
        lblSearch.setFont(elements.fonts.get(1));
        lblSearch.setAlignmentX(0.5f);

        //txtRating.setFont(elements.fonts.get(0));
        //txtRating.setColumns(30);
        //txtRating.setMaximumSize(new Dimension(200, 20));

        txtKeyword.setFont(elements.fonts.get(0));
        txtKeyword.setColumns(30);
        txtKeyword.setMaximumSize(new Dimension(200, 20));

        panelSearch.setBackground(elements.colours.get(4));
            panelSearch.add(lblSearch);
                panelSearch.add(new JLabel(" "));
            panelSearch.add(txtKeyword);
                panelSearch.add(new JLabel(" "));
            //panelSearch.add(txtRating);
            //    panelSearch.add(new JLabel(" "));
            panelSearch.add(btnSearch);
        panelSearch.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelSearch.setLayout(new BoxLayout(panelSearch, BoxLayout.Y_AXIS));

// --------------- ADD PANEL
        btnAdd.setFont(elements.fonts.get(0));
        btnAdd.setForeground(elements.colours.get(3));

        btnFinish.setFont(elements.fonts.get(0));
        btnFinish.setForeground(elements.colours.get(3));

        lblAdd.setForeground(elements.colours.get(1));
        lblAdd.setFont(elements.fonts.get(1));
        lblAdd.setAlignmentX(0.5f);

        panelId.setBackground(elements.colours.get(4));
            lblId.setFont(elements.fonts.get(0));
            lblId.setForeground(elements.colours.get(1));
            cmbId.setFont(elements.fonts.get(0));
            cmbId.setForeground(elements.colours.get(3));
            panelId.add(lblId);
            panelId.add(cmbId);

        panelAdd.setBackground(elements.colours.get(4));
            panelAdd.add(lblAdd);
            panelAdd.add(new JLabel(" "));
            panelAdd.add(panelId);
            panelAdd.add(new JLabel(" "));
            panelAdd.add(btnAdd);
            panelAdd.add(new JLabel(" "));
            panelAdd.add(btnFinish);
        panelAdd.setBorder(new EmptyBorder(40, 30, 40, 30));
        panelAdd.setLayout(new BoxLayout(panelAdd, BoxLayout.Y_AXIS));

        panelMain.add(lblTitle);
        panelMain.add(panelSearch);
        panelMain.add(panelAdd);

        btnRefresh.setFont(elements.fonts.get(0));
        btnRefresh.setForeground(elements.colours.get(3));

        btnLogout.setFont(elements.fonts.get(0));
        btnLogout.setForeground(elements.colours.get(3));

        panelMain.add(btnRefresh);
        panelMain.add(btnLogout);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));


        panelClient.add(panelMain);
        panelTableProd.add(tableProducts);
        panelClient.add(panelTableProd);
        frameClient.add(panelClient);
        frameClient.setVisible(true);
    }
}
