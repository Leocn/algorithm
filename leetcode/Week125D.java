package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Week125D {
    public static void main(String[] args) {

    }
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int num: nums){
            pq.add((long) num);
        }
        int ans = 0;
        while (pq.size()>1){
            long p1 = pq.poll();
            long p2 = pq.poll();
            if(p1>=k){
                return ans;
            }
            pq.add(2*p1 + p2);
            ans++;
        }
        return 0;
    }
    ArrayList<int[]>[] g;
    int signalSpeed;
    public int[] countPairsOfConnectableServers(int[][] edges, int _signalSpeed) {
        int n = edges.length+1;
        g = new ArrayList[n];
        signalSpeed = _signalSpeed;
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            g[e[0]].add(new int[]{e[1],e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for(int[] w: g[i]){
                int s = dfs(i, w[0], w[1]);
                ans[i] += sum *s;
                sum += s;

            }

        }

        return ans;
    }
    private int dfs(int p, int c, int s ){
        int res = 0;
        if(s%signalSpeed == 0){
            res++;
        }
        for(int[] w: g[c]){
            if(w[0] != p){
                res += dfs(c,w[0],s+w[1]);
            }
        }
        return res;
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long ans = 0;
        List<Integer> list = new ArrayList<>();
        for(int num: nums){
            ans += num;
            list.add(num ^ k - num);
        }
        list.sort(Integer::compareTo);
        for (int i = nums.length-1; i >=1 ; i-=2) {
            long s = list.get(i) + list.get(i-1);
            if(s>0){
                ans += s;
            }else {
                break;
            }
        }
        return ans;
    }
}

