package com.example.demo.leetcode;

import java.util.*;

public class Week362 {
    public static void main(String[] args) {

    }

    public int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;

        out:for (int i = 1; i <=100 ; i++) {
            for(List<Integer> l: nums){
                if(l.get(0)<=i&& i<=l.get(1) ){
                    ans++;
                    continue out;
                }
            }
        }
        return ans;
    }
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {

        int x = Math.abs(fx-sx);
        int y = Math.abs(fy-sy);
        if(x==0 && y==0 && t==1) return false;
        int max = Math.max(y,x);
        return t >= max;
    }

    public int minimumMoves(int[][] grid) {
        int ans = 0;
        int n = 3;
        boolean d = false;
        ArrayList<int[]>[] list = new ArrayList[n*n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        out:for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] > 1){
                    Deque<int[]> dq = new ArrayDeque<>();
                    dq.add(new int[]{i,j});
                    boolean[][]vis = new boolean[n][n];
                    d = true;
                    while (dq.size()>0){
                        int s = dq.size();
                        boolean b = false;
                        while (s-->0){
                            int[] p = dq.poll();
                            vis[p[0]][p[1]] = true;
                            for(int[] dir: dirs){
                                int nx = p[0] + dir[0];
                                int ny = p[1] + dir[1];
                                //System.out.println(i+ " " + j+ " " + nx + " "  +ny);

                                if(nx<0 || nx>=n || ny<0 || ny>=n){
                                    continue;
                                }
                                if(!vis[nx][ny]&&grid[nx][ny]==0){
                                    vis[nx][ny] = true;
                                    list[i*n+j].add(new int[]{nx,ny});
                                    b =true;
                                    //System.out.println(i+ " " + j+ " " + nx + " "  +ny);

                                }else if(!vis[nx][ny]){
                                    vis[nx][ny] = true;
                                    dq.add(new int[]{nx,ny});
                                }
                            }
                        }
                        if(b){
                            break out;
                        }
                    }
                }
            }
        }
        if(d){
            boolean f = false;
            int c = 1;
            while (!f){
                for (int i = 0; i < n*n; i++) {

                    if(list[i].size()==c){
                        System.out.println(c);
                        f = true;
                        grid[i/n][i%n] --;
                        int[] p = list[i].get(0);
                        grid[p[0]][p[1]] += 1;
                        ans += Math.abs(p[0]-i/n) + Math.abs(p[1]-i%n);
                        break;
                    }
                }
                c++;
            }


            return ans +minimumMoves(grid);
        }
        return ans;
    }

}
