package com.example.demo.atcoder.abc284;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E {
    static boolean[] vis;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List[] arr = new List[n+1];
        vis = new boolean[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<Integer>();
        }
        while (m-->0){
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr[from].add(to);
            arr[to].add(from);
        }
        dfs(arr,1);
        System.out.println(ans);

    }
    private static void dfs(List[] arr , int from){
        vis[from] = true;
        List<Integer> list = arr[from];
        if(ans>=1e6){
            return;
        }
        ans++;
        for(int next : list){
            if(!vis[next]){
                dfs(arr, next);
            }
        }
        vis[from] = false;

    }

}

