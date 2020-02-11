package Lessons.Lesson3AbstractClassesKeywordFinalInterfaces;

import jdk.internal.joptsimple.internal.Strings;

import java.io.*;
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
        //FileReader fileReader = null;
       try ( FileReader fileReader = new FileReader(new File(url));
             BufferedReader bufferedReader = new BufferedReader(fileReader);) {

//           url = "/1.txt";
//           File file = ;


           String line;
           while (Objects.nonNull(line = bufferedReader.readLine())){
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
