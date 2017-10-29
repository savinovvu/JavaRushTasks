package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class VeryComplexClass {
    public  void methodThrowsClassCastException() {
        Collection collection = new ArrayList();
        Set collection1 = (Set) collection;
    }

    public void methodThrowsNullPointerException() {
        String s = null;
        s.length();

    }

    public static void main(String[] args) {
    }
}
