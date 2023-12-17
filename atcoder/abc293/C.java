package com.example.demo.atcoder.abc293;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    static int ans = 0;
    static int m,n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        Set<Integer> set = new HashSet<>();
        set.add(arr[0][0]);
        dfs(arr, 0, 0, set);
        System.out.println(ans);

    }
    private static  void dfs (int[][] arr, int x, int y , Set<Integer> set){
        if(x==n-1 && y == m-1){
            ans++;
            return;
        }
        int[][] dir = new int[][]{{1,0},{0,1}};
        for(int[] d:dir){
            int nx = x + d[0], ny = y +d[1];
            if(nx>=n || ny>=m){
                continue;
            }
            if(set.contains(arr[nx][ny])){
                continue;
            }
            set.add(arr[nx][ny]);
            dfs(arr, nx, ny,set);
            set.remove(arr[nx][ny]);
        }
    }
}
