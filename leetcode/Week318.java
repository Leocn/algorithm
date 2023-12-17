package com.example.demo.leetcode;

import java.util.*;

public class Week318 {
    public static void main(String[] args) {

    }

    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                nums[i] *=2;
                nums[i+1] =0;
            }
        }
        int[] ans = new int[n];
        int loc = 0;
        for(int i=0; i<n;i++){
            if(nums[i]!=0){
                ans[loc++] = nums[i];
            }
        }
        return  ans;
    }

    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        int loc = 0;
        long sum = 0;
        long ans = 0;
        for(int i= 0; i<n; i++){
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(i-loc+1==k){

            }else if(i-loc+1 == k+1){
                sum -= nums[loc];
                int s = map.get(nums[loc]);
                if(s==1){
                    map.remove(nums[loc]);
                }else{
                    map.put(nums[loc], s-1);
                }
                loc++;
            }

            if(map.size()==k){
                ans = Math.max(ans, sum);
            }
        }
        return  ans;



    }


    public long totalCost(int[] costs, int k, int candidates) {
        long ans = 0;
        int n = costs.length;
        int loc = candidates;
        int loc2 = n-1-candidates;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        if(loc<=loc2){
            for(int i = 0; i<loc; i++){
                pq.add(costs[i]);
            }
            for(int i= n-candidates; i<n; i++){
                pq2.add(costs[i]);
            }

            while (loc<=loc2 && k!=0){
                if(pq.peek()<= pq2.peek()){
                    ans += pq.poll();

                    pq.add(costs[loc++]);
                }else{
                    ans += pq2.poll();
                    pq2.add(costs[loc2--]);
                }
                k--;
            }
        }else {
            for(int i = 0; i<loc; i++){
                pq.add(costs[i]);
            }
            for(int i= loc; i<n; i++){
                pq2.add(costs[i]);
            }
        }


        while (k-->0){
            if(pq.size()>0 && pq2.size()>0){
                if(pq.peek()<= pq2.peek()){
                    ans += pq.poll();
                }else{
                    ans += pq2.poll();
                }
            }else if(pq.size()>0){
                ans += pq.poll();
            }else if(pq2.size()>0){
                ans += pq2.poll();
            }

        }

        return ans;

    }


    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size(), m = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        long[][] dp = new long[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0x3f3f3f3f3f3f3f3fL;
        }
        for (int i = 0;i < m;++i) {
             int pos = factory[i][0];
             int lim = factory[i][1];
            dp[i + 1][0] = 0;
            for (int j = 0;j < n;++j) {
                 long sum = 0;
                 long min_cost = dp[i][j + 1];
                for (int k = j;0 <= k && j - lim < k;--k)
                    min_cost = Math.min(min_cost, (sum += Math.abs(robot.get(k) - pos)) + dp[i][k]);
                dp[i + 1][j + 1] = min_cost;
            }
        }
        return dp[m][n];

    }
}
