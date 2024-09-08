package com.example.demo.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Week414 {
    public static void main(String[] args) {

    }
    public String convertDateToBinary(String date) {
        String[] g = date.split("-");
        String ans = "";
        ans += Integer.toBinaryString(Integer.parseInt(g[0])) + "-";
        ans += Integer.toBinaryString(Integer.parseInt(g[1])) + "-";
        ans += Integer.toBinaryString(Integer.parseInt(g[2]));
        return ans;
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        long l = 0, r = (long)2e10+1;
        while (l < r){
            long mid = l + (r- l >>1);
            long s = start[0];
            boolean f = true;
            for (int i = 1; i < n; i++) {
                if(s+mid>start[i]+d){
                    f = false;
                    break;
                }
                s = Math.max(s+ mid, start[i]);
            }
            if(!f){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return (int)(l-1);
    }

    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = nums.get(i);
        }
        long ans = 0;
        int f = -1;
        for (int i = 0; i < n-1; i++) {
            if(g[i]>f){
                f = g[i];
            }
            ans += f;
        }
        return ans;

    }

    int[][] dirs = new int[][]{{2,-1},{1,-2},{2,1},{1,2},{-2,-1},{-1,-2},{-1,2},{-2,1}};
    int[][][] maxD;
    int n;
    int[][] dis;
    public int maxMoves(int kx, int ky, int[][] positions) {
        n = positions.length;
        dis = new int[n][n];
        int[] k = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                dis[i][j] = minDis(positions[i][0], positions[i][1], positions[j][0], positions[j][1]);
                dis[j][i] = dis[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            k[i] = minDis(kx,ky, positions[i][0], positions[i][1]);
        }
        int max = (1<<n) - 1;
        maxD = new int[2][n][max];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(maxD[i][j], Integer.MIN_VALUE/10);
            }

        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(dfs(1,  max ^(1<<i) , i) + k[i], ans);
        }
        return ans;

    }

    private int dfs(int pre, int now, int loc){
        if(now == 0){
            return 0;
        }
        if (maxD[pre][loc][now]!= Integer.MIN_VALUE/10){
            return maxD[pre][loc][now];
        }

        int res = 0;
        if(pre == 1){
            res = Integer.MAX_VALUE/10;
        }
        for (int i = 0; i < n; i++) {
            if((now &(1<<i)) == 0) continue;
            if(pre == 0){
                res = Math.max(dfs(pre^1, now^(1<<i), i) + dis[loc][i], res);
            }else {
                res = Math.min(dfs(pre^1, now^(1<<i), i) + dis[loc][i], res);
            }
        }
        maxD[pre][loc][now] = res;
        return res;
    }

    private int minDis(int fx, int fy , int tx, int ty){
        boolean[][] vis = new boolean[50][50];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{fx,fy});
        int res = 0;
        out:while (dq.size()>0){
            int s = dq.size();
            res ++;
            while (s-->0){
                int[] p = dq.poll();
                for(int[] d: dirs){
                    int x = p[0] + d[0];
                    int y = p[1] + d[1];
                    if(x<0 || x>=50 || y<0 || y>=50 || vis[x][y]){
                        continue;
                    }
                    if(x == tx && ty == y){
                        break out;
                    }
                    vis[x][y] = true;
                    dq.add(new int[]{x, y});
                }
            }

        }
        System.out.println(fx + " " + fy + " " + tx + " " + ty+ " " + res ) ;
        return res;
    }

}
