package com.javarush.task.task32.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        Long number = Long.valueOf(args[1]);
        String text = args[2];
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileName, "rw");
        randomAccessFile.seek(number);
        byte[] mass = new byte[text.length()];
        randomAccessFile.read(mass, 0 , mass.length);
        String fileText = convertByteToString(mass);
        randomAccessFile.seek(randomAccessFile.length());
        byte[] writesBytes ;
        if (text.equals(fileText)) {
            writesBytes = String.valueOf("true").getBytes();
        } else {
            writesBytes = String.valueOf("false").getBytes();
        }
        randomAccessFile.write(writesBytes);
    }

    public static String convertByteToString(byte readBytes[]) {
        return new String(readBytes);
    }
}
