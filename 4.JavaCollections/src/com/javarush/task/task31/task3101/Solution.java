package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        File folder = new File(args[0]);
        File startFile = new File(args[1]);
        File resultFile = new File(startFile.getParent() + "/" + "allFilesContent.txt");
        FileUtils.renameFile(startFile, resultFile);
        Map<String, String> fileMap = getFilesTree(folder);
        writeFile(resultFile, fileMap);
    }

    private static void writeFile(File resultFile, Map<String, String> fileMap) {

        try (FileWriter fileWriter = new FileWriter(resultFile)) {
            for (String path : fileMap.values()) {
                BufferedReader reader = new BufferedReader(new FileReader(path));
                while (reader.ready()) {
                    fileWriter.write(reader.readLine());
                }
                reader.close();
                fileWriter.write("\n");
            }


        } catch (IOException e) {
        }
    }

    private static Map<String, String> getFilesTree(File folder) {

        Map<String, String> fileMap = new TreeMap<>();
        Deque<File> fileQueue = new ArrayDeque<>();
        fileQueue.add(folder);
        while (fileQueue.size() > 0) {
            File directory = fileQueue.pop();
            File[] files = directory.listFiles();
            if (files.length == 0) continue;
            separateFilesAndFolders(files, fileMap, fileQueue);
        }
        return fileMap;
    }

    private static void separateFilesAndFolders(File[] array, Map<String, String> fileMap, Deque<File> fileQueue) {
        for (File file : array) {
            checkDirectory(fileQueue, file);
            checkFile(fileMap, file);
        }
    }

    private static void checkFile(Map<String, String> fileMap, File file) {
        if (file.isFile()) {
            if (file.length() > 50) {
                FileUtils.deleteFile(file);
            } else {
                if (fileMap.containsKey(file.getName())) {
                    fileMap.put(file.getName() + new Random().nextInt(), file.getAbsolutePath());
                } else {
                    fileMap.put(file.getName(), file.getAbsolutePath());
                }
            }
        }

    }

    private static void checkDirectory(Deque<File> deque, File file) {
        if (file.isDirectory()) {
            deque.push(file);
        }
    }

}
