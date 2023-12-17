package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Week333 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int[] num: nums1){
            map.putIfAbsent(num[0],0);

            map.put(num[0],map.get(num[0])+num[1]);
        }
        for(int[] num: nums2){
            map.putIfAbsent(num[0],0);

            map.put(num[0],map.get(num[0])+num[1]);
        }
        int n = map.size();
        int[][] ans = new int[n][2];
        int loc = 0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            ans[loc][0] = m.getKey();
            ans[loc++][1] = m.getValue();
        }
        return ans;
    }

    int ans =1000000;
    public int minOperations(int n) {
        int cnt = Integer.bitCount(n);
        dfs(n, 0,0);
        return ans;
    }
    private void dfs(int n, int cnt, int loc){
        if(n==0){
            ans = Math.min(cnt, ans);
            return;
        }
        int l = (Integer.toBinaryString(n)).length();

        while (loc <l &&(Integer.toBinaryString(n)).charAt(l-1-loc)=='0'){
            loc++;
        }
        if(loc>=l){
            return;
        }
        dfs(n-(1<<loc), cnt+1, loc+1);
        dfs(n+(1<<loc), cnt+1, loc+1);
    }

    static  int MOD = (int)1e9 + 7;


    public int squareFreeSubsets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for(int n:nums){
            if(n==1){
                cnt++;
                continue;
            }
            if(n==4|| n==9|| n==16||n==25 || n%4==0 || n%9==0){
                continue;
            }
            map.put(n, map.getOrDefault(n,0)+1);
        }
        int n = map.size();
        int[][] arr = new int[n][2];
        int loc = 0;
        for(Map.Entry<Integer, Integer> m:map.entrySet()){
            arr[loc][0] = m.getKey();
            arr[loc++][1] = m.getValue();
        }

        int max = 1<<(n);
        int c = 1;
        long ans = 0;

        out:while (c<max){
            int tem = c;
            c++;
            int w = 0;
            long all = 1;
            long sum = 1;
            while (tem>0){
                if((tem &1)==1){
                    if(gcd(arr[w][0],all)!=1){
                        continue out;
                    }
                    all = all*arr[w][0];
                    sum = sum* (arr[w][1])%MOD;
                }
                w++;
                tem = tem >> 1;
            }
            ans = (ans+sum)%MOD;
        }
        ans++;
        for(int i=0;i<cnt;i++){
            ans = ans*2%MOD;
        }
        ans--;

        return (int)(ans%MOD);


    }
    public static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length, loc = 0;
        char[] cs = new char[n];

        for (char s = 'a'; s <='z' ; s++) {
            while (loc<n && cs[loc]>0){
                loc++;
            }
            if(loc==n) break;
            for (int j = loc; j < n; ++j)
                if (lcp[loc][j] > 0) cs[j] = s;
            
        }
        for (int i = 0; i < n; i++) {
            if(cs[i]==' ')return "";
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if(cs[i]==cs[j]){
                    if(i==n-1|| j==n-1){
                        if(lcp[i][j]!=1){
                            return "";
                        }
                    }else {
                        if(lcp[i][j]+1 != lcp[i+1][j+1]){
                            return "";
                        }
                    }
                }else{
                    if(lcp[i][j]!=0 || lcp[j][i]!=0){
                        return "";
                    }
                }
            }
        }

        return new String(cs);
    }


}
