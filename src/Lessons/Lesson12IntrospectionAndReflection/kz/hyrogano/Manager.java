package Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano;

import Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.CorporateWorkes;

import java.util.Objects;

public class Manager extends CorporateWorkes {

    public Manager() {
    }

    public Manager(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getOnlyName(String name1) {
        return "this function  outputs only name: " +name1;
    }

    private String getNameAndSurname(String name1, String surName1) {
        return "this is the function of adding the name and surname: " + name1 + " " + surName1;
    }

    private String getNameAndSurname(String name1, String surName1, int age1) {
        return "this is the function of adding the name, surname and age: " + name1 + " " + surName1 + " " + age1;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSurName() {
        return surName;
    }

    @Override
    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
