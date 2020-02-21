package Lessons.Lesson9WildcardAndPECS;

import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.*;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.utils.AreaCalculator;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.utils.StreetProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        City city = new City();

        Set<Street> streets = city.getStreets();
        streets.add(new Street("Республики", 1000, 8));
        streets.add(new Street("Ленина", 2000, 5));
        streets.add(new Street("Сталина", 3000, 10));

        Set<Park> parks = city.getParks();
        parks.add(new Park("28 панфиловцев", 10, 20));
        parks.add(new Park("Победы", 20, 30));

        int areaOfStreets = AreaCalculator.calcArea(streets);
        int areaOfParks = AreaCalculator.calcArea(parks);

        ArrayList<FullAreaParams> waterpoolsAndOvrags = new ArrayList<>();
        waterpoolsAndOvrags.add(new Waterpool());
        waterpoolsAndOvrags.add(new Ovrags());
        int areaOfHZ = AreaCalculator.calcArea(waterpoolsAndOvrags);

        var areaSize = city.getAllAreaSizeble();

        City kostanay = new City();
        kostanay.addStreet(new Street("Аль-фараби", 1000, 8));
        kostanay.addStreet(new Street("Интернационалистов", 1000, 8));
        List<City> cities = List.<City>of(city, kostanay);

        Set<AreaSize> streets1 = StreetProcessing.findAllStreets(cities);
//        Set<Street> consumer = null;
        //streets1.fillStreetResult(consumer, streets);

    }

}
