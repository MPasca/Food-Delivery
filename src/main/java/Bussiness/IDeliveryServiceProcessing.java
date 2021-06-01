package Bussiness;

import Data.BaseProduct;
import Data.Client;
import Data.MenuItem;
import Data.Order;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IDeliveryServiceProcessing {
    // Admin methods
    List<BaseProduct> importProducts() throws IOException;

    int addProduct(MenuItem toAdd);
    int createCompositeProduct(List<BaseProduct> productList, String title, double price);
    int deleteProduct(int toDelete);
    int modifyProduct(int idToModify, MenuItem toModify);

    void generateReports();

    // Client methods
    int newOrder(Client client, Order order, List<MenuItem> orderedProducts);

    List<MenuItem> fetchMenuItems();

    Set<Order> getOrders();
}
