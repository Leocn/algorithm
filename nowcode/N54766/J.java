package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class J {
    static boolean[] vis;
    static int n,x;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x =sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt()-1;
        }
        vis = new boolean[n];
        dfs(0,0, new int[n]);

    }
    private static boolean dfs(int from ,int lose, int[] res){
        if(lose>=(n+1)/2){
            return  false;
        }
        if(from==n){
            StringBuilder sb = new StringBuilder();
            for(int r : res){
                sb.append(r+1).append(" ");
            }
            System.out.println(sb);
        }
        for (int i = 0; i < n; i++) {
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            int tem = lose;
            if(i<arr[from]+x){
                lose++;
            }
            res[from] = i;
            dfs(from+1, lose, res);
            vis[i] = false;
            lose = tem;
            res[from] = 0;
        }
        return true;
    }
}
