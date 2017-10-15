package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

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
        new SimpleFileVisitor<Path>(){

        };
//        Files.walkFileTree(path,);



    }
}
