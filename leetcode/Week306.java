package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week306 {
    public static void main(String[] args) {
        countSpecialNumbers(135);
    }



    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] ans = new int[n-2][n-2];
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < n-2; j++) {
                int max = 0;

                for (int k = i; k <=i+2 ; k++) {
                    for (int l = j; l <=j+2 ; l++) {
                        max = Math.max(max, grid[k][j]);
                    }
                }
                ans[i][j] = max;
            }
        }
        return ans;
    }

    public int edgeScore(int[] edges) {
        int max = 0;
        int ans = Integer.MAX_VALUE;
        int n = edges.length;
        int[] sc = new int[n];
        for (int i = 0; i < n; i++) {
            int loc = edges[i];
            sc[loc] += i;
            if(sc[loc]>max || (sc[loc]==max && loc<ans) ){
                ans = loc;
                max = sc[loc];
            }

        }
        return ans;
    }

    static int ans;
    static boolean[] vis;
    static int n = 0;
    static String s = "";
    public String  smallestNumber(String pattern) {
        ans = Integer.MAX_VALUE;
        n = pattern.length();
        vis = new boolean[10];
        s = pattern;
        for (int i = 1; i <=9; i++) {
            vis[i] =true;
            dfs(i,0);
        }
        return ans+"";
    }

    public  void dfs(int res, int index){
        if((res+"").length()==n+1){
            ans  = Math.min(ans, res);
            return;
        }
        if(s.charAt(index)=='I'){
            for(int i=res%10+1;i<=9;i++){
                if(vis[i]){
                    continue;
                }
                vis[i] = true;
                int tem = res;
                res = res*10+ i;
                dfs(res, index+1);
                res = tem;
                vis[i] = false;
            }
        }else{
            for(int i=1;i<=res%10-1;i++){
                if(vis[i]){
                    continue;
                }
                vis[i] = true;
                int tem = res;
                res = res*10+ i;
                dfs(res, index+1);
                res = tem;
                vis[i] = false;

            }
        }
    }

    static {


    }
    /**
     * 数位DP
     * */

    public static int countSpecialNumbers(int n) {
        if(n<10){
            return  n;
        }

        //存储每一位
        List<Integer> list = new ArrayList<>();
        while(n!=0){
            list.add(n%10);
            n = n/10;
        }
        int ans = 0, size = list.size();
        //计算 位数小于size的情况
        // 比如n为三位，计算两位数和一位数的情况,不包括0
        for (int i = 1, p=9; i < 10 && i < size; i++) {
            ans += p ;
            p *= (10-i);
        }
        //计算位数等于size的情况
        // pos 代表已经到了第几位，
        // s相当于dp

        for (int i = size-1, s=0; i >=0; i--) {
            //当前数字
            int cur = list.get(i);
            //计算第一位能取的数的个数 cnt
            int cnt = 0;
            for (int j = 0; j < cur; j++) {
                if(j==0 && i==size-1) continue;
                if( (s&(1<<j))==0) cnt++;
            }
            //除去第一位还能取的数的个数
            int a = 10-(size-i);
            //出去第一位后续的长度
            int b = size - (size - i);
            //计算C(a,b)
            int all =1;
            for (int j = a; j >a-b ; j--) {
                all *= j;
            }
            ans += all* cnt;
            //数字重复 后续不用计算
            if (((s >> cur) & 1) == 1) break;
            //
            s |= (1<<cur);
            //如果数字n满足条件， 则算上
            if(i==0) ans++;
        }

        return ans;

    }

}
