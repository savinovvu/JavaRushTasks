package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private LRUCache lruCache;
    private OriginalRetriever retriever;

    public CachingProxyRetriever(Storage storage) {
        lruCache = new LRUCache(100);
        retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object object = lruCache.find(id);
        if (object == null) {
            object = retriever.retrieve(id);
            lruCache.set(id, object);
        }
        return object;
    }
}
