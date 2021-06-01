package Model;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    protected int id;

    protected String title;
    protected double rating;
    protected int calories;
    protected int protein;
    protected int fat;
    protected int sodium;
    protected double price;

    public MenuItem(String title, double price){
        this.title = title;
        this.price = price;
    }

    public MenuItem(String title, double price, double rating, int calories, int protein, int fat, int sodium){
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public abstract String toString();

    public int getTimesOrdered(){
        return 0;
    }
}
