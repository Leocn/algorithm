package com.example.demo.leetcode;

import java.util.*;

public class FoodRatings {
    
    Map<String ,Food> map;
    Map<String, PriorityQueue<Food>> m;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        map = new HashMap<>();
        m = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Food  f = new Food(ratings[i], foods[i],cuisines[i]);
            map.put(foods[i], f);
            m.computeIfAbsent(cuisines[i], v-> new PriorityQueue<>((o1, o2) -> {
                if (!Objects.equals(o1.rate, o2.rate)) {
                    return o2.rate - o1.rate;
                }
                return o1.name.compareTo(o2.name);
            })).add(f);
        }
    }

    public void changeRating(String food, int newRating) {
        Food f = map.get(food);
        PriorityQueue<Food> priorityQueue = m.get(f.cu);
        priorityQueue.remove(f);
        f.rate = newRating;
        priorityQueue.offer(f);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Food> priorityQueue = m.get(cuisine);
        return priorityQueue.peek().name;
    }
     static class Food  {
        private Integer rate;
        private String name;
        private String cu;
        public Food(Integer rate, String name,String cu) {
            this.rate = rate;
            this.name = name;
            this.cu = cu;
        }
    }
}
