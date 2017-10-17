package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Что внутри папки?
*/
public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine());
        if (!Files.isDirectory(path)) {
            System.out.println(path + " - не папка");
            return;
        }
        final List<Integer> foldersCounter = new ArrayList<>();
        final List<Integer> filesCounter = new ArrayList<>();
        final List<Integer> sizeCounter = new ArrayList<>();
        sizeCounter.add(Integer.valueOf(0));

        SimpleFileVisitor<Path> simpleFileVisitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                foldersCounter.add(1);
                return super.preVisitDirectory(dir, attrs);
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                sizeCounter.add(sizeCounter.get(sizeCounter.size() - 1) + Files.readAllBytes(file).length);
                filesCounter.add(1);

                return super.visitFile(file, attrs);
            }

        };
        Files.walkFileTree(path, simpleFileVisitor);

        System.out.println("Всего папок - " + (foldersCounter.size()-1));
        System.out.println("Всего файлов - " + filesCounter.size());
        System.out.println("Общий размер - " + sizeCounter.get(sizeCounter.size() - 1));


    }
}

