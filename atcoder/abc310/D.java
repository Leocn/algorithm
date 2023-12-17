package com.example.demo.atcoder.abc310;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    static  int ans;
    static int n;
    static int m;
    static int[] cur;
    static boolean[][] vis;
    static int t;
    static int[][] mem;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        m = sc.nextInt();
        vis = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt()-1;
            int b = sc.nextInt()-1;
            vis[a][b] = true;
            vis[b][a] = true;
        }
        cur = new int[t];

        dfs(0,0);
        System.out.println(ans);

    }
    private static void dfs(int index, int sum){

        if(index==n && sum== t){
            ans++;
        }
        if(index==n){
            return ;
        }

        out:for (int i = 0; i < t; i++) {
            boolean[] v = vis[index];
            for (int j = 0; j < v.length; j++) {
                if(v[j] && ((1<<j) &cur[i]) == (1<<j)){
                    continue out;
                }
            }
            cur[i] |= (1<<index);
             dfs(index+1, sum+ (cur[i]== (1<<index)?1:0));
            cur[i] ^= (1<<index);
            if(cur[i]==0){
                break;
            }
        }
    }
}
