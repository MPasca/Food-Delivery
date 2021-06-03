package Bussiness;

import Bussiness.Validators.ClientValidator;
import Data.Importer;
import Model.*;
import Model.MenuItem;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DeliveryService extends Observable implements Serializable, IDeliveryServiceProcessing {
    private static DeliveryService singleInstance = new DeliveryService();
    public static DeliveryService getInstance() {
        return singleInstance;
    }

    private List<MenuItem> menuItems = new ArrayList<>();
    private HashMap<Order, List<MenuItem>> orders = new HashMap<>();
    private List<Client> clients = new ArrayList<>();

    Bill bill = new Bill();

    ClientValidator validator = ClientValidator.getValidator();

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
        menuItems.remove(findById(toDelete));
        return toDelete;
    }

    @Override
    public int modifyProduct(int idToModify, MenuItem toModify) {
        int index = menuItems.lastIndexOf(findById(idToModify));
        toModify.setId(idToModify);
        menuItems.add(index, toModify);
        return idToModify;
    }

    @Override
    public void generateReports() {

    }

    public List<Order> generateReportByTimeInterval( LocalTime timeBegin, LocalTime timeEnd) {
        String title = "REPORT BY TIME INTERVAL: " + timeBegin.toString() + " to " + timeEnd.toString();
        List<Order> foundOrders = getOrders().stream().filter(t -> t.getTime().isAfter(timeBegin) ).filter(t -> t.getTime().isBefore(timeEnd)).collect(toList());

        ReportGenerator.getInstance().generateReportByTimeInterval(title, foundOrders);
        return foundOrders;
    }

    public List<MenuItem> generateReportByTimesOrdered(int minTimesOrdered){
        String title = "REPORT BY TIMES ORDERED - higher than " + minTimesOrdered;
        List<MenuItem> foundItems = menuItems.stream().filter(m->m.getTimesOrdered() >= minTimesOrdered).collect(toList());

        ReportGenerator.getInstance().generateReportByTimesOrdered(title, foundItems);
        return foundItems;
    }

    public List<Client> generateClientsReport(int minOrders, Double minPrice){
        String title = "CLIENTS REPORT - times ordered higher than " + minOrders + " with a minimum value of " + minPrice;

        List<Client> filteredClients = new ArrayList<>();

        orders.keySet().stream().filter(entry -> entry.getTotalPrice() >= minPrice).forEach(e -> filteredClients.add(findClientById(e.getClientId())));
        List<Client> foundClients = filteredClients.stream().distinct().filter(e -> e.getNumberOfOrders() >= minOrders).collect(toList());

        ReportGenerator.getInstance().generateClientsReport(title, foundClients);
        return foundClients;
    }

    public List<MenuItem> generateReportByDateAndTimesOrdered(LocalDate date, int numberOfTimes){
        String title = "REPORT ORDERED ITEMS BY DATE AND TIME AND TIMES ORDERED";

        List<MenuItem> filteredList = new ArrayList<>();
        List<MenuItem> result = new ArrayList<>();
        orders.entrySet().stream().filter(entry -> entry.getKey().getDate().isAfter(date)).forEach(e -> e.getValue().stream().filter(k -> k.getTimesOrdered() >= numberOfTimes).forEach(k -> filteredList.add(k)));
        for(MenuItem item : filteredList){
            if(!result.contains(item)){
                result.add(item);
            }
        }

        ReportGenerator.getInstance().generateReportByDateAndTimesOrdered(title, result);
        return result;
    }


    // Client tasks
    @Override
    public int newOrder(Client client, List<MenuItem> orderedProducts) {
        Order order = new Order();
        order.setId(orders.size() + 1);
        client.addOrder(order);
        client.incTimesOrdered();
        order.placeOrder();
        orders.put(order, orderedProducts);

        int totalPrice = 0;
        for(MenuItem item: orderedProducts){
            totalPrice += item.getPrice();
            item.incTimesOrdered();
        }

        order.setTotalPrice(totalPrice);
        bill.printBill(order, client, orderedProducts);
        return order.getId();
    }


    // other methods
    public Client findClientById(int id){
        for(Client c: clients){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    @Override
    public List<MenuItem> fetchMenuItems() {
        return menuItems;
    }

    @Override
    public Set<Order> getOrders() {
        return orders.keySet();
    }

    public List<Client> getClients(){
        return clients;
    }

    public void createUser(User user){
        if(user instanceof Client){
            validator.validate((Client) user);
            clients.add((Client) user);
            user.setId(clients.indexOf(user) + 1);
        }
    }

    public MenuItem findById(int id){
        for(MenuItem item:menuItems){
            if(item.getId() == id){
                return item;
            }
        }
        return null;
    }
}
