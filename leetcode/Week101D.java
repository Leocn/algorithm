package com.example.demo.leetcode;

import java.util.*;

public class Week101D {
    public static void main(String[] args) {

    }
    public int minNumber(int[] nums1, int[] nums2) {
        int min = 10000;
        for(int n1: nums1){
            for(int n2:nums2){
                if(n1==n2){
                    min = Math.min(min, n1);
                }else {
                    min = Math.min(n1*10 + n2, min);
                    min = Math.min(n2*10 + n1, min);
                }
            }
        }
        return min;
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int[] p = new int[26];
        for (int i = 0; i < 26; i++) {
            p[i] = i+1;
        }
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            p[c-'a'] = vals[i];
        }
        int loc = 0;
        int n = s.length();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            char c= s.charAt(i);
            sum += p[c-'a'];
            while (sum<0 && loc<=i){
                sum -= p[s.charAt(loc)-'a'];
                loc++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public long makeSubKSumEqual(int[] arr, int k) {
        int n = arr.length;
        long sum  = 0;
        int d = gcd(k, n);
        if(d==1){
            sum = cal(arr);
            return sum;
        }
        for (int i = 0; i < d; i++) {
            int [] a = new int[n/d];
            int loc = 0;
            for (int j = i; j < n; j+=d) {
                a[loc++] = arr[j];
            }
            sum += cal(a);
        }
        return sum;


    }
    private static long cal(int[] arr){
        Arrays.sort(arr);
        long s = 0, ans = 0;
        int n = arr.length;
        if((n&1)==1){
            for (int j : arr) {
                ans += Math.abs(j - arr[n/2]);
            }
        }else {
            long ans1 = 0,  ans2 = 0;
            for (int j : arr) {
                ans1 += Math.abs(j - arr[n/2]);
                ans2 += Math.abs(j - arr[n/2-1]);
            }
            ans = Math.min(ans1, ans2);
        }
        return ans;
    }
    public static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<Integer>[] adj = new ArrayList[n];
        for(int i = 0;i<adj.length;i++){
            adj[i] = new ArrayList<Integer>();
        }
        for(int[] e: edges){
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        out:for(int i = 0;i<n;i++){
            int[] cnt = new int[n];
            Arrays.fill(cnt, -1);
            Deque<int[]> stack = new ArrayDeque<>();
            stack.add(new int[]{i,-1});
            int now = 1;
            cnt[i] = 1;
            while (stack.size()>0){
                int size = stack.size();
                now++;
                while (size-->0){
                    int[] p = stack.poll();
                    List<Integer> list = adj[p[0]];
                    for(int next :list){
                        if(next==p[1]){
                            continue;
                        }
                        if(cnt[next]!=-1){
                            ans = Math.min(cnt[next] + cnt[p[0]] -1 , ans);
                            continue out;
                        }
                        cnt[next] = now;
                        stack.add(new int[]{next, p[0]});
                    }
                }

            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }


}
