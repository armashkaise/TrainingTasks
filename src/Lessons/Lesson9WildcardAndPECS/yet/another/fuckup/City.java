package Lessons.Lesson9WildcardAndPECS.yet.another.fuckup;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class City {
    private Set<Street> streets;
    private Set<Park> parks;

    public City() {
        this.streets = new HashSet<>();
        this.parks = new HashSet<>();
    }

    public Set<Street> getStreets() {
        return streets;
    }

    public Set<Park> getParks() {
        return parks;
    }

    public void addStreet(Street street){
//        if (Objects.nonNull(street))
            streets.add(street);
    }

    public void addPark(Park park){
        if (Objects.nonNull(park))
            parks.add(park);
    }

    public Set<? extends AreaSize> getAllAreaSizeble() {
        Set<AreaSize> areaSizes = new HashSet<AreaSize>();
        areaSizes.addAll(streets);
        areaSizes.addAll(parks);
        return areaSizes;
    }
}
