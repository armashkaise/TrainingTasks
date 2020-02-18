package Lessons.Lesson9Collections;

import java.util.Objects;

public class Damage {
    private String name;
    private double lenght;
    private double width;
    public Damage next;
//    private int countDamage;

    public Damage(String name, double lenght, double width) {
        this.name = name;
        this.lenght = lenght;
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {
        this.lenght = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Damage getNext() {
        return next;
    }

    public void setNext(Damage next) {
        this.next = next;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Damage damage = (Damage) o;
        return Objects.equals(name, damage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
