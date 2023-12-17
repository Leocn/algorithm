package com.example.demo.leetcode;

import java.util.*;

public class Week345 {
    public static void main(String[] args) {

    }
    public int[] circularGameLosers(int n, int k) {
        boolean[] vis = new boolean[n];
        int loc = 1;
        int now = 0;
        vis[0] = true;
        while (true){
            if(vis[(now+loc*k)%n]){
                break;
            }else {
                vis[(now+loc*k)%n]= true;
                now = (now+loc*k)%n;

                loc++;
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                list.add(i+1);
            }
        }
        int[] ans = new int[list.size()];
        int t = 0;
        for(int l: list){
            ans[t++] = l;
        }
        return ans;
    }


    public boolean doesValidArrayExist(int[] derived) {

        int n = derived.length;
        int t = 0;
        for (int i = 1; i <n-1 ; i++) {
            t= derived[i-1]^ t;
        }
        return (t^derived[n-1]) == 0;

    }

    public int maxMoves(int[][] grid) {
        int[][] dirs = new int[][]{{-1, 1},{0,1},{1,1}};
        int n = grid.length, m = grid[0].length;
        Deque<int[]> dq = new ArrayDeque<>();

        int[][] dis = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {

            dq.add(new int[]{i,0});
            for(int[] d: dis){
                Arrays.fill(d, Integer.MAX_VALUE);
                dis[i][0] = 0;
            }
            int d = 0;
            while (dq.size()>0){
                int s = dq.size();
                d++;
                while (s-->0){
                    int[] p = dq.pop();
                    for(int[] dir: dirs){
                        int x=  dir[0] + p[0];
                        int y = dir[1] + p[1];
                        if(x<0 || x>=n || y<0 || y>=m || dis[x][y]!= Integer.MAX_VALUE){
                            continue;
                        }
                        if(grid[x][y]<=grid[p[0]][p[1]]){
                            continue;
                        }
                        dis[x][y] = d;
                        dq.add(new int[]{x,y});
                    }

                }
            }
            ans = Math.max(ans, d);
        }
        return ans-1;


    }


    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        List[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for(int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(vis[i]){
                continue;
            }
            Deque<Integer> dq= new ArrayDeque<>();
            dq.add(i);
            int sum = arr[i].size();
            int cnt = 1;
            vis[i] = true;
            while (dq.size()>0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                for(int next: list){
                    if(vis[next]){
                        continue;
                    }
                    vis[next] = true;
                    dq.add(next);
                    sum += arr[next].size();
                    cnt++;
                }
            }
            if(sum/2 == cnt*(cnt-1)/2){
                ans++;
            }
        }
        return ans;

    }
}
