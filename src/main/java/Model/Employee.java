package Model;

import GUI.EmployeeView;

public class Employee {
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;

        EmployeeView employeeView = new EmployeeView(name, id);
    }
}
