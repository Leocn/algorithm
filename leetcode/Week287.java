package com.example.demo.leetcode;

import java.util.*;

public class Week287 {
    public int convertTime(String current, String correct) {
        String[] a1 = current.split(":");
        String[] a2 = correct.split(":");
        int diff =  (Integer.parseInt(a2[0]) - Integer.parseInt(a1[0]))*60 -  (Integer.parseInt(a2[1]) - Integer.parseInt(a1[1]));
        int ans = 0;
        while (diff>=60){
            ans += diff/60;
            diff %= 60;
        }
        while (diff>=15){
            ans += diff/15;
            diff %= 15;
        }
        while (diff>=5){
            ans += diff/5;
            diff %= 5;
        }
        while (diff>=1){
            ans += diff/1;
            diff %= 1;
        }
        return  ans;
    }

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] arr = new int[100001];
        boolean[] vis = new boolean[100001];
        for (int[] m: matches) {
            vis[m[0]] = true;
            arr[m[1]]++;
        }
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < 100001; i++) {
            if(arr[i]==1){
                l2.add(i);
            }
            if(arr[i]==0 && vis[i]){
                l1.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(l1);
        ans.add(l2);
        return ans;
    }

    public int maximumCandies(int[] candies, long k) {
        long left = 0, right = (long)1e7+1;
        while (left<right){
            long mid = (left+right)>>1;
            long cnt = 0;
            if(mid==0) return 0;
            for(int c: candies){
                cnt += c/mid;
            }

            if(cnt<k){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return (int)left-1;
    }

    class Encrypter {

        Map<Character, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for(int i=0; i<keys.length; i++){
                map.put(keys[i], values[i]);
                // if(!map2.containsKey(values[i])){
                //     Set<String> set= new HashSet<>();
                //     set.add(keys[i]+"");
                //     map2.put(values[i], set);
                // }else{
                //     map2.get(values[i]).add(keys[i]+"");
                // }
            }

            out:for(String d: dictionary){
                StringBuilder  sb = new StringBuilder();
                for(char c: d.toCharArray()){
                    if(!map.containsKey(c)){
                        continue out;
                    }
                    sb.append(map.get(c));
                }
                String s = sb.toString();
                map2.put(s, map2.getOrDefault(s,0)+1);
            }





        }

        public String encrypt(String word1) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<word1.length(); i++){
                char c = word1.charAt(i);
                sb.append(map.get(c));
            }
            return  sb.toString();
        }

        public int decrypt(String word2) {
            return map2.getOrDefault(word2, 0);
        }
    }


}
