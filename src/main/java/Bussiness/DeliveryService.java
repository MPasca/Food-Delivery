package Bussiness;

import Bussiness.Validators.ClientValidator;
import Data.Importer;
import Model.*;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import static java.util.stream.Collectors.toList;

public class DeliveryService implements Serializable, IDeliveryServiceProcessing {
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

    public List<Order> generateReportByTimeInterval( LocalTime[] time) {
        return getOrders().stream().filter(t-> t.getTime().isAfter(time[0]) ).filter(t->t.getTime().isBefore(time[1])).collect(toList());
    }

    public List<MenuItem> generateReportByTimesOrdered(int numberOfOrders){
        List<MenuItem> filteredList = new ArrayList<>();
        return  menuItems.stream().filter(m->m.getTimesOrdered() >= numberOfOrders).collect(toList());
    }

    public List<Client> generateClientsReport(int count, float value){
        List<Client> filteredClients = new ArrayList<>();
        orders.keySet().stream().filter(entry-> entry.getTotalPrice() >= value).forEach(e-> filteredClients.add(findClientById(e.getClientId())));
        return filteredClients.stream().distinct().filter(e-> e.getNumberOfOrders() >= count).collect(toList());
    }

    public List<MenuItem> generateReportByDateAndTimesOrdered(LocalDate date, int numberOfTimes){
        List<MenuItem> filteredList = new ArrayList<>();
        List<MenuItem> result = new ArrayList<>();
        orders.entrySet().stream().filter(entry-> entry.getKey().getDate().isAfter(date)).forEach(e->e.getValue().stream().filter(k->k.getTimesOrdered() >= numberOfTimes).forEach(k->filteredList.add(k)));
        for(MenuItem item : filteredList){
            if(!result.contains(item)){
                result.add(item);
            }
        }
        return result;
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

}
