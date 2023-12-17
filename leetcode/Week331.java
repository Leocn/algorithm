package com.example.demo.leetcode;

import com.example.demo.nowcode.I;

import java.util.*;

public class Week331 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int g:gifts){
            priorityQueue.add(g);
        }
        while (k-->0){
            int p = priorityQueue.poll();
            priorityQueue.add((int)Math.sqrt(p));
        }
        long sum = 0;
        while (priorityQueue.size()>0){
            sum+=priorityQueue.poll();
        }
        return sum;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int q = queries.length;
        int[] ans = new int[q];
        int n = words.length;
        int[] cnt = new int[n+1];
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        for (int i = 0; i < n; i++) {
            String word = words[i];
            if(set.contains(word.charAt(0)) && set.contains(word.charAt(word.length()-1))){
                cnt[i+1] = cnt[i]+1;
            }else{
                cnt[i+1] = cnt[i];
            }
        }
        for (int i = 0; i < q; i++) {
            int[] qu = queries[i];
            ans[i] = cnt[qu[1]] - cnt[qu[0]];
        }
        return ans;
    }


//    public int minCapability(int[] nums, int k) {
////        int n = nums.length;
////        int[][] dp = new int[n][k];
////        dp[]
////
////        return ans;
//
//
//
//
//    }


    public long minCost(int[] basket1, int[] basket2) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int b: basket1){
            map.putIfAbsent(b, 0);
            map.put(b, map.get(b)+1);

        }
        for(int b: basket2){
            map.putIfAbsent(b, 0);
            map.put(b, map.get(b)-1);
        }
        List<Integer> list = new ArrayList<>();
        int min = (int)1e9;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()%2!=0){
                return -1;
            }
            int cnt = Math.abs(entry.getValue());
            min = Math.min(min ,entry.getKey());
            for(int i=0; i<cnt; i++){
                list.add(entry.getKey());
            }
        }
        long ans = 0;
        Collections.sort(list);
        for(int i=0; i<list.size()/2; i++){
            ans += Math.min(list.get(i), 2*min);
        }
        return ans;


    }

}
