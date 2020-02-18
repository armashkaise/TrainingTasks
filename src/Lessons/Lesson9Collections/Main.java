package Lessons.Lesson9Collections;

import Lessons.Lesson9Collections.Task1.Home;
import Lessons.Lesson9Collections.Task1.Park;
import Lessons.Lesson9Collections.Task1.Road;
import Lessons.Lesson9Collections.Task1.Utils;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

//*****************************************************ЗАДАНИЕ №1***********************************************
        var homeBuilder = new Home.Builder();                   //здания
        Set<Home> setHome = new HashSet<Home>();
        Home home1 = homeBuilder.setColor("blue")
                .setAdress("Летунова 8")
                .setLenght(100.5)
                .setWidth(154.2)
                .setCountFloor(5)
                .setTypeHome("Административное")
                .build();
        home1.addDamage("Крыльцо", 2, 2);
        home1.addDamage("Фойе", 3.5, 2);

        Home home2 = homeBuilder.setColor("green")
                .setAdress("В.Интернационалитов 10")
                .setLenght(8)
                .setWidth(8.5)
                .setCountFloor(1)
                .setTypeHome("Жилое")
                .build();
        home2.addDamage("Крыльцо", 1, 1);
        home2.addDamage("Коридор", 2, 2);
        Home home3 = homeBuilder.setColor("red")
                .setAdress("Тауелсыздык 11")
                .setLenght(10)
                .setWidth(11.5)
                .setCountFloor(2)
                .setTypeHome("Жилое")
                .build();
        home3.addDamage("Крыльцо", 1, 1);
        home3.addDamage("Коридор", 1.5, 3);
        setHome.add(home1);
        setHome.add(home2);
        setHome.add(home3);

        var parkeBuilder = new Park.Builder();                      //******парки
        Set<Park> setPark = new HashSet<Park>();
        var park1 = parkeBuilder.setParkName("Парк победы")
                .setLenght(1000)
                .setWidth(1000)
                .build();
        park1.addDamage("Тратуар", 20, 10);
        park1.addDamage("Лавочка", 1, 1.5);

        var park2 = parkeBuilder.setParkName("Парк имени 28 панфиловцев")
                .setLenght(2000)
                .setWidth(1500)
                .build();
        park2.addDamage("Тратуар", 100, 100);
        park2.addDamage("Лавочка", 1, 1.5);

        setPark.add(park1);
        setPark.add(park2);

        var roadBuilder = new Road.Builder();                      //******дороги
        Set<Road> setRoad = new HashSet<Road>();
        var road1 = roadBuilder.setRoadName("Тарановское - Варваринка")
                .setCoating("Асфальт")
                .setLenght(100_000)
                .setWidth(10)
                .build();
        road1.addDamage("Выбоина1", 1, 1);
        road1.addDamage("Выбоина2", 1, 1.5);
        road1.addDamage("Выбоина3", 1, 1.5);

        setRoad.add(road1);

        //рассчет общей квадратуры
        for (Home home : setHome) {
            System.out.println("Общая площадь здания " + home + " равна " + Utils.calcSquare(home));
            //рассчет квадратуры Damage
            System.out.println("Общая квадратура Damage " + Utils.calcSquareDamage(home));
        }
        System.out.println();

        for (Park park : setPark) {
            System.out.println("Общая площадь парка " + park + " равна " + Utils.calcSquare(park));
            //рассчет квадратуры Damage
            System.out.println("Общая квадратура Damage " + Utils.calcSquareDamage(park));
        }
        System.out.println();

        for (Road road : setRoad) {
            System.out.println("Общая площадь дороги " + road + " равна " + Utils.calcSquare(road));
            //рассчет квадратуры Damage
            System.out.println("Общая квадратура Damage " + Utils.calcSquareDamage(road));
        }
        System.out.println();

//*****************************************************ЗАДАНИЕ №2***********************************************


    }
}
