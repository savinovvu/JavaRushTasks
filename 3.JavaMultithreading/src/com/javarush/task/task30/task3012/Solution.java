package com.javarush.task.task30.task3012;

/* 
Получи заданное число
74
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(-8);
    }

    public void createExpression(int number) {
        int startNumber = number;
        List<Integer> list = new ArrayList<>();

        for (int i = 0 ;; i++) {
            if (number == 0) break;
            if (number == 1){
                list.add((int) Math.pow(3,i));
                break;
            }
            int remainder = getRemainder(number);
            if (remainder != 0 ) {
                list.add(remainder * (int) Math.pow(3, i));
            }
            number = (number - remainder) / 3;
        }

        System.out.println(startNumber +" =" +buildString(list));
    }

    private int getRemainder(int number) {

        int remainder = number % 3;
        int remainder2 = number-((number/3)+1)*3;
        if (remainder == 0) return 0;
        if (Math.abs(remainder) < Math.abs(remainder2)) {
            return remainder;
        } else return remainder2;
    }

    private String buildString(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (Integer integer : list) {
            if (integer > 0) {
                builder.append(" + " + integer);
            } else
                builder.append(" - " + Math.abs(integer));
        }
        return builder.toString();

    }




}