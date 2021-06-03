import Bussiness.DeliveryService;
import Data.Serialization;
import GUI.Controller.AdminController;
import GUI.Controller.ClientController;
import GUI.Controller.LoginController;
import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String [] args){
        Serialization serialization = Serialization.getInstance();

        DeliveryService deliveryService = DeliveryService.getInstance();

        try {
            deliveryService = serialization.importData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        DeliveryService.getInstance().importProducts();
        DeliveryService.getInstance().generateReportByTimesOrdered(0);

        LoginController.getInstance();

        //AdminController.getInstance();
        //ClientController.getInstance();
    }
        /*


        for(MenuItem prod: deliveryService.fetchMenuItems()){
            System.out.println(prod.toString());
        }

        List<BaseProduct> productList = deliveryService.importProducts();

        BaseProduct prod1 = new BaseProduct("Fresh Corn Tortillas",3.75,23, 1, 2, 61, 79);
        prod1.setId(1);
        BaseProduct prod2 = new BaseProduct("Smoked Caviar and Hummus on Pita Toasts", 5, 23, 1, 0, 128, 48);
        prod2.setId(2);

        CompositeProduct compositeProduct1 = new CompositeProduct("Combo 1", 110);
        compositeProduct1.setId(1);
        compositeProduct1.addItem(prod1);
        compositeProduct1.addItem(prod2);

        //System.out.println(compositeProduct1.toString());
        //System.out.println( );
        //System.out.println(prod1);
        //System.out.println(prod2);

        List<MenuItem> orderedProducts = new ArrayList<>();
        orderedProducts.add(productList.get(5));
        orderedProducts.add(productList.get(10));

        Order order = new Order();

        Client client = new Client("user1", "password", "John", "Doe", "Str Ceahlau 77", "0712345678");

        try {
            serialization.exportData(deliveryService);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
}