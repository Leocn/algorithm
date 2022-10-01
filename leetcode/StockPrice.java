package com.example.demo.leetcode;

import java.util.TreeMap;

public class StockPrice {

    TreeMap<Integer,Integer> map;
    TreeMap<Integer,Integer> mapPrice;
    int maxPrice, minPrice;


    public StockPrice() {
        this.map = new TreeMap<>();
        this.mapPrice = new TreeMap<>();
        this.maxPrice = 0;
        this.minPrice = Integer.MAX_VALUE;
    }

    public void update(int timestamp, int price) {
        if(map.containsKey(timestamp)){
            int lastPrice = map.get(timestamp);

            if( mapPrice.get(lastPrice) ==1){
                mapPrice.remove(lastPrice);
            }else if(mapPrice.get(lastPrice) >1){
                mapPrice.put(lastPrice, mapPrice.get(lastPrice)-1);
            }
        }
        mapPrice.put(price,mapPrice.get(price)==null? 1: mapPrice.get(price)+1);

        maxPrice = mapPrice.lastKey();
        minPrice = mapPrice.firstKey();

        map.put(timestamp, price);



    }

    public int current() {
        return map.get(map.lastKey());
    }

    public int maximum() {

        return maxPrice;

    }

    public int minimum() {
        return minPrice;
    }

    public static void main(String[] args) {
        StockPrice s = new StockPrice();
        s.update(1,10);
        System.out.println(s.current());

        s.update(2,5);
        System.out.println(s.current());
        System.out.println(s.maximum());
        s.update(1,3);
        System.out.println(s.maximum());
        System.out.println(s.minimum());
    }
}
