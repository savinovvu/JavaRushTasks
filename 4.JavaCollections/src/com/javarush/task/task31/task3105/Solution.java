package com.javarush.task.task31.task3105;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(args[1]));
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(args[1]));
        zipOutputStream.putNextEntry(new ZipEntry(args[0]));
        zipOutputStream.close();
//        zipInputStream.close();
    }
}
