package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

import java.util.Objects;

public class Animal {
    private final int hashCode;
    private final String name;
    private final int colLimb;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return colLimb == animal.colLimb &&
                Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    private Animal(String name, int colLimb) {
        this.name = name;
        this.colLimb = colLimb;
        hashCode = Objects.hash(name, colLimb);
    }

    public static class AnimalBuilder {
        private int hashCode;
        private String name;
        private int colLimb;

        public Animal build() {
            var animal = new Animal(name, colLimb);
            this.name = null;
            this.colLimb = 0;
            return  animal;
        }

        public AnimalBuilder addName (String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder addColLimb (int colLimb) {
            this.colLimb = colLimb;
            return this;
        }
    }


}
