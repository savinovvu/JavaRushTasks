package com.javarush.task.task36.task3605;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(args[0]);
        List<String> strings = Files.readAllLines(path);
        Set<Character> characters = new TreeSet<>();

        Set<String> stringSet = strings.stream()
                .flatMap(v -> v.chars()
                        .mapToObj(e -> (char) e).collect(Collectors.toList()).stream())
                .map(v -> String.valueOf(v).toLowerCase())
                .collect(Collectors.toCollection(TreeSet::new));

        stringSet.stream().limit(5).forEach(System.out::println);
    }
}
