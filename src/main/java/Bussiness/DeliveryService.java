package Bussiness;

import Data.Importer;
import Model.*;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.*;

public class DeliveryService implements Serializable, IDeliveryServiceProcessing {
    private List<MenuItem> menuItems = new ArrayList<>();
    private HashMap<Order, List<MenuItem>> orders = new HashMap<>();
    private List<Client> clients = new ArrayList<>();

    Bill bill = new Bill();

    // Admin tasks
    @Override
    public List<BaseProduct> importProducts() {
        Importer importer = new Importer();
        List<BaseProduct> importedItems = new ArrayList<>();

        try {
            importedItems = importer.fetchMenuItems();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(!importedItems.isEmpty()){
            for(int i = 1; i <= importedItems.size(); i++){
                importedItems.get(i-1).setId(i);
                menuItems.add(importedItems.get(i-1));
            }
        }
        return importedItems;
    }

    @Override
    public int addProduct(MenuItem toAdd) {
        if(toAdd != null){
            toAdd.setId(menuItems.size() + 1);
            menuItems.add(toAdd);
        }

        return toAdd.getId();
    }

    @Override
    public int createCompositeProduct(List<BaseProduct> productList, String title, double price) {
        CompositeProduct newProduct = new CompositeProduct(title, price);
        for(BaseProduct prod: productList){
            newProduct.addItem(prod);
        }

        newProduct.setId(menuItems.size() + 1);
        menuItems.add(newProduct);
        return newProduct.getId();
    }

    @Override
    public int deleteProduct(int toDelete) {
        menuItems.remove(toDelete);
        return toDelete;
    }

    @Override
    public int modifyProduct(int idToModify, MenuItem toModify) {
        menuItems.add(idToModify, toModify);
        return idToModify;
    }

    @Override
    public void generateReports() {

    }

    // Client tasks
    @Override
    public int newOrder(Client client, Order order, List<MenuItem> orderedProducts) {
        order.setId(orders.size() + 1);
        client.addOrder(order);
        order.placeOrder();
        orders.put(order, orderedProducts);

        int totalPrice = 0;
        for(MenuItem item: orderedProducts){
            totalPrice += item.getPrice();
        }

        order.setTotalPrice(totalPrice);
        bill.printBill(order, client, orderedProducts);
        return order.getId();
    }


    // other methods
    @Override
    public List<MenuItem> fetchMenuItems() {
        return menuItems;
    }

    @Override
    public Set<Order> getOrders() {
        return orders.keySet();
    }

}
