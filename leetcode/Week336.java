package com.example.demo.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Week336 {
    public static void main(String[] args) {

    }

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for (int i = left; i <=right ; i++) {
            char c  = words[i].charAt(0);
            char nc = words[i].charAt(words[i].length()-1);
            if(set.contains(c) && set.contains(nc)){
                ans++;
            }
        }
        return ans;
    }

    public int maxScore(int[] nums) {

        int n = nums.length;
        nums = IntStream.of(nums).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        int ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if(sum>0){
                ans++;
            }
        }
        return ans;
    }

    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        map.put(0, 1);
        long ans = 0;
        int now = 0;
        for (int i = 0; i < n; i++) {
            int c = nums[i];
            int loc = 0;
            while (c>0){
                if(c%2==1){
                    now ^=(1<<loc);
                }

                loc++;
                c/=2;
            }
            ans+= map.getOrDefault(now, 0);
            map.put(now,map.getOrDefault(now, 0)+1);
        }
        return ans;
    }

    public int findMinimumTime(int[][] tasks) {
        Arrays.sort(tasks, (a,b)->{
            if(a[1]== b[1] ){
                return a[0] - b[0];
            }else {
                return a[1] - b[1];
            }
        });
        int n = tasks.length;
        int b[] = new int[2001];
        int  sum = 0;
        for (int i = 0; i < n ; i++) {
            int x = tasks[i][0], y = tasks[i][1], cnt = tasks[i][2];
            sum+= cnt;
            for (int j = x; j <= y && cnt>0; j++) {
                if(b[j]==1){
                    cnt--;
                    sum--;
                }
            }
            while (cnt>0 && y>=x){
                if(b[y]==0){
                    b[y] = 1;
                    cnt--;
                }
                y--;
            }
        }
        return sum;
    }
}
