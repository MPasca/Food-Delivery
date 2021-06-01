package Model;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends MenuItem {
    private List<BaseProduct> items = new ArrayList<>();

    public CompositeProduct(String title, double price) {
        super(title, price);
    }

    public void addItem(BaseProduct toAdd){
        items.add(toAdd);
        this.calories += toAdd.getCalories();
        this.protein += toAdd.getProtein();
        this.fat += toAdd.getFat();
        this.sodium += toAdd.getSodium();
    }

    public void removeItem(BaseProduct toRemove){
        items.remove(toRemove);
    }

    public List<BaseProduct> fetchItems(){
        return items;
    }

    public String toString(){
        String resString = id + " " + title + ":\n";
        for(BaseProduct product: items){
            resString += "  " + product.getTitle() + "\n";
        }
        resString += "  ______________________\n";

        resString += "  Rating: " + rating + "\n";
        resString += "  Price: " + price;

        return resString;
    }
}
