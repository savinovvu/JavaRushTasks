package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) {
        String name = args[0];
        Set<FileInputStream> fileInputStreams = new TreeSet<>();
        for (int i = 1; i < args.length; i++) {
            try {
                fileInputStreams.add(new FileInputStream(args[i]));
            } catch (FileNotFoundException e) {
            }
        }

        InputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(fileInputStreams));
        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        try (OutputStream fileOutputStream = new FileOutputStream(name)) {

            byte[] buf = new byte[1024 * 1024];
            while (zipInputStream.getNextEntry() != null) {
                int count;
                while ((count = zipInputStream.read(buf)) != -1) {
                    fileOutputStream.write(buf, 0, count);
                }
            }

            sequenceInputStream.close();
            zipInputStream.close();
        } catch (IOException e) {
        }

    }
}
