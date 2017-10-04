package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        while (true){
            int i = Integer.parseInt(reader.readLine());
            if (i == -1) break;
            list.add(i);
        }
        reader.close();
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum/ (double) list.size());

    }
}

