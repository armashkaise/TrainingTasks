package Lessons.Lesson9Collections.Task1;

import java.util.Objects;

public class Road<T> extends CityObject implements Calculable<T> {
    private String roadName;
    private String coating;

    private int countDamage;

    private Road(double lenght, double width, String roadName, String coating) {
        this.lenght = lenght;
        this.width = width;
        this.roadName = roadName;
        this.coating = coating;

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
        return "Road{" +
                "roadName='" + roadName + '\'' +
                ", coating='" + coating + '\'' +
                '}';
    }

    public static class Builder {
        private double lenght;
        private double width;
        private String roadName;
        private String coating;;

        public Road build() {
            Road road = new Road(lenght, width, roadName, coating);
            lenght = 0;
            width = 0;
            roadName = null;
            coating = null;
            return road;
        }

        public Builder setLenght(double lenght){
            this.lenght = lenght;
            return this;
        }

        public Builder setWidth(double width){
            this.width = width;
            return this;
        }

        public Builder setRoadName(String roadName){
            this.roadName = roadName;
            return this;
        }

        public Builder setCoating(String coating){
            this.coating = coating;
            return this;
        }

    }
}
