package com.example.demo.leetcode;

import java.util.*;

public class Week305 {
    public static void main(String[] args) {

    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int ans =0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(nums[j]-nums[i]==diff){
                    for (int k = j+1; k < n; k++) {
                        if(nums[k]-nums[j]==diff){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] visit = new boolean[n];
        for (int i = 0; i < restricted.length; i++) {
            visit[restricted[i]] = true;
        }
        Set<Integer> ans = new HashSet<>();
        ans.add(0);
        List[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList();
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < edges.length; i++) {
            int max = Math.max(edges[i][0],edges[i][1] );
            int min = Math.min(edges[i][0],edges[i][1] );
            lists[min].add(max);
            lists[max].add(min);
            if(min==0 && !visit[restricted[i]]){
                deque.add(max);
            }
        }
        while (deque.size()>0){
            int p = deque.poll();
            ans.add(p);
            List<Integer> l = lists[p];
            for(int i:l){
                if(!visit[restricted[i]]){
                    visit[restricted[i]] = true;
                    deque.add(i);
                }
            }
        }
        return ans.size();
    }

    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1; i<n; i++){
            dp[i+1] =  (dp[i-1] && (nums[i]== nums[i-1]))
                    || ((i>=2) && dp[i-2] && ( nums[i] == nums[i-1]) &&( nums[i-1] == nums[i-2]))
                    ||  ((i>=2) &&  dp[i-2] &&(  nums[i] == nums[i-1]+1) && (nums[i-1] == nums[i-2]+1));
        }
        return dp[n];
    }

    public int longestIdealString(String s, int k) {
        int ans =0;
        int n = s.length();
        int[] dp = new int[26];
        for(int i=0; i<n;i++){
            int in = s.charAt(i)-'a';

            for(int h= Math.max(in-k,0); h<=Math.min(25,in+k);h++){
                dp[in] = Math.max(dp[h], dp[in]);
            }
            dp[in]++;
            ans = Math.max(dp[in], ans);
        }
        return ans;
    }

}
