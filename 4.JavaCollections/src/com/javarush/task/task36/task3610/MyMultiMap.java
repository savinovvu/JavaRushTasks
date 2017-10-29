package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (map.containsKey(key)) {
            List<V> valueList = map.get(key);
            V returnedValue = valueList.get(valueList.size() - 1);
            if (valueList.size() < repeatCount) {
                valueList.add(value);
            } else {
                valueList.remove(0);
                valueList.add(value);
            }
            return returnedValue;
        } else {
            List<V> valueList = new ArrayList<>();
            valueList.add(value);
            map.put(key, valueList);
            return null;
        }
    }

    @Override
    public V remove(Object key) {
        List<V> values = map.get(key);
        if (values == null)
            return null;
        V storeValue = values.get(0);
        values.remove(0);

        if (values.size() == 0)
            map.remove(key);

        return storeValue;
    }


    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        return map.values().stream().flatMap(v -> v.stream()).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        Set<V> collect = values().stream().collect(Collectors.toSet());
        return collect.contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}