package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

public class Main {
    public static void main(String[] args) throws OutOfBoundException{

        var humanBuilder = new Human.HumanBuilder();
        Human build = humanBuilder.withName("Ivan").withSurname("Ivanov").withDob("01/01/1980").build();

        var animalBuilder = new Animal.AnimalBuilder();
        var animal = animalBuilder.addName("Los").addColLimb(4).build();

        List<Integer> intLinkedList = new LinkedList<>();
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

    private static boolean doIt(List intLinkedList) {
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
