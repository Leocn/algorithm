package com.example.demo.atcoder.abc311;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;


public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.next().toCharArray();
        }
        boolean[][][] vis = new boolean[n][m][4];
        boolean[][] vis1 = new boolean[n][m];
        int[][] dirs = new int [][]{{-1,0},{1,0},{0,-1},{0,1}};
        int ans = 1;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{1,1,1});
        dq.add(new int[]{1,1,3});
        vis[1][1][1] = true;
        vis[1][1][3] = true;
        vis1[1][1] = true;
        while (dq.size()>0){
            int[] p = dq.poll();
            int a = p[0]+ dirs[p[2]][0];
            int b = p[1] + dirs[p[2]][1];

            if(cs[a][b]=='#'){
                for (int i = 0; i < 4; i++) {
                    if(vis[p[0]][p[1]][i]) continue;
                    vis[p[0]][p[1]][i] = true;
                    dq.add(new int[]{p[0],p[1],i});
                }
            }else {
                if(!vis1[a][b]){
                    ans++;
                    vis1[a][b] = true;
                }
                if(!vis[a][b][p[2]]){
                    vis[a][b][p[2]] = true;
                    dq.add(new int[]{a,b,p[2]});
                }

            }


        }
        System.out.println(ans);


    }
}

