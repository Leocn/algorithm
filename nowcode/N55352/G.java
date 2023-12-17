package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class G {
    static int ans = 0;
    static  int n = 0;
    static  int t = 0;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        t = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dfs(0, 0, 0);
        System.out.println(ans);
    }
    private static void dfs(int loc, int sum, int cnt ){
        if(cnt>t){
            return;
        }
        ans = Math.max(ans, sum);
        if(loc>=n){
            return;
        }
        dfs(loc+1, sum+ arr[loc][0], cnt+arr[loc][1]  );
        dfs(loc+1, sum, cnt  );
    }
}
