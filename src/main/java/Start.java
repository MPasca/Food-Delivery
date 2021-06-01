import Bussiness.DeliveryService;
import Data.*;

import java.util.ArrayList;
import java.util.List;

public class Start {
    public static void main(String [] args){
        //LoginView start = new LoginGUI();

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

        DeliveryService deliveryService = new DeliveryService();
        List<BaseProduct> productList = deliveryService.importProducts();

        for(BaseProduct prod: productList){
            System.out.println(prod.toString());
        }
        List<MenuItem> orderedProducts = new ArrayList<>();
        orderedProducts.add(productList.get(5));
        orderedProducts.add(productList.get(10));

        Order order = new Order();

        Client client = new Client("John", "Doe", "Str Ceahlau 77", "0712345678");

        deliveryService.newOrder(client, order, orderedProducts);

    }
}