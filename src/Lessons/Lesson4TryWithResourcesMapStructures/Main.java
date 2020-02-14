package Lessons.Lesson4TryWithResourcesMapStructures;

import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.OutOfBoundException;

public class Main {
    public static void main(String[] args) throws OutOfBoundException {

        MapString<String, String> mapka = new StupedString<>();

        mapka.put("aaa", "AAA");
        mapka.put("AaAaAa", "Kart Arman");
        mapka.put("AaAaBB", "Kart Arman1");
        mapka.put("bbb", "BBB");
        System.out.println(mapka.get("AaAaAa"));
        System.out.println(mapka.get("dfdsf"));
        System.out.println();

        //Бинарное дерево поиска
        MapString<String, String> tree = new TreeString<>();
        tree.put("aaa", "AAA");
        tree.put("AaAaAa", "Kart Arman");
        tree.put("AaAaBB", "Kart Arman1");
//
        System.out.println(tree.get("ccc"));
        System.out.println(tree.get("AaAaAa"));
        System.out.println(tree.get("AaAaBB"));
        System.out.println();

        //Ассоциативный массив
        AssocArrayString array = new AssocArrayString();
        array.put("aaa", "AAA");
//        array.put("bbb", "BBB");
//        array.put("ccc", "CCC");
        array.put("AaAaAa", "Kart Arman");
        array.put("AaAaBB", "Kart Arman1");
        System.out.println(array.get("рпнкекн"));
        System.out.println(array.get("AaAaAa"));
        System.out.println(array.get("AaAaBB"));
    }
}
