package com.javarush.task.task33.task3308;

/*<shop>
    <goods>
        <names>S1</names>
        <names>S2</names>
    </goods>
    <count>12</count>
    <profit>123.4</profit>
    <secretData>String1</secretData>
    <secretData>String2</secretData>
    <secretData>String3</secretData>
    <secretData>String4</secretData>
    <secretData>String5</secretData>
</shop>*/

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Shop {
    private int count;
    private double profit;
    private String [] secretData;
    private Goods goods;

    public static class Goods {
        private List<String> names;
    }
}
