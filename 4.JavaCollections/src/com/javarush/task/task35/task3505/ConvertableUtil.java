package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertableUtil  {

    public static <K extends Convertable> Map convert(List<K> list) {
        Map collect = list.stream().collect(Collectors.toMap(x -> x.getKey(), x -> x));
        return new HashMap(collect);
    }
}
