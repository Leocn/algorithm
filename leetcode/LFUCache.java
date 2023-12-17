package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {
    int c;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> freq = new HashMap<>();
    public LFUCache(int capacity) {
        c = capacity;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            freq.merge(key,1,Integer::sum);
            return map.get(key);
        }else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            freq.merge(key,1,Integer::sum);

        }else {
            if(map.size()>=c){

            }else {
                freq.put(key,1);
            }
        }
        map.put(key, value);
    }
}
