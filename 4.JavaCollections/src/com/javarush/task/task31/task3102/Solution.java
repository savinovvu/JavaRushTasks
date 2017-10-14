package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File[] array = new File(root).listFiles();
        List<String> fileList = new ArrayList<>();
        Deque<File> queue = new ArrayDeque<>();
        for (File file : array) {
            checkDirectory(queue, file);
            checkFile(fileList, file);
        }


       while (queue.size() > 0){
            File directory = queue.pop();
            File[] files = directory.listFiles();
            if (files.length == 0) continue;

            for (File file : files) {
                checkDirectory(queue, file);
                checkFile(fileList, file);
            }
        }
        return fileList;
    }

    private static void checkFile(List<String> fileList, File file) {
        if (file.isFile()) {
            fileList.add(file.getAbsolutePath());
        }
    }

    private static void checkDirectory(Deque<File> deque, File file) {
        if (file.isDirectory()) {
            deque.push(file);
        }
    }

    public static void main(String[] args) {
        try {
            List<String> fileTree = getFileTree(args[0]);
            fileTree.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
