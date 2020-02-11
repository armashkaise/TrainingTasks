package Lessons.Lesson4TryWithResourcesMapStructures;

import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.Order;
import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.OutOfBoundException;


import java.io.*;

public class Main {
    public static void main(String[] args) throws OutOfBoundException {
        MapStringString mapka = new StupedStringString();

        mapka.put("aaa", "AAA");
        mapka.put("armashkaise", "Kart Arman");
        mapka.put("armashkaise", "Kart Arman1");
        mapka.put("bbb", "BBB");
        mapka.put("aaa", "AAA111");
        System.out.println(mapka.get("armashkaise"));
        System.out.println(mapka.get("dfdsf"));
    }
}
