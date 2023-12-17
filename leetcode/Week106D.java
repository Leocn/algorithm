package com.example.demo.leetcode;

import java.util.*;

public class Week106D {
    public static void main(String[] args) {

    }
    public boolean isFascinating(int n) {
        String s = n +"" + (2*n) + "" +(3*n);
        char[] cs = s.toCharArray();
        int[] cnt = new int[10];
        for(char c: cs){
            cnt[c-'0']++;
        }
        if(cnt[0]>0) return false;
        for (int i = 1; i <10 ; i++) {
            if(cnt[i]!=1) return false;
        }
        return true;
    }

    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <=n ; j++) {
                ans = Math.max(ans, cnt(s.substring(i,j)));
            }
        }
        return ans;

    }
    private int cnt(String str){
        int ans =0;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length-1; i++) {
            if(cs[i]==cs[i+1]){
                ans++;
            }
        }
        if(ans>1) return 0;
        return str.length();
    }

    public int sumDistance(int[] nums, String s, int d) {
        int mod = (int)1E9+7;
        long ans = 0;
        int n = nums.length;
        long[] dis = new long[n];
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='L'){
                dis[i] = (long)nums[i]- d;
            }else {
                dis[i] = (long)nums[i]+ d;
            }
        }
        Arrays.sort(dis);
        for (int i = 0; i < n; i++) {
            if(i>0){
                ans = (2*ans + ((dis[i]-dis[i-1])*i)%mod)%mod;
            }
        }
         return (int)ans;



    }
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        int  n = grid.length;
        int m = grid[0].length;
        Map<Integer,List<Integer>> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            int[] g = grid[j];
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                cnt += g[i]*(1<<i);
            }
            map.putIfAbsent(cnt,new ArrayList<>());
            map.get(cnt).add(j);
        }
        if(map.containsKey(0)){
            ans.add(map.get(0).get(0));
            return  ans ;
        }
        for (int i = 1; i < (1<<m); i++) {



            if(map.containsKey(i) ){
                out:for (int j = 1; j < (1<<m); j++) {

                    for (int k = 0; k < m; k++) {

                        if((j&(1<<k)) == (1<<k) && (i&(1<<k)) == (1<<k)){
                            continue out;
                        }
                    }
                    if(map.containsKey(j)){
                        ans.add(map.get(i).get(0));
                        ans.add(map.get(j).get(0));
                        return ans;
                    }


                }
            }
        }
        return ans;


    }




}
