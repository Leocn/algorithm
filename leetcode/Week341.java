package com.example.demo.leetcode;

import java.util.*;

public class Week341 {
    public static void main(String[] args) {

    }


    public int[] rowAndMaximumOnes(int[][] mat) {
        int cnt = 0, ans = 0;
        int n = mat.length, m = mat[0].length;
        for (int i = 0; i < n; i++) {
            int sum =0 ;
            for (int j = 0; j < m; j++) {
                if(mat[i][j] ==1){
                    sum++;
                }
            }
            if(sum>cnt){
                cnt = sum;
                ans = i;
            }
        }
        return new int[]{ans, cnt};
    }

    public int maxDivScore(int[] nums, int[] divisors) {
        int ans = divisors[0];
        int s = 0;
        int n = divisors.length;
        for (int i = 0; i < n ; i++) {
            int sum = 0;
            for(int num:nums){
                if(num%divisors[i]==0){
                    sum++;
                }
            }
            if(sum==s){
                if(divisors[i]<ans){
                    ans = divisors[i];
                }
            }else if(sum>s){
                s = sum;
                ans = divisors[i];
            }
        }
        return ans;
    }

    public int addMinimum(String word) {
        return 1;
    }

    List<Integer>[] arr;
    int n;
    int[] cnt;
    int tar;
    int[][] mem;
    int[] price;
    public int minimumTotalPrice(int _n, int[][] edges, int[] _price, int[][] trips) {
        n = _n;
        arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);

        }
        price = _price;
         cnt = new int[n];

        for(int[] trip: trips){
            cnt[trip[0]]++;
            tar = trip[1];
            dfs(trip[0], -1);

        }
        int[] ans = dp(0, -1);
        return Math.min(ans[0], ans[1]);

    }
    private boolean dfs(int now , int p){
        List<Integer> list = arr[now];
        for(int next : list){
            if(next == p){
                continue;
            }
            if(next== tar){
                cnt[next]++;
                return true;
            }
            if(dfs(next, now)){
                cnt[next]++;
            }
        }
        return false;
    }

    public int[] dp(int root, int p) {
        int[] ans = new int[] {cnt[root] * price[root], cnt[root] * (price[root] / 2)};
        for(int node : arr[root]) {
            if(node == p) {
                continue;
            }
            int[] sub = dp(node, root);
            ans = new int[] {ans[0] + Math.min(sub[0], sub[1]), ans[1] + sub[0]};
        }
        return ans;
    }
}
