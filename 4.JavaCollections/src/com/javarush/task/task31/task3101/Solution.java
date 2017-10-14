package com.javarush.task.task31.task3101;

import java.io.File;
import java.util.Arrays;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) {

        File folder = new File(args[0]);
        Arrays.stream(folder.listFiles()).map(File::getTotalSpace).forEach(System.out::println);


    }
}
