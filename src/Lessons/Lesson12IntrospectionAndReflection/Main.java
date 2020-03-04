package Lessons.Lesson12IntrospectionAndReflection;

import Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.CorporateWorkes;
import Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager;
//import Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager;

import java.lang.reflect.*;
import java.util.Set;

import static Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Uploader.upload;

public class Main {
    public static void main(String[] args) throws Exception {
//        Class<Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager> managerClass = Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager.class;
//        Constructor<?>[] declaredConstructors = managerClass.getDeclaredConstructors();
//
//        Constructor<?> declaredConstructor = declaredConstructors[0];
//        declaredConstructor.setAccessible(true);
//
//        Object manager = declaredConstructors[0].newInstance();
//
//        Field nameManager = managerClass.getDeclaredField("nameManager");
//        nameManager.setAccessible(true);
//
//        nameManager.set(manager, "hz");
//
//        Method getManagerName = managerClass.getDeclaredMethod("getNameManager");
//        getManagerName.setAccessible(true);
//
//        System.out.println(getManagerName.invoke(manager));

        //********************************************домашнее задание****************************************
        System.out.println("инстанцировать объект с помощью рефлексии с параметризированным конструктором");
        Class<Manager> managerClass = Manager.class;
        Constructor<Manager> constructor = managerClass.getConstructor(String.class, String.class, int.class);
        Manager managerIvanov = constructor.newInstance("Ivanov", "Ivan", 10);
        System.out.println(managerIvanov);
        System.out.println();

        System.out.println("выбрать разные методы с разным количеством параметров");
//        Class<Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager> managerClass1 = Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager.class;
//        Method methodGetName = managerClass.getDeclaredMethod("getName");
//        methodGetName.setAccessible(true);
//        System.out.println("method without parameters: " + methodGetName.getName());

        CorporateWorkes realManager = new Manager();

        Class<? extends CorporateWorkes> managerClass2 = Manager.class;

        Method getOnlyName = Manager.class.getDeclaredMethod("getOnlyName", String.class);
        getOnlyName.setAccessible(true);
        Object aaa = getOnlyName.invoke(realManager, "aaa");
        System.out.println("method with 1 parametr: " + aaa);

        Method getNameAndSurname = managerClass2.getDeclaredMethod("getNameAndSurname", String.class, String.class);
        getNameAndSurname.setAccessible(true);
        Object aaabbb = getNameAndSurname.invoke(realManager, "aaa", "bbb");
        System.out.println("method with 2 parametrs: " + aaabbb);


        Method getNameAndSurnameAndAge = Manager.class.getDeclaredMethod("getNameAndSurname", String.class, String.class, int.class);
        getNameAndSurnameAndAge.setAccessible(true);
        Object aaabbbccc = getNameAndSurnameAndAge.invoke(realManager, "aaa", "bbb", 123);
        System.out.println("method with 3 parametrs: " + aaabbbccc);
        System.out.println();

        System.out.println("вызываем setter");
        Class<Manager> managerClass3 = Manager.class;
        Method setName = managerClass3.getDeclaredMethod("setName", String.class);
        Object petrov = setName.invoke(realManager, "Petrov");
        Method getName = Manager.class.getDeclaredMethod("getName");
        System.out.println(getName.invoke(realManager));
        System.out.println();
//**********************************************************************************************************************
        System.out.println("загрузка из файл Menegers и работа с ними через getters и setters");
        Set<?> sets = upload();

//        Set<Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager> streets = uploadObjectsFromFile(scan);


    }


}
