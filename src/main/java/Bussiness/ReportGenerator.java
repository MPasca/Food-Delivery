package Bussiness;

import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    public void generateReport(String title){
        try {
            FileWriter report = new FileWriter("Report ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
