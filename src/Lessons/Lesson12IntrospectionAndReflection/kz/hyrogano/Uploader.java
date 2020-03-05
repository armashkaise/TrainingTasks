package Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano;

import Lessons.UploadFromFile.Main;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Uploader<T> {
    
    public static <T> Set<T> selectObjects(Set setOfObjects) {
        determinClassToGeneric(Uploader.class);
        Stream stream = setOfObjects.stream();
        Object collect = stream.peek(s -> s.getClass())
                .filter(s -> s<T>)
                .collect(Collectors.toSet());


        return null;
    }

    private static void determinClassToGeneric(Class<Uploader> uploaderClass) {
        ParameterizedType t = (ParameterizedType) uploaderClass.getClass().getGenericSuperclass();
        Class<?> cls = (Class<?>) t.getActualTypeArguments()[0];
        System.out.println(cls); // напечатает TestClass#GenericClass
    }

    public static Scanner connectToFile() {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "/Managers.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner scanner = new Scanner(bufferedReader);
        return scanner;
    }

    public static <T> T uploadObjectsFromFile(Scanner scan) throws Exception {
        Set<T> corporateWorkesList = new HashSet<>();
        while (scan.hasNextLine()){
            corporateWorkesList.add(createObjectFromLine(parseLine(scan.nextLine())));

        }




        return (T) corporateWorkesList;
    }

    private static Map<String, String> parseLine(String nextLine) {
        Map<String, String> currentMap = new HashMap<>();
        String[] split = nextLine.split(";");
        for (int i = 0; i < split.length; i++) {
            String[] s = split[i].split(":");
            String key = s[0].trim();
            String value = s[1].trim();
            if (Objects.nonNull(key) && Objects.nonNull(value))
                currentMap.put(key, value);
        }
        return currentMap;
    }

    private static <T> T createObjectFromLine(Map<String, String> map) throws URISyntaxException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<T> TemplateClassType = null;
        String className = (String) firstUpperCase(map.get("class"));
        String path1 = "Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano." + className;
        try {
            TemplateClassType = (Class<T>) Class.forName(path1, true, Uploader.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (Objects.isNull(TemplateClassType)) return null;

        Constructor<T> constructor = TemplateClassType.getConstructor(String.class, String.class, int.class);

        String name = (String) map.get("name");
        String surName = (String) map.get("surname");
        int age = Integer.parseInt(map.get("age"));

//        T newObject = new T(name, surName, age);
//        Class<T> newClass = (Class<T>) classType.class;0


        return constructor.newInstance(name, surName, age);

    }

    private static Object firstUpperCase(String word) {
            if(word == null || word.isEmpty()) return "";//или return word;
            return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
