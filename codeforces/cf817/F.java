package com.example.demo.codeforces.cf817;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {
    static boolean[][] vis;
    static  char[][] arr;
    static  int n;
    static  int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            arr = new char[n][m];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next().toCharArray();
            }
            vis = new boolean[n][m];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(arr[i][j] =='.'){
                        vis[i][j] = true;
                    }

                }
            }
            ll:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(vis[i][j]){
                        continue;
                    }
                    vis[i][j] = true;
                    if(arr[i][j]=='*'){
                        List<int[]> list = new ArrayList<>();
                        list.add(new int[]{i,j});
                        dfs(i, j , list);
                        if(list.size()!=3){
                            flag = false;
                            break ll;
                        }
                        int maxX = -1, minX = 100, maxY = -1, minY =100;
                        for (int k = 0; k < 3; k++) {
                            maxX = Math.max(maxX, list.get(k)[0]);
                            minX = Math.min(minX, list.get(k)[0]);
                            maxY = Math.max(maxY, list.get(k)[1]);
                            minY = Math.min(minY, list.get(k)[1]);

                        }
                        if(maxY-minY!=1 || maxX-minX!=1){
                            flag = false;
                            break ll;
                        }
                    }


                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }


        }

    }
    static int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{0,-1},{1,-1},{1,0},{1,1}};
    private static void dfs(int i , int j,List<int[]> list ){
        for(int[] dir: dirs){
            int x = dir[0], y= dir[1];
            if(i+x<0 || i+x>=n || j+y<0 || j+y>=m){
                continue;
            }
            if(vis[i+x][j+y]){
                continue;
            }
            vis[i+x][j+y] = true;
            if(arr[i+x][j+y]=='*'){
                list.add(new int[]{i+x,j+y});
                dfs(i+x, j+y, list);
            }
        }
    }
}
