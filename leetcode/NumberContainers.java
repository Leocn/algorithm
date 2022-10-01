package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class NumberContainers {

    Map<Integer, TreeSet<Integer>> tree;

    Map<Integer, Integer> map;
    public NumberContainers() {
        map = new HashMap<>();
        tree = new HashMap<>();
    }

    public void change(int index, int number) {
        if(!map.containsKey(index)){
            map.put(index, number);
        }else{
            int num = map.get(index);
            tree.get(num).remove(index);
            map.put(index, number);
        }

        if(tree.containsKey(number)){
            tree.get(number).add(index);
        }else{
            TreeSet<Integer> set = new TreeSet<>();
            set.add(index);
            tree.put(number, set);
        }
    }

    public int find(int number) {
        if(tree.containsKey(number)){
            TreeSet<Integer> set = tree.get(number);
            if(set.size()==0){
                return -1;
            }
            return set.first();
        }else {
            return -1;
        }
    }
}
