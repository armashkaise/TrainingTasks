package Lessons.Lesson9Collections;

import java.util.Objects;

public class Home extends CityObject implements Calculable{
    private String color;
    private int countFloor;
    private String typeHome;
    private Damage damage;
    private int countDamage;
//    double lenght;
//    double width;

    private Home(double lenght, double width, String color, int countFloor, String typeHome) {
        this.lenght = lenght;
        this.width = width;
        this.color = color;
        this.countFloor = countFloor;
        this.typeHome = typeHome;
    }

    public Home addDamage(String name, double lenght, double width) {
        if (Objects.isNull(name)) return null;
        Damage currentDamage = this.damage;

        if (Objects.isNull(currentDamage)) {
            this.damage = new Damage(name, lenght, width);
        }
        else {
            while (Objects.nonNull(currentDamage.next)) {
                //!currentDamage.equals(damage) &&
                currentDamage = currentDamage.next;
            }
            currentDamage.next = new Damage(name, lenght, width);

        }
        countDamage++;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountFloor() {
        return countFloor;
    }

    public void setCountFloor(int countFloor) {
        this.countFloor = countFloor;
    }

    public String getTypeHome() {
        return typeHome;
    }

    public void setTypeHome(String typeHome) {
        this.typeHome = typeHome;
    }

    public Damage getDamage() {
        return damage;
    }

    @Override
    public double calcSquare() {
        return 0;
    }

    @Override
    public double calcLength() {
        return 0;
    }

    @Override
    public double calcDamage() {
        return 0;
    }

    public static class Builder {
        private String color;
        private int countFloor;
        private double lenght;
        private double width;
        private String typeHome;

        public Home build() {
            Home home = new Home(lenght, width, color, countFloor, typeHome);
            lenght = 0;
            width = 0;
            color = null;
            countFloor = 0;
            typeHome = null;
            return home;
        }

        public Builder setLenght(double lenght){
            this.lenght = lenght;
            return this;
        }

        public Builder setWidth(double width){
            this.width = width;
            return this;
        }

        public Builder setColor(String color){
            this.color = color;
            return this;
        }

        public Builder setCountFloor(int countFloor){
            this.countFloor = countFloor;
            return this;
        }

        public Builder setTypeHome(String typeHome){
            this.typeHome = typeHome;
            return this;
        }
    }
}
