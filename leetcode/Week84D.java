package com.example.demo.leetcode;

import java.util.*;

public class Week84D {
    public static void main(String[] args) {
        //taskSchedulerII(new int[]{4,1,3,3},);

        minimumReplacement (new int[]{12,9,7,6,17,19,21});
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int[] item:items1){
            map.put(item[0],map.getOrDefault(item[0],0)+item[1]);
        }

        for(int[] item:items2){
            map.put(item[0],map.getOrDefault(item[0],0)+item[1]);
        }
        List<List<Integer>> ans =new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            List<Integer> list = new ArrayList<>();
            list.add(entry.getKey());
            list.add(entry.getValue());
            ans.add(list);
        }
        return ans;

    }


    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(nums[i]-i)){
                ans += map.get(nums[i]);
                map.put(nums[i]-i,map.get(nums[i])+1 );
            }else{
                map.put(nums[i]-i, 1);
            }
        }
        return (long) n *(n+1)/2 - ans;

    }


    public static long taskSchedulerII(int[] tasks, int space) {
        long now = 1;
        Map<Integer,Long> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            if(map.containsKey(tasks[i])){
                if(map.get(tasks[i])+space>now){
                    now = map.get(tasks[i])+space+1;
                }else{
                    now++;
                }
            }else{
                now++;
            }
            map.put(tasks[i],now);
        }
        return now-1;
    }

    public static long minimumReplacement(int[] nums) {
        int n = nums.length;
        long ans =0;
        for(int i= n-2; i>=0; i--){
            if(nums[i]<= nums[i+1]){
            }else{

                int count = nums[i]/nums[i+1];
                int l = nums[i]%nums[i+1];
                if(l>0){
                    if(count>=1){
                        int j = (l+nums[i+1])/2;
                        nums[i] =j;

                    }
                    count++;
                }else{
                    nums[i] = nums[i+1];
                }
                ans += (count-1);

            }
        }
        System.out.println(ans);
        return ans;

    }
}
