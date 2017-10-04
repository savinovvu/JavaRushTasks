package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
2
2
5
5
5
8
5
4
4
14
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>(10);
        int n = 1,max = 0;

        list.add(Integer.parseInt(reader.readLine()));
        for(int i = 1;i<10;i++){
            list.add(Integer.parseInt(reader.readLine()));
            if(list.get(i).equals(list.get(i-1))) n++;
            else n = 1;
            if (n>max) max = n;
        }
        System.out.println(max);

    }}
