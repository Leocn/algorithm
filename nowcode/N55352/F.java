package com.example.demo.nowcode.N55352;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int k = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int[][] dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i], -1);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int tarX = 0, tarY = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]=='S'){
                    dq.add(new int[]{i,j});
                    dis[i][j] = 0;

                }
                if(arr[i][j] == 'T'){
                    tarX = i;
                    tarY = j;
                }
            }
        }
        int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
        while (dq.size()>0){
            int[] p = dq.poll();
            for(int[] d: dirs){
                int x = d[0] + p[0];
                int y = d[1] + p[1];
                if(x<0 || x>=n || y<0 || y>=m){
                    continue;
                }
                if(arr[x][y]=='#'){
                    continue;
                }
                if(dis[x][y]!=-1){
                    continue;
                }
                dis[x][y] = dis[p[0]][p[1]] + 1;
                dq.add(new int[]{x,y});
            }
        }

        int ans = m+n+1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dis[i][j]==-1){
                    continue;
                }
                if(dis[i][j]>k){
                    continue;
                }
                ans = Math.min(Math.abs(i-tarX) + Math.abs(j-tarY) , ans);
            }
        }
        System.out.println(ans);
    }
}
