package Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.utils;

import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.AreaSize;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.City;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Street;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

final public class StreetProcessing {

    private StreetProcessing() {
    }

    public static Set<AreaSize> findAllStreets(List<City> cities) {
        Set<AreaSize> streets = new HashSet<>();
        for (City city : cities) {
            fillStreetResult(streets, city.getStreets());
        }
        return streets;
    }

    private static void fillStreetResult(Set<? super AreaSize> consumer, Set<? extends AreaSize> streets1) {
        for (AreaSize street : streets1) {
            consumer.add(street);
        }

    }
}
