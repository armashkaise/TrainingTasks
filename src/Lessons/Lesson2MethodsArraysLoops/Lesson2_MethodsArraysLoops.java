package Lessons.Lesson2MethodsArraysLoops;

import javax.swing.*;
import java.util.ArrayList;

public class Lesson2_MethodsArraysLoops {
    public static void main(String[] args) {
/*
            цикл while
*/
        int a = 0;
        while ( a < 10){
            System.out.println(a);
            a++;
        }
        System.out.println();
/*
            цикл do while
 */
        a = 0;
        do {
            System.out.println(a);
            a++;
        } while (a < 10);
 /*
            вычисление факториала
*/
        String result = JOptionPane.showInputDialog("Факториал какого числа вы хотите вычислить???");
        System.out.println("Факториал числа " + result + " равен " + calcFactorial(result));
 /*
            брат пузырьковую сортировку я уже делал
*/

/*
            вернуть непарную цифру
*/
        int[] array = {1, 2, 3, 1, 2, 4};

       getUnparedNumber(array);

    }

    private static void getUnparedNumber(int[] array) {
        int unpared = -1;
        for (int i = 0; i < array.length; i++) {
            boolean isPared = false;
            int j = 0;
            for (j = i + 1; j < array.length; j++){
                if (array[i] == array[j]){
                    array[i] = 0;
                    array[j] = 0;
                    isPared = true;
                }
            }
            if (!isPared) {
                unpared = array[i];
                break;
            }
        }
        if(unpared >= 0) System.out.println("Непарное число равно " + unpared);
    }

    private static int calcFactorial(String result) {
        int number = Integer.parseInt(result);
        int i = 1;
        int factorial = 1;
        while (i <= number){
            factorial *= i;
            i++;
        }
        return factorial;
    }


}

