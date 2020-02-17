package Lessons.Lesson9Collections;

public class Building extends CityObject implements Calculable{
    private String color;
//    double lenght;
//    double width;

    public Building(double lenght, double width, String color) {
        this.lenght = lenght;
        this.width = width;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
}
