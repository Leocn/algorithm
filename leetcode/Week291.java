package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Week291 {
    public String removeDigit(String number, char digit) {
        int n = number.length();
        String ans = "";
        for (int i = 0; i <n ; i++) {
            if(number.charAt(i)==digit){
                String  s= number.substring(0, i) + number.substring(i+1,n);
                if(s.compareTo(ans)>0){
                    ans = s;
                }
            }
        }
        return ans;
    }

    public int minimumCardPickup(int[] cards) {
        int ans = Integer.MAX_VALUE;
        int n = cards.length;
        int left = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cnt = map.getOrDefault(cards[i],0);
            cnt++;
            map.put(cards[i], cnt);
            if(cnt>=2){
                while (left<i&& map.get(cards[i])>=2){
                    map.put(cards[left],map.get(cards[left++])-1);
                    ans = Math.min(i-left+1, ans);
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans+1;
    }

    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i <n ; i++) {
            sum[i+1] = sum[i];
            if(nums[i]%p==0){
                sum[i+1]++;
            }
        }
        Set<String> set= new HashSet<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            String s ="";
            for (int j = i; j >=0; j--) {
                s = nums[j]+ " " +s;
                if(sum[i+1]-sum[j]<=k && !set.contains(s)){
                    set.add(s);
                    ans++;
                }
            }
        }
        return ans;
    }


    public long appealSum(String s) {
        long ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        int n = s.length();
        long[] dp = new long[n+1];
        for (int i = 0; i < n; i++) {
            if(!map.containsKey(cs[i])){
                dp[i+1] = dp[i] + (i+1);
            }else{
                dp[i+1] = dp[i] + (i-map.get(cs[i]));
            }
            ans += dp[i+1];
            map.put(cs[i], i);
        }
        return  ans;
    }
}
