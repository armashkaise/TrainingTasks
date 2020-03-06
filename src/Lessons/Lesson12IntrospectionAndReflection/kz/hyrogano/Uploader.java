package Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano;

import Lessons.UploadFromFile.Main;


import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Uploader<T> {
    
    public static <T> Set<T> selectObjects(Set setOfObjects, Class className) {
        Stream stream = setOfObjects.stream();
        var collect = (Set<T>) stream
                .filter(s -> className.equals(s.getClass()))
                .collect(Collectors.toSet());
        return collect;
    }

    public static <T> T uploadObjectsFromFile() throws Exception {
        Set<T> corporateWorkesList = new HashSet<>();
        Set<Map<String, String>> setOfMaps = new HashSet<>();
        Path path = Path.of("/OfficeWorkers.txt");
        FileReader fileReader = new FileReader(Main.class.getProtectionDomain().getCodeSource().getLocation().getFile() + "/OfficeWorkers.txt");
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)){
           setOfMaps = bufferedReader.lines().map(s -> parseLine(s)).collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println(e);
        }
        for (Map<String, String> setOfMap : setOfMaps) {
            corporateWorkesList.add(createObjectFromLine(setOfMap));
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

    private static <T> T createObjectFromLine(Map<String, String> map) throws Exception {
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
        return constructor.newInstance(name, surName, age);
    }

    private static Object firstUpperCase(String word) {
            if(word == null || word.isEmpty()) return "";//или return word;
            return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
