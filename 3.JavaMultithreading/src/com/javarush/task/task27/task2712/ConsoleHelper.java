package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConsoleHelper {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        writeMessage(Dish.allDishesToString());
        List<Dish> dishes = new ArrayList<>();
        for (String choiseDishName = readString(); !"exit".equals(choiseDishName); choiseDishName = readString()) {
            String finalChoiseDishName = choiseDishName;
            Dish dish = Arrays.stream(Dish.values()).filter(dishValue -> finalChoiseDishName.equals(dishValue.toString())).findFirst().orElse(null);
            if (Objects.isNull(dish)) {
                writeMessage("такого блюда нет");
            } else {
                dishes.add(dish);
            }
        }
        return dishes;
    }


}
