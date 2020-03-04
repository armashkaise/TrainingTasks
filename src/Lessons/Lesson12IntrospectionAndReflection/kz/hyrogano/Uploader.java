package Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano;

import Lessons.UploadFromFile.Main;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Uploader<T> {
    
    public static Set<?> upload() throws Exception {
        Scanner scanner = connectToFile();
        return uploadObjectsFromFile(scanner);
    }

    private static Scanner connectToFile() {
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

    private static <T> T uploadObjectsFromFile(Scanner scan) throws Exception {
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

    private static <T> T createObjectFromLine(Map<String, String> map) throws URISyntaxException {

        String className = map.get("class");
        Path path = Paths.get(Uploader.class.getResource(".").toURI());
        path = Paths.get("C:/Users/ktzhadmin/IdeaProjects/TrainingTasks/production/TrainingTasks/Lessons/Lesson12IntrospectionAndReflection/kz/hyrogano/Lessons/Lesson12IntrospectionAndReflection/kz/hyrogano/Manager");
//        path = Paths.get("C:\\Users\\ktzhadmin\\IdeaProjects\\TrainingTasks\\production\\TrainingTasks\\Lessons\\Lesson12IntrospectionAndReflection\\kz\\hyrogano\\Lessons.Lesson12IntrospectionAndReflection.kz.hyrogano.Manager");
        try {
            Class clazz = Class.forName(path + "");
//            Class<? extends CorporateWorkes> clazz = (Class<? extends CorporateWorkes>) Class.forName(path + "/" + firstUpperCase(className.trim()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }

    private static Object firstUpperCase(String word) {
            if(word == null || word.isEmpty()) return "";//или return word;
            return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
