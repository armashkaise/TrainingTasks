package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

import jdk.internal.joptsimple.internal.Strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.spec.ECField;
import java.util.Objects;

public class Order {

    public int number;
    public String owner;
    private int hashCode = 0;

    public Order(int number, String owner) {
        this.owner = owner;
        this.number = number;
        hashCode = this.hashCode();
    }

    public Order(String url) {
       try {
           File file = new File(url);
           FileReader fileReader = new FileReader(file);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String line;
           while (!Strings.isNullOrEmpty(line = bufferedReader.readLine())){
               String[] splitedLine = line.split(":");
               String key = splitedLine[0].trim();
               String value = splitedLine[1].trim();
               switch (key) {
                   case "number":
                       this.number = Integer.valueOf(value);
                       break;
                   case "owner":
                       this.owner = value;
                       break;
               }

           }
       } catch (Exception e) {
           this.owner = null;
           this.number = -1;
           throw new RuntimeException(e);
       } finally {

       }
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
