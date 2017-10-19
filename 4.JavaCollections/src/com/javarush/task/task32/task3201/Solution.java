package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0],"rw");
        long length = randomAccessFile.length();
        Long aLong = Long.valueOf(args[1]);
        if (aLong > length) {
            aLong = length;
        }
        randomAccessFile.seek(aLong);
        randomAccessFile.write(args[2].getBytes());

    }
}
