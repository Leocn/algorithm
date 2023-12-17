package com.example.demo.atcoder.abc289;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class D {

    static int[] dp;
    static Set<Integer> set;
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        int m = sc.nextInt();
        set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            set.add(sc.nextInt());
        }
        int t = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if(!set.contains(arr[i])){
                pq.add(arr[i]);
            }
        }
        dp = new int[t+1];
        if(dfs(t)){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }



    }
    private static boolean dfs(int t){
        if(dp[t]==1){
            return true;
        }
        if(dp[t]==2){
            return false;
        }
        if(t==0){
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(set.contains(t-arr[i])){
                continue;
            }
            if(t<arr[i]){
                continue;
            }
            flag |= dfs(t-arr[i]);
        }
        if(flag){
            dp[t]=1;
        }else{
            dp[t]=2;
        }
        return flag;
    }
}
