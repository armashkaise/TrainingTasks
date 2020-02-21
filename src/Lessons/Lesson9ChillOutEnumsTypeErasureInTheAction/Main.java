package Lessons.Lesson9ChillOutEnumsTypeErasureInTheAction;

import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.LinkedList;
import Lessons.Lesson3AbstractClassesKeywordFinalInterfaces.List;

public class Main {
    public static void main(String[] args) {
//        showMeStatus(Status.NOT_AVAILABLE);
        Status available = Status.valueOf("AVAILABLE");
        System.out.println(available == Status.AVAILABLE);

        List<Number> number = new LinkedList<>();
        number.add(1);
        number.add(2L);
//        List object = number;
//        object.add("AAA");
//        object.add(10);
        System.out.println();
//        number.forEach(System.out::println);

    }

    private static void showMeStatus(Status status) {
        System.out.println(status.show());
    }
}

enum Status implements Idterator{
    AVAILABLE {
        @Override
        public int show() {
            return 1;
        }
    },
    NOT_AVAILABLE {
        @Override
        public int show() {
            return 0;
        }
    },
    BUSY {
        @Override
        public int show() {
            return 2;
        }
    }
}

interface Idterator {
    int show();
}
