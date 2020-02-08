package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

public class Main {
    public static void main(String[] args) throws OutOfBoundException{

        IntList intLinkedList = new IntLinkedList();
        intLinkedList.add(1);
        intLinkedList.add(2);
        intLinkedList.add(3);

//        if (doIt(intLinkedList)) System.out.println("here");
//         System.out.println(intLinkedList.get(-1));
        System.out.println(intLinkedList.get(1));
        System.out.println(intLinkedList.get(5));
//        for (String s : intLinkedList){
//
//        }
    }

    private static boolean doIt(IntList intLinkedList) {
        try {
            System.out.println(intLinkedList.get(2));
            System.out.println(intLinkedList.get(4));
        } catch (OutOfBoundException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            System.out.println("finally");
        }
        return true;
    }
}
