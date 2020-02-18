package Lessons.Lesson9Collections.Task1;

import Lessons.Lesson9Collections.Task1.CityObject;
import Lessons.Lesson9Collections.Task1.Damage;
import Lessons.Lesson9Collections.Task1.Home;

import java.util.Objects;

public class Utils {
    public static <T extends CityObject> double calcSquare(T object){
        if (Objects.isNull(object)) return 0;

        return object.lenght * object.width;
    }
//    double calcLength();
    public static <T extends CityObject> double calcSquareDamage(T object){
        if (Objects.isNull(object)) return 0;
        Damage damage = object.damage;
        double square = 0;
        while (Objects.nonNull(damage)){
            square += damage.getLenght() * damage.getWidth();
            damage = damage.next;
        }
        return square;
    }
}
