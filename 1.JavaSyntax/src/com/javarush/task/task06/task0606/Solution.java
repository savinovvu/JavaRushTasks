package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer integer = Integer.valueOf(reader.readLine());
        reader.close();
        while (true) {
            if (integer == 0) break;
            if ((integer % 10) % 2 == 0) even++;
            else odd++;
            integer /=  10;
        }
        System.out.println(String.format("Even: %s Odd: %s", even, odd));
    }
}
