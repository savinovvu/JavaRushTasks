package com.javarush.task.task34.task3408;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)) {
            V v1 = clazz.getConstructor(key.getClass()).newInstance(key);
            cache.put(key, v1);
        }
        return cache.get(key);

    }

    public boolean put(V obj) {
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            Object key = method.invoke(obj);
            cache.put((K) key, obj);
            return true;
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException | IllegalArgumentException e) {
            return false;
        }
    }

    public int size() {
        return cache.size();
    }
}
