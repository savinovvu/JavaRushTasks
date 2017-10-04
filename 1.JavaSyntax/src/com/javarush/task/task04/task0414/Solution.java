package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.valueOf(reader.readLine());
        reader.close();
        if (checkyear(integer)){
            System.out.println("количество дней в году: 366");
        }else
        System.out.println("количество дней в году: 365");

    }

    private static boolean checkyear(Integer integer) {
        if (integer % 4 == 0){
            if (integer % 100==0 && integer % 400 !=0){
                return false;
            }
            return true;
        } else return false;
    }
}