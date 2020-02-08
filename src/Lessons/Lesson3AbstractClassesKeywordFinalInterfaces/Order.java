package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

import java.util.Objects;

public class Order {

    public final int number;
    public final String owner;
    private int hashCode = 0;

    public Order(int number, String owner) {
        this.owner = owner;
        this.number = number;
        hashCode = this.hashCode();
    }

    public Order changeNumber (int number){
        return new Order(number, this.owner);
    }

    public Order changeOwner (String owner){
        return new Order(this.number, owner);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return number == order.number &&
                Objects.equals(owner, order.owner);
    }

    @Override
    public int hashCode() {
        if (hashCode == 0)
            hashCode = Objects.hash(number, owner);
        return hashCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "number=" + number +
                ", owner='" + owner + '\'' +
                ", hashCode=" + hashCode +
                '}';
    }
}
