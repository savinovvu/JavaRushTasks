package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        char[] charsWord = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
        char[] charsDigits = "1234567890".toCharArray();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            builder.append(charsWord[(int) (Math.random() * 26)]);
        }
        for (int i = 0; i < 2; i++) {
            builder.append(String.valueOf(charsWord[(int) (Math.random() * 26)]).toUpperCase());

        }
        for (int i = 0; i < 2; i++) {
            builder.append(charsDigits[(int) (Math.random() * 10)]);
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(builder.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return byteArrayOutputStream;
    }
}