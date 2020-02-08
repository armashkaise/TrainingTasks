package Lessons.Lesson4TryWithResourcesMapStructures;

import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.Order;
import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.OutOfBoundException;

import java.io.*;

public class Main {
    public static void main(String[] args) throws OutOfBoundException {
        BufferedReader bufferedReader = null;
        Order order = new Order("/1.txt");
        System.out.println(order);

//        try {
//            bufferedReader = new BufferedReader(new FileReader(new File()));
//            bufferedReader.readLine();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
