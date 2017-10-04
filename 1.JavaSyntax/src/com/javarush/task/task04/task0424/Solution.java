package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer[] array = new Integer[3];
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.valueOf(reader.readLine());
        }
        Map<Integer, Integer> map = Arrays.asList(array).stream().collect(Collectors.toMap(Function.identity(), v -> 1, (k1, k2) -> k1 + 1));
        List<Integer> collect = map.entrySet().stream().filter(v -> v.getValue() < 2).map(Map.Entry::getKey).collect(Collectors.toList());
        if (collect.size()> 2 ) return;

                collect.forEach(v -> {
                    for (int i = 0; i < array.length; i++) {
                        if (v.equals(array[i])) {
                            System.out.println(i+1);
                        }
                    }
                });
    }
}
