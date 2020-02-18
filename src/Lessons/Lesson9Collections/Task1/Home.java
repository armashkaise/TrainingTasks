package Lessons.Lesson9Collections.Task1;

import java.util.Objects;

public class Home<T> extends CityObject implements Calculable<T> {
    private String color;
    private int countFloor;
    private String typeHome;
    private String adress;

    private int countDamage;
//    double lenght;
//    double width;

    private Home(double lenght, double width, String color, String adress, int countFloor, String typeHome) {
        this.lenght = lenght;
        this.width = width;
        this.color = color;
        this.adress = adress;
        this.countFloor = countFloor;
        this.typeHome = typeHome;
    }

    @Override
    public String toString() {
        return "Home{" +
                "color='" + color + '\'' +
                "adress='" + adress + '\'' +
                ", countFloor=" + countFloor +
                ", typeHome='" + typeHome + '\'' +
                '}';
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
                //!currentDamage.equals(damage) &&
                currentDamage = currentDamage.next;
            }
            currentDamage.next = new Damage(name, lenght, width);

        }
        countDamage++;
        return (T) this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAdress(String adress) {
        this.adress = adress;
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



    public static class Builder {
        private String color;
        private String adress;
        private int countFloor;
        private double lenght;
        private double width;
        private String typeHome;

        public Home build() {
            Home home = new Home(lenght, width, color, adress, countFloor, typeHome);
            lenght = 0;
            width = 0;
            color = null;
            adress = null;
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

        public Builder setAdress(String adress){
            this.adress = adress;
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
