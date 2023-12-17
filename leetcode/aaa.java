package com.example.demo.leetcode;

import org.assertj.core.data.MapEntry;

import java.util.*;

public class aaa {
    public static void main(String[] args) {

    }
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(n%(i+1)==0){
                ans += nums[i]*nums[i];
            }
        }
        return ans;
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int loc = 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            while (nums[i]-nums[loc]>2*k){
                loc++;
            }
            ans = Math.max(ans, i-loc+1 );
        }
        return ans;
    }
    public int minimumIndex(List<Integer> nums) {
        int b = 0;
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
            int cnt = map.get(num);
            if(cnt*2>n){
                b = num;
            }
        }
        int cnt = map.get(b);
        int now = 0;
        for (int i = 0; i < n-1; i++) {
            now += nums.get(i)==b?1:0;
            if(now*2>(i+1) && (cnt-now)*2>(n-i-1)){
                return i;
            }
        }
        return -1;

    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> set  = new HashSet<>(forbidden);
        int n = word.length();

        int ans = 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);
        out:for (int i = 0; i < n; i++) {
            for (int j = i; j>=Math.max(0,i-10); j--) {
                if(set.contains(word.substring(j,i+1))){
                    dp[i+1] = i-j;
                    ans = Math.max(ans, dp[i+1]);
                    System.out.println(i + " " + dp[i+1]);

                    continue out;
                }else {
                    dp[i+1] = Math.min(dp[j]+i-j,dp[i+1]);
                }

            }
            dp[i+1] = dp[Math.max(0,i-10)] + (i+1-Math.max(0,i-10));
            System.out.println("fffff" + i + " " +  dp[i+1]);
            ans = Math.max(ans, dp[i+1]);
        }
        return ans;
    }

    public int minSwapsCouples(int[] row) {
        int n = row.length/2;
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < 2*n; i+=2) {
            int a = row[i]/2, b = row[i+1]/2;
            g[a].add(b);
            g[b].add(a);
        }
        boolean[] vis = new boolean[n];
        int ans = n;
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                ans--;
                vis[i] = true;
                Deque<Integer> dq = new ArrayDeque<>();
                dq.add(i);
                while (dq.size()>0){
                    int p = dq.poll();
                    for(int w: g[p]){
                        if(!vis[w]){
                            dq.add(w);
                            vis[w] = true;
                        }
                    }


                }

            }
        }
        return ans;
    }



}
