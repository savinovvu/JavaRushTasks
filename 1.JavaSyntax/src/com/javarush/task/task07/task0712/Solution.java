package com.javarush.task.task07.task0712;

/*
Самые-самые
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strings.add(reader.readLine());
        }
        reader.close();
        List<String> sorted = new ArrayList<>(strings);
        Collections.sort(sorted, (v1, v2) -> v1.length()-v2.length());
        int a = sorted.get(0).length();
        int b = sorted.get(sorted.size()-1).length();
        for (String s :strings) {
            if (s.length() == a || s.length() == b){
                System.out.println(s);
                return;
            }
        }


    }
}
