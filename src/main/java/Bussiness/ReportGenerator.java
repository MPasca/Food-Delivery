package Bussiness;

import Model.Client;
import Model.MenuItem;
import Model.Order;

import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

public class ReportGenerator {
    private static ReportGenerator reportGenerator = new ReportGenerator();
    public static ReportGenerator getInstance(){
        return reportGenerator;
    }

    public void generateReportByTimeInterval(String title, List<Order> foundOrders){
        try {
            FileWriter report = new FileWriter("Report by time interval.txt");
            report.write(title + "\n\n");
            report.write("_______________________________\n");
            for(Order o: foundOrders){
                report.write(o.toString() + "\n");
                report.write("_______________________________\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReportByTimesOrdered(String title, List<MenuItem> foundItems){
        try {
            FileWriter report = new FileWriter("Report by times ordered.txt");
            report.write(title + "\n\n");
            report.write("_______________________________\n");
            for(MenuItem m: foundItems){
                report.write(m.toString() + "\n");
                report.write("_______________________________\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateClientsReport(String title, List<Client> foundClients){
        try {
            FileWriter report = new FileWriter("Clients report.txt");
            report.write(title + "\n\n");
            report.write("_______________________________\n");
            for(Client c: foundClients){
                report.write(c.toString() + "\n");
                report.write("_______________________________\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateReportByDateAndTimesOrdered(String title, List<MenuItem> foundItems){
        try {
            FileWriter report = new FileWriter("Report by date and times ordered.txt");
            report.write(title + "\n\n");
            report.write("_______________________________\n");
            for(MenuItem m: foundItems){
                report.write(m.toString() + "\n");
                report.write("_______________________________\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
