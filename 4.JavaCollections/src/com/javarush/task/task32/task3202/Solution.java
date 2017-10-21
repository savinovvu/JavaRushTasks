package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("/mnt/BEFA1108FA10BE99/4. РАБОТА/4. JavaRush/filesFolder/allFiles.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter writer = new StringWriter();
        try {
            byte[] array = new byte[is.available()];
            while (is.available() != 0) {
                is.read(array);
            }

            writer.write(new String(array));
        } catch (Exception e) {
            return new StringWriter();
        }

        return writer;
    }
}