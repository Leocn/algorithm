package com.example.demo.leetcode;

import java.util.*;

public class Week65D {

    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(Arrays.toString(maximumBeauty(new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}}, new int[]{6, 2, 3, 4, 5, 1})));
    }
    public static boolean checkAlmostEquivalent(String word1, String word2) {

         Map<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            if(map1.containsKey(word1.charAt(i))){
                map1.put(word1.charAt(i),map1.get(word1.charAt(i))+1);
            }else{
                map1.put(word1.charAt(i), 1);
            }
        }

        for (int i = 0; i < word2.length(); i++) {
            if(map2.containsKey(word2.charAt(i))){
                map2.put(word2.charAt(i),map2.get(word2.charAt(i))+1);
            }else{
                map2.put(word2.charAt(i), 1);
            }
        }

        for (Character c : map1.keySet() ) {
            if(map1.get(c) - map2.getOrDefault(c,0) >  3){
                return false;
            }
        }

        for (Character c : map2.keySet() ) {
            if(map2.get(c) - map1.getOrDefault(c,0) >  3){
                return false;
            }
        }
        return true;
    }



    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] s = queries.clone();
        Arrays.sort(queries);
        TreeMap<Integer,Integer> map = new TreeMap<>();
//        TreeMap<Integer,Integer> map2 = new TreeMap<>();

        for (int[] ints : items) {
            if(map.getOrDefault(ints[0],0)<ints[1]){
                map.put(ints[0], ints[1]);
            }
        }

//        for (int[] item : items) {
//            map2.put(item[1], item[0]);
//        }

        Map<Integer,Integer> res = new HashMap<>();
        int max = 0;
        for (int i = 0; i < queries.length; i++) {
            while (map.size()>0 && map.firstKey()<= queries[i]){
                max = Math.max(map.get(map.firstKey()),max);
                map.pollFirstEntry();
            }
            res.put(queries[i],max);
        }
        int[] res1 = new int[queries.length];
        for (int i = 0; i < s.length; i++) {
            res1[i] = res.get(s[i]);
        }

        return res1;


    }


    private class  Robot {

        int[] cur = new int[2];
        int width = 0;
        int height = 0;
        String dir = "East";
        int sum = 0;
        int steps = 0;
        int times = 0;
        public Robot(int width, int height) {
            this.width = width;
            this.height = height;
            sum = 2*(width + height) - 4;
        }

        public void move(int num) {
            steps += num;
            steps %= sum;
            times ++;
            if(0<steps && steps <= width-1){
                cur[1] = 0;
                cur[0] = steps;
                dir = "East";
            }else if(steps>width-1 && steps<=width+height-2 ){
                cur[0] = width-1;
                cur[1] = steps - width +1;
                dir = "North";
            }else if(steps>width+height-2 && steps<= 2*width+height-3 ){
                cur[1] = height -1;
                cur[0] = width - (steps - (width+height-2));
                dir = "West";
            }else if(steps<2*(width+height)-4|| steps==0){
                cur[1] = height - (steps- (2*width+height-3));
                cur[0] = 0;
                if(steps == 0){
                    cur[1] = 0;
                }
                dir = "South";
            }


        }


        public int[] getPos() {
            return cur;
        }

        public String getDir() {
            return dir;
        }
    }

    /**
     * TODO
     * */
//    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
//        for (int i = 0; i < tasks.length; i++) {
//
//        }
//    }




}
