package Model;

public class BaseProduct extends MenuItem  {
    public BaseProduct(String title, double rating, int calories, int protein, int fat, int sodium, double price) {
        super(title, price, rating, calories, protein, fat, sodium);
    }

    public String toString(){
        String resString = id + " " + title + ":\n";

        resString += "Rating: " + rating + "\n";
        resString += "Price: " + price + "\n";

        return resString;
    }
}
