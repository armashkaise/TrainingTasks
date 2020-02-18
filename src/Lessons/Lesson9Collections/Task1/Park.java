package Lessons.Lesson9Collections.Task1;

import java.util.Objects;

public class Park<T> extends CityObject implements Calculable<T> {
    private String parkName;
//    private Damage damage;
    private int countDamage;

    private Park(double lenght, double width, String parkName) {
        this.lenght = lenght;
        this.width = width;
        this.parkName = parkName;
    }

    @Override
    public T addDamage(String name, double lenght, double width) {
        if (Objects.isNull(name)) return null;
        Damage currentDamage = this.damage;

        if (Objects.isNull(currentDamage)) {
            this.damage = new Damage(name, lenght, width);
        }
        else {
            while (Objects.nonNull(currentDamage.next)) {
                currentDamage = currentDamage.next;
            }
            currentDamage.next = new Damage(name, lenght, width);
        }
        countDamage++;
        return (T) this;
    }

    public Damage getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Park{" +
                "parkName='" + parkName + '\'' +
                '}';
    }

    public static class Builder {
        private double lenght;
        private double width;
        private String parkName;

        public Park build() {
            Park park = new Park(lenght, width, parkName);
            lenght = 0;
            width = 0;
            parkName = null;
            return park;
        }

        public Builder setLenght(double lenght){
            this.lenght = lenght;
            return this;
        }

        public Builder setWidth(double width){
            this.width = width;
            return this;
        }

        public Builder setParkName(String parkName){
            this.parkName = parkName;
            return this;
        }

    }
}
