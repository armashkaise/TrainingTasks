package Lessons.UploadFromFile;

import Lessons.Lesson9Collections.Task1.CityObject;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.AreaSize;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Park;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Street;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Main<T> {
    public static void main(String[] args) {
        Scanner scan = UploadFile();
        var streets = uploadObjectsFromFile(scan, "Street");
        scan = UploadFile();
        var parks = uploadObjectsFromFile(scan, "Park");
        System.out.println(streets);
        System.out.println(parks);

    }

    private static Scanner UploadFile() {
        URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
        File file = new File(location.getFile() + "/citiesObjects.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Scanner scan = new Scanner(bufferedReader);
        return new Scanner(bufferedReader);
    }

    private static <T extends AreaSize> Set<T> uploadObjectsFromFile(Scanner scan, String nameClass) {
        Set<T> citiesObjectsSet = new HashSet<>();
        Set<Map<String, String>> allSitiesObjects = new HashSet<>();

        while (scan.hasNextLine()) {
            allSitiesObjects.add(parseLine(scan.nextLine()));
        }
        scan.close();
        Set<Map> objectsSet = allSitiesObjects.stream().peek(s -> s.values()).filter(s -> nameClass.equals(s.get("class"))).collect(Collectors.toSet());
        for (Map objectSet : objectsSet) {
            citiesObjectsSet.add(createCitiesObject((Map<String, String>) objectSet));
        }
        return citiesObjectsSet;
    }

    private static  <T extends AreaSize> T createCitiesObject(Map<String, String> oneObjectFromLine) {
        T newObject = null;
        String nameClass = oneObjectFromLine.get("class");
        String name = oneObjectFromLine.get("name").trim();
        int lenght = Integer.parseInt(oneObjectFromLine.get("lenght").trim());
        int width = Integer.parseInt(oneObjectFromLine.get("width").trim());
        if (nameClass.equals("Street")) {
            newObject = (T) new Street(name, lenght, width);
        }
        if (nameClass.equals("Park")) {
            newObject = (T) new Park(name, lenght, width);
        }

        return newObject;
    }

    private static Map<String, String> parseLine(String nextLine) {
        Map<String, String> currentMap = new HashMap<>();
        String[] split = nextLine.split(",");
        for (int i = 0; i < split.length; i++) {
            String[] s = split[i].split(":");
            String key = s[0].trim();
            String value = checkValue(key, s[1]);
            if (Objects.nonNull(key) && Objects.nonNull(value))
                currentMap.put(key, value);
        }
        return currentMap;
    }

    private static String checkValue(String key, String value) {
        if (("id".equals(key)) && ("null".equals(value)))
            return UUID.randomUUID().toString();
        return value;
    }
}