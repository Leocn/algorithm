package com.example.demo.atcoder.abc269;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
public class D {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[2500][2500];
        boolean[][] vis = new boolean[2500][2500];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt()+1000;
            int y = sc.nextInt()+1000;
            arr[x][y] = 1;
        }
        int ans = 0;
        int[][] dirs = new int[][]{{-1,-1},{-1,0},{0,-1},{0,1},{1,0},{1,1}};
        for (int i = 0; i < 2500; i++) {
            for (int j = 0; j < 2500; j++) {
                if(!vis[i][j] && arr[i][j] == 1){
                    ans++;
                    vis[i][j] = true;
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.add(new int[]{i,j});
                    while (deque.size()>0){
                        int[] p = deque.poll();
                        for(int[] d: dirs){
                            int x = d[0]+ p[0]; int y = d[1] + p[1];
                            if(x<0|| x>=2500|| y<0||y>=2500){
                                continue;
                            }
                            if(vis[x][y]){
                                continue;
                            }
                            if(arr[x][y]!=1){
                                continue;
                            }
                            vis[x][y] = true;
                            deque.add(new int[]{x,y});
                        }
                    }

                }
            }

        }
        System.out.println(ans);
    }

}
