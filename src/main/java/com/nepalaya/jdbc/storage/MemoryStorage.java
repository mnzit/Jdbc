package com.nepalaya.jdbc.storage;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class MemoryStorage {
    @Getter
    private Map<Object, Object> storage = new HashMap<>();
    private static volatile MemoryStorage instance;

    private MemoryStorage() {
    }

    // Eager loading
    static {
        if (instance == null) {
            synchronized (MemoryStorage.class) {
                if (instance == null) {
                    instance = new MemoryStorage();
                }
            }
        }
    }

    public static MemoryStorage getInstance() {
        return instance;
    }

    // Lazy loading
//    public static MemoryStorage getInstance(){
//        if(instance == null) {
//            synchronized (MemoryStorage.class){
//                if(instance == null){
//                    instance = new MemoryStorage();
//                }
//            }
//        }
//        return instance;
//    }

    public void addToStorage(Object key, Object value) {
        storage.put(key, value);
    }

    public Boolean isAvailable(Object key) {
        return storage.containsKey(key);
    }
}
