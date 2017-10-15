package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        // implement this method
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();
        String fileName = Paths.get(urlString).getFileName().toString();
        System.out.println(fileName);
        Path destPath = downloadDirectory.resolve(fileName);
        System.out.println(destPath);

        Path tmp = Files.createTempFile("temp-", "");
        Files.copy(inputStream, tmp);

        Files.move(tmp, destPath);
        inputStream.close();
        return destPath;
    }
}
