package Lessons.Lesson12IntrospectionAndReflection;

import java.lang.reflect.*;

public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        SomeClass someClass = new SomeClass();
        Class clss = someClass.getClass();
        Class clss2 = SomeClass.class;
        Class clss3 = Class.forName("Lessons.Lesson12IntrospectionAndReflection.SomeClass");
        SomeClass someClass1 = (SomeClass) clss.getDeclaredConstructor().newInstance();

        Constructor[] constructors = clss2.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println();
        System.out.println("Methods");
        Method[] methods = clss2.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println();
            System.out.println(method.getName());
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType().getName());
            }
            System.out.println(Modifier.toString(method.getModifiers()));
        }

        System.out.println(methods[0].invoke(someClass, "a"));
//        System.out.println();
//        System.out.println("Fields");
//


//        System.out.println();
//        System.out.println("*****************************Работа с переменными*************************");
//        System.out.println(fields[0].getType());
//        System.out.println(fields[0].getName());
//        fields[0].setAccessible(true);
//        System.out.println(fields[0].getInt(someClass));
//        fields[0].set(someClass, 5);
//        System.out.println(fields[0].getInt(someClass));
    }
}

class SomeClass {
    private int i;
    String s;

    public SomeClass() {
    }

    public SomeClass(String s) {
        this.s = s;
    }

    public String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }

    public String someMethod1(String a, String b) {
        System.out.println("this is " + a + " " + b);
        return a + b;
    }

    private synchronized String someMethod2(String a, String b, String c) {
        System.out.println("this is " + a + " " + b + " " + c);
        return a + b + c;
    }
}

