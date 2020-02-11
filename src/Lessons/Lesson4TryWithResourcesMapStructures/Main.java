package Lessons.Lesson4TryWithResourcesMapStructures;

import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.Order;
import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.OutOfBoundException;


import java.io.*;

public class Main {
    public static void main(String[] args) throws OutOfBoundException {
        MapStringString mapka = new StupedStringString();

        mapka.put("aaa", "AAA");
        mapka.put("AaAaAa", "Kart Arman");
        mapka.put("AaAaBB", "Kart Arman1");
        mapka.put("bbb", "BBB");
        System.out.println(mapka.get("AaAaAa"));
        System.out.println(mapka.get("dfdsf"));
        System.out.println();

        //Бинарное дерево поиска
        TreeStringString tree = new TreeStringString();
        tree.put("aaa", "AAA");
        tree.put("bbb", "BBB");
        tree.put("ccc", "CCC");
        tree.put("aba", "ABA");
        tree.put("aca", "ACA");
        tree.put("AaAaAa", "Kart Arman");
        tree.put("AaAaBB", "Kart Arman1");

        System.out.println(tree.get("ccc"));
        System.out.println(tree.get("AaAaAa"));
        System.out.println(tree.get("AaAaBB"));
        System.out.println();

        //Поиск в массиве
        ArrayStringString array = new ArrayStringString();
        array.put("aaa", "AAA");
        array.put("bbb", "BBB");
        array.put("ccc", "CCC");
        array.put("AaAaAa", "Kart Arman");
        array.put("AaAaBB", "Kart Arman1");
        System.out.println(array.get("bbb"));
        System.out.println(array.get("AaAaAa"));
        System.out.println(array.get("AaAaBB"));
    }
}
