package Bussiness;

import Data.BaseProduct;
import Data.MenuItem;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Importer {
    public List<BaseProduct> fetchMenuItems() throws FileNotFoundException {
        List<BaseProduct> menuItemList = new ArrayList<>();

        File toImport = new File("products.csv");
        InputStream inputStream = new FileInputStream(toImport);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        menuItemList = bufferedReader.lines().skip(1).map(
                line->{
                    String[] p = line.split(",");
                    // String title, double rating, int calories, int protein, int fat, int sodium, double price
                    String title = p[0];
                    double rating = Double.parseDouble(p[1]);
                    int calories = Integer.parseInt(p[2]);
                    int protein = Integer.parseInt(p[3]);
                    int fat = Integer.parseInt(p[4]);
                    int sodium = Integer.parseInt(p[5]);
                    double price = Double.parseDouble(p[6]);

                    BaseProduct item = new BaseProduct(title, rating, calories, protein, fat, sodium, price);

                    return item;
                }
        ).collect(Collectors.toList());

        menuItemList = menuItemList.stream().collect(collectingAndThen(toCollection(()->
                new TreeSet<>(Comparator.comparing(MenuItem::getTitle))), ArrayList::new));

        menuItemList.sort(Comparator.comparing(MenuItem::getTitle));

        return menuItemList;
    }
}
