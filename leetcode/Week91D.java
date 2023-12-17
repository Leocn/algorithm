package com.example.demo.leetcode;

import java.util.*;

public class Week91D {
    public static void main(String[] args) {

    }
    public int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<Double> set = new HashSet<>();
        for(int i=0; i<n/2; i++){
            set.add(((double)nums[i] + nums[n-1-i]));
        }
        return set.size();
    }

    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int MOD = (int)(1e9+7);
        long[][] dp = new long[high+1][2];
        dp[0][0] = 1;
        for(int i= 1; i<= high; i++){
            if(i>=one) {
                dp[i][1] = (dp[i-one][1] + dp[i-one][0]) % MOD;
            }
            if(i>=zero){
                dp[i][0] = (dp[i-zero][1] + dp[i-zero][0]) % MOD;
            }
            if(i>=low){
                ans += (dp[i][0] + dp[i][1] )% MOD;
            }
        }
        return ans;

    }

    boolean[] vis;
    int target;
    List<Integer> route;
    int total = 0;

    int[] lee;
    int[] out;
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        route= new ArrayList<>();
        target = bob;
        int n = edges.length +1;
        vis = new boolean[n];
        lee = new int[n];
        Arrays.fill(lee, Integer.MIN_VALUE);
        out = new int[n];
        List[] arr = new ArrayList[n];
        for(int i=0; i<n ;i++){
            arr[i] = new ArrayList();
        }
        for(int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        vis[0] = true;
        List<Integer>  sss = new ArrayList<>();
        sss.add(0);
        dfs(arr, 0, sss);
        int sum  = 0;
        for(int i =0;i<route.size()/2; i++){
            sum += amount[route.get(i)];
            lee[route.get(i)] =  sum;
        }

        if(route.size()%2!=0){
            sum += amount[route.get(route.size()/2)]/2;
            lee[route.get(route.size()/2)] = sum;
        }
        for(int i =0;i<route.size()/2; i++){
            lee[route.get(route.size()-1-i)] = sum;

        }

        vis = new boolean[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(arr[i].size()!=1){
                continue;
            }
            if(i==0 ){
                continue;

            }
            if(i== target){
                ans = Math.max(ans, sum);
                continue;
            }

            total = 0;
            dff( out, i, amount[i], amount);
            ans = Math.max(total, ans);

        }
        return ans;


    }
    private void dfs(List[] arr, int from, List<Integer> list){
        List<Integer> s = arr[from];
        for(int t : s){
            if(vis[t]){
                continue;
            }
            vis[t] = true;
            out[t] = from;
            list.add(t);
            if(t== target){
                route.addAll(list);
            }
            dfs(arr, t, list);
            list.remove(list.size()-1);
        }
    }


    private void dff(int[] out, int from, int am,int[] amount) {
        int t = out[from];
        if (lee[t] != Integer.MIN_VALUE) {
            total = lee[t] + am;
            return;
        }
        am += amount[t];
        dff(out, t, am, amount);
        lee[t] = total- am + amount[t];
    }

    public String[] splitMessage(String message, int limit) {
        int right = (int) 1e4+1;
        int n = message.length();
        int mid = 0;
        for(int i =1; i<= right ;i++) {
            mid = i;
            int max = limit * mid;
            int min = limit * (mid - 1);
            int sum = 0;
            int len = (mid + "").length();
            int s = len;
            int start = 9;
            int d = 1;
            int t = 1;
            while (s-- > 1) {
                sum += start * t;
                start *= 10;
                d *= 10;
                t++;
            }
            sum += (mid - d + 1) * len;
            sum += 3 * mid;
            sum += mid * len;
            sum += n;
            if (sum <= max && sum > min) {
                System.out.println(mid);
                break;
            }
        }
        String[] ans = new String[mid];
        for(int i=1; i<=mid; i++){
            ans[i] = message.substring(0, limit-String.valueOf(i).length() - 3- String.valueOf(mid).length() ) + "<"+i+"/ " +mid +">";
            message = message.substring(limit);
        }
        return ans;
    }

}
