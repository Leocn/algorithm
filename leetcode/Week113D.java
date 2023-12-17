package com.example.demo.leetcode;

import java.util.*;

public class Week113D {

    public int minimumRightShifts(List<Integer> nums) {
        int n = nums.size();
        if(n==1){
            return 0;
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        if(check(arr)){
            return 0;
        }
        for (int i = 0; i < n; i++) {
            int t = arr[n-1];
            for (int j = n-2; j >=0; j--) {
                arr[j+1] = arr[j] ;
            }
            arr[0] = t;
            if(check(arr)){
                return i+1;
            }
        }
        return -1;

    }
    private  boolean check(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]<arr[i]){
                return false;
            }
        }
        return true;
    }


    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.merge(nums.get(i),1,Integer::sum);
            if(map.get(nums.get(i))>max){
                max = map.get(nums.get(i));
            }
        }
        if(max>=n-max){
            return max-(n-max);
        }
        return n%2;
    }

    public int countPairs(List<List<Integer>> coordinates, int k) {
        Map<Long, Integer> map = new HashMap<>();
        int ans = 0;
        for(List<Integer> l: coordinates){
            long a = l.get(0), b = l.get(1);
            for (int i = 0; i <=k; i++) {
                long c = a^i, d= b^(k-i);
                ans += map.getOrDefault((c<<21)+d,0);
            }
            map.merge((a<<21)+b,1,Integer::sum);
        }
        return ans;
    }

    ArrayList<int[]>[] g;
    int[] ans;
    public int[] minEdgeReversals(int n, int[][] edges) {
        ans = new int[n];
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for(int[] e: edges){
            g[e[0]].add(new int[]{e[1],1});
            g[e[1]].add(new int[]{e[1],-1});
        }
        ans[0] = dfs(-1,0);
        dfs1(-1,0);

        return ans;
    }
    private int dfs(int p, int now){
        int res = 0;

        for(int[] l: g[now]){
            if(p!=l[0]){
                if(l[1]<0) res++;
                res += dfs(now, l[0]);
            }
        }
        return res;
    }
    private void dfs1(int p, int now ){

        if(now!=0){
            for(int[] l: g[now]){
                if(l[0]==p){
                    if(l[1]>0){
                        ans[now] = ans[p]+1;
                    }else {
                        ans[now] = ans[p]-1;
                    }
                    break;
                }
            }

        }
        for(int[] l: g[now]){
            if(p!=l[0]){
                dfs1(now, l[0]) ;
            }
        }
    }
}
