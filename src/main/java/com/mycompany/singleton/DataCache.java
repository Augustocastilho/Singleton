/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.singleton;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Augusto
 */
public class DataCache {

    private static DataCache instance;
    private Map<String, String> cache;

    private DataCache() {
        cache = new HashMap<>();
    }

    public static synchronized DataCache getInstance() {
        if (instance == null) {
            instance = new DataCache();
        }
        return instance;
    }

    public void addToCache(String key, String value) {
        cache.put(key, value);
    }

    public String getFromCache(String key) {
        return cache.get(key);
    }

    public void clearCache() {
        cache.clear();
    }
    
    public static void main(String[] args) {
        DataCache cache1 = DataCache.getInstance();
        cache1.addToCache("key1", "value1");

        DataCache cache2 = DataCache.getInstance();

        System.out.println("Valor em cache2: " + cache2.getFromCache("key1"));

        cache1.clearCache();

        System.out.println("Valor em cache2 após limpeza do cache1: " + cache2.getFromCache("key1"));
    }
}
