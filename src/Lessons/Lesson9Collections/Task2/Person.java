package Lessons.Lesson9Collections.Task2;

public class Person implements Comparable<Person>{
    private String name;
    private String rank;

    public Person(String name, String rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Person o) {
//        String compareRank = ((Person) o).getRank();
//        return this.rank - compareRank;
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
