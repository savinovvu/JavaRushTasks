package com.javarush.task.task04.task0417;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            array.add(Integer.valueOf(reader.readLine()));
        }
        reader.close();
        Map<Integer, Integer> collect = array.stream().collect(Collectors.toMap(Function.identity(), v -> 1, (k1, k2) -> k1 + 1));
        StringBuilder s = new StringBuilder();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : collect.entrySet()) {
            if (integerIntegerEntry.getValue() > 1) {
                for (int i = 0; i < integerIntegerEntry.getValue(); i++) {
                    if (i != integerIntegerEntry.getValue() - 1) {
                        s.append(integerIntegerEntry.getKey() + " ");
                    } else s.append(integerIntegerEntry.getKey());
                }
            }
        }
        if (!"".equals(s.toString())) {
            System.out.println(s.toString());
        }
    }


}