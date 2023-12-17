package com.example.demo.leetcode;

import com.example.demo.nowcode.I;

import java.util.*;

public class Week105D {
    public static void main(String[] args) {

    }

    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int sum = prices[0]+prices[1];
        if(sum>money){
            return money;
        }
        return money-sum;
    }

    public int minExtraChar(String s, String[] dictionary) {

        int n = s.length();
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1000000);
        dp[0] = 0;
        for (int i = 0; i <n ; i++) {
            for(String d: dictionary){
                if(n-i<d.length()){
                    continue;
                }
                int dL = d.length();
                if(d.equals(s.substring(i,i+dL))){
                    dp[i+dL] = Math.min(dp[i], dp[i+dL]);
                }
            }

                dp[i+1] = Math.min(dp[i]+1, dp[i+1]);

        }
        return dp[n];
    }

    public long maxStrength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        long ans = 1;
        int cnt = 0;
        for (int i = 0; i < n-1; i++) {
            if(nums[i]<0 && nums[i+1]<0){
                ans *= nums[i];
                ans *= nums[i+1];
                i++;
                cnt +=2;
            }
            else  if(nums[i]>0){
                ans*=nums[i];
                cnt++;
            }
        }
        if(nums[n-1]>0){
            cnt++;
            ans*=nums[n-1];
        }
        if(cnt>0){
            return ans;
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0){
                return 0;
            }
        }
        return ans;
    }
    static final List<Integer> PRIMES = getPrimesLe(100001);
    static Map<Integer,List<Integer>> map2 = new HashMap<>();
    static {
        for (int i = 1; i <100001 ; i++) {
            List<Integer> list = getPrimeFactors(i);
            map2.put(i, list);
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        ArrayList<Integer>[] arr = new ArrayList[100001];
        for (int i = 0; i < 100001; i++) {
            arr[i] = new ArrayList<>();
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map2.getOrDefault(nums[i],new ArrayList<>());
            for(int l: list){
                arr[l].add(i);
            }
            map.put(i, list);

        }
        boolean[]  vis =  new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        vis[0] = true;
        boolean[] vis2= new boolean[100001];
        while (dq.size()>0){
            int p = dq.poll();
            vis[p] = true;
            List<Integer> nnnn = map.getOrDefault(p, new ArrayList<>());
            for(int next: nnnn){
                if(vis2[next]){
                    continue;
                }
                vis2[next] =true;
                for(int nn: arr[next]){
                    if(vis[nn]){
                        continue;
                    }
                    vis[nn] = true;
                    dq.add(nn);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                return false;
            }
        }
        return true;

    }
    /**
     ** 获取质数因子
     * */
    public static List<Integer> getPrimeFactors(int k) {
        List<Integer> ans = new ArrayList<>();
        int r = (int) Math.sqrt(k) + 1;
        for (int p : PRIMES) {
            if (p > r) {
                break;
            }
            int exp = 0;
            while (k % p == 0) {
                exp++;
                k /= p;
            }
            if (exp > 0) {
                ans.add(p);
            }
        }
        if (k != 1) {
            ans.add(k);
        }
        return ans;
    }
    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }

}
