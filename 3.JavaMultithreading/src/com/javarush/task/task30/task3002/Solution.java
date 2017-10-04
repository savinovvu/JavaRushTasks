package com.javarush.task.task30.task3002;

/*
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        if (s == null) return null;
        if (s.contains("0x")) return String.valueOf(Integer.parseInt(s.split("x")[1], 16));
        if (s.contains("0b")) return String.valueOf(Integer.parseInt(s.split("b")[1], 2));
        if (s.substring(0, 1).equals("0")) return String.valueOf(Integer.parseInt(s, 8));

        return String.valueOf(Integer.parseInt(s, 10));
    }
}
