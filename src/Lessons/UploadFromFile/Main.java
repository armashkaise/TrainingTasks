package Lessons.UploadFromFile;

import Lessons.Lesson9Collections.Task1.CityObject;
import Lessons.Lesson9WildcardAndPECS.yet.another.fuckup.Street;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.*;

public class Main<T> {
    public static void main(String[] args) {


        Scanner scan = UploadFile();

        Set<Street> streets = parseString(scan);

//        List<Map> streetsList = stringsMap.stream().peek(s -> s.values()).filter(s -> "Street".equals(s.get("class"))).collect(Collectors.toList());
//        List<Map> parksList = stringsMap.stream().peek(s -> s.values()).filter(s -> "Park".equals(s.get("class"))).collect(Collectors.toList());

//        System.out.println(streetsList);
//        System.out.println(parksList);

    }

    private static Scanner UploadFile() {
        URL location = Main.class.getProtectionDomain().getCodeSource().getLocation();
//        Set<Map> stringsMap = new HashSet<>();
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

    private static <T extends CityObject> Set<T> parseString(Scanner scan) {
        Set<T> citiesObjectsSet = null;
        while (scan.hasNextLine()) {
            Map<String, String> oneObjectFromLine = parseLine(scan.nextLine());
            if (Objects.nonNull(oneObjectFromLine)){
                citiesObjectsSet.add(createCitiesObject(oneObjectFromLine));
//                citiesObjectsSet.add(new <T>(oneObjectFromLine.get("name"), oneObjectFromLine.get("lenght"), oneObjectFromLine.get("width")));
            }



        }
        return null;
    }

    private static Street createCitiesObject(Map<String, String> oneObjectFromLine) {
        String name = oneObjectFromLine.get("name");
        int lenght = Integer.parseInt(oneObjectFromLine.get("lenght"));
        int width = Integer.parseInt(oneObjectFromLine.get("width"));
        return new Street(name, lenght, width);
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