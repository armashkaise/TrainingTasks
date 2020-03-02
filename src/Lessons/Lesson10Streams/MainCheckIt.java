package Lessons.Lesson10Streams;

import java.util.List;
import java.util.stream.Collectors;

public class MainCheckIt {
    public static void main(String[] args) {
        List<String> names = List.of("Vitja", "Nikita", "Sasha", "Dusha");
//        String all = "";
//        for (String name : names) {
//            all += name + ", ";
//        }
//        System.out.println(all);

        String all = names.stream()
                .peek(System.out::println)
                .collect(Collectors.joining(", ", "All hate Java", " But they don't know it!"));

        System.out.println(all);
    }
}
