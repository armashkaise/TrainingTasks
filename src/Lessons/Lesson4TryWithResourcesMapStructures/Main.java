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

        //двоичное дерево поиска
        TreeStringString tree = new TreeStringString();

        System.out.println("AaAaAa".hashCode());

        tree.put("aaa", "AAA");
        tree.put("bbb", "BBB");
        tree.put("ccc", "CCC");
        tree.put("aba", "ABA");
        tree.put("aca", "ACA");
        tree.put("AaAaAa", "Kart Arman");
        tree.put("AaAaBB", "Kart Arman1");

    }
}
