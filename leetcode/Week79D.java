package com.example.demo.leetcode;

import java.util.*;

public class Week79D{
    public boolean digitCount(String num) {
        int[] record = new int[10];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<num.length(); i++){
            int d = num.charAt(i)-'0';
            record[i] = d;
            map.put(d,map.getOrDefault(d,0)+1);
        }
        for(int i=0;i<record.length; i++){
            if(record[i]!=0 && record[i] !=map.getOrDefault(i,0)){
                return false;
            }
        }
        return true;
    }


    public String largestWordCount(String[] messages, String[] senders) {
        Map<String , Integer> map = new TreeMap<>();
        for(int i=0;i<senders.length; i++){
            String sender = senders[i];
            int msg = map.getOrDefault(sender, 0);
            String[] m = messages[i].split(" ");


            map.put(sender, msg+m.length);
        }
        int max = 0;
        String ans = "";
        for(Map.Entry<String, Integer> s: map.entrySet()){
            if(s.getValue()>=max){
                ans = s.getKey();
                max = s.getValue();
            }
        }
        return ans;

    }


    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        int[] sum = new int[n];
        for(int[] road: roads){
            sum[road[0]] ++;
            sum[road[1]] ++;
        }
        Arrays.sort(sum);
        for(int i=0; i<sum.length;i++){
            ans += (long) (i + 1) * sum[i];
        }
        return ans;
    }
}
