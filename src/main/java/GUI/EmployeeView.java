package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class EmployeeView implements Observer {

    JFrame frameEmployee;
    JLabel name = new JLabel("Name:");
    JPanel notificationPanel;

    public EmployeeView(String name, int id){
        frameEmployee.setTitle("Employee #" + id + " | " + name);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
