package com.example.demo.atcoder.abc303;

import java.util.Scanner;

public class B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[][] vis = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            for (int j = 0; j < n-1; j++) {
                vis[Integer.parseInt(arr[j]+"")][Integer.parseInt(arr[j+1]+"")] = true;
                vis[Integer.parseInt(arr[j+1]+"")][Integer.parseInt(arr[j]+"")] = true;
            }
        }
        int ans = n*(n-1);
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(i==j){
                    continue;
                }
                if(vis[i][j]){
                    ans--;
                }
            }
        }
        System.out.println(ans/2);
    }
}
