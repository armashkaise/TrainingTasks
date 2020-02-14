package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

import java.util.Objects;

public class Human {

    private int hashCode;
    private final String name;
    private final String surname;
    private final String dob;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) &&
                Objects.equals(surname, human.surname) &&
                Objects.equals(dob, human.dob);
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    private Human(String name, String surname, String dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        if (hashCode == 0) {
            hashCode = Objects.hash(name, surname, dob);
        }
    }

    static class HumanBuilder {
        private String name;
        private String surname;
        private String dob;

        public Human build() {
            Human human = new Human(name, surname, dob);
            name = null;
            surname = null;
            dob = null;
            return human;
        }

        public HumanBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public HumanBuilder withDob(String dob) {
            this.dob = dob;
            return this;
        }
    }
}
