package Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.utils;

import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.AreaSize;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Park;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Street;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

final public class AreaCalculator {

    private AreaCalculator() {
    }

    public static int calcArea(Collection<? extends AreaSize> areaSizes) {
        int areaResult = 0;
        for (AreaSize areaSize : areaSizes) {
            areaResult += areaSize.getLenght() * areaSize.getWidth();
        }
        return areaResult;
    }

//
//    public static int calcParks(Set<Park> parks) {
//        int areaResult = 0;
//        for (Park park : parks) {
//            areaResult += park.getLenght() * park.getWidth();
//        }
//        return areaResult;
//    }
}
