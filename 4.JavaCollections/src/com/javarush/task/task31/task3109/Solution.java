package com.javarush.task.task31.task3109;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("/mnt/BEFA1108FA10BE99/4. РАБОТА/4. JavaRush/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("/mnt/BEFA1108FA10BE99/4. РАБОТА/4. JavaRush/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        Path path = Paths.get(fileName);
        String[] splitedPath = fileName.split("\\.");
        String ext = splitedPath[splitedPath.length - 1];
        if (Files.exists(path)) {
            try (InputStream inputStream = new FileInputStream(fileName)) {

                if ("xml".endsWith(ext)) {
                    properties.loadFromXML(inputStream);
                } else {
                    properties.load(inputStream);
                }
            } catch (IOException e) {
            }
        }
        return properties;
    }
}
