package com.example.demo.leetcode;

import java.util.*;

public class LCCUPFALL {
    public static void main(String[] args) {
        ballGame(3, new String[]{".....","....O","....O","....."});

    }

    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int ans = 0;
        int n = temperatureA.length;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if(temperatureA[i]-temperatureA[i-1]>0 && temperatureB[i]-temperatureB[i-1]>0){
                ans++;
            }else if(temperatureA[i]-temperatureA[i-1]==0 && temperatureB[i]-temperatureB[i-1]==0){
                ans++;
            }else if(temperatureA[i]-temperatureA[i-1]<0 && temperatureB[i]-temperatureB[i-1]<0){
                ans ++;
            }else {
                ans = 0;
            }
            max =Math.max(max, ans);

        }
        return max;
    }

    public int transportationHub(int[][] path) {
        int n = 0;
        for (int i = 0; i < path.length; i++) {
            n = Math.max(path[i][0], n);
            n = Math.max(path[i][1], n);
        }
        n++;
        List[] arr = new List[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        int[] out = new int[n];
        for (int i = 0; i < path.length; i++) {
            out[path[i][0]]++;
            arr[path[i][1]].add(path[i][0]);
        }
        boolean[] vis;
        for (int i = 0; i < n; i++) {
            if(out[i]!=0){
                continue;
            }
            vis = new boolean[n];
            Deque<Integer> deque = new ArrayDeque<>();
            deque.add(i);

            while(deque.size()>0){
                int p = deque.poll();
                vis[p] = true;
                List<Integer> list = arr[p];
                for(int l: list){
                    if(vis[l]){
                        continue;
                    }
                    vis[l] = true;
                }
            }
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(vis[j]){
                    count++;
                }

            }
            if(count==n){
                return i;
            }
        }
        return -1;
    }

    static int[][] dirs = new int[][]{{-1,0}, {0,1 },{1,0}, {0,-1}};
    public static int[][] ballGame(int num, String[] plate) {
        int n = plate.length;
        int m = plate[0].length();
        char[][] arr =new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = plate[i].toCharArray();
        }
        Deque<int[]> deque = new ArrayDeque<>();
        int[][][] dp = new int[n][m][4];
        int sum = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]== 'O'){
                    for (int k = 0; k < 4; k++) {
                        int[] d = dirs[k];
                        int x = d[0]+i; int y = d[1] +j;
                        if(x<0|| x>=n|| y<0 || y>=m){
                            continue;
                        }

                        if(arr[x][y]=='.' && dp[x][y][k] == 0){
                            dp[x][y][k] = sum;
                            deque.add(new int[]{x,y,k});
                        }
                        if(arr[x][y]== 'E' && dp[x][y][(k-1+4)%4] == 0){
                            dp[x][y][(k-1+4)%4] = sum;
                            deque.add(new int[]{x,y,(k-1+4)%4});
                        }

                        if(arr[x][y]== 'W' && dp[x][y][(k+1)%4] == 0){
                            dp[x][y][(k+1)%4] = sum;
                            deque.add(new int[]{x,y,(k+1)%4});
                        }

                    }
                }
            }
        }
        List<int[]> ans = new ArrayList<>();


        sum++;
        while (deque.size()>0 && sum<=num ){
            int sz = deque.size();
            while (sz-->0){
                int[] p = deque.poll();
                int i = p[2];
                    int[] d = dirs[i];
                    int x = d[0]+p[0]; int y = d[1] +p[1];
                    if(x<0|| x>=n|| y<0 || y>=m){
                        continue;
                    }
                    if(arr[x][y]=='.' && dp[x][y][i] == 0){
                        dp[x][y][i] = sum;
                        deque.add(new int[]{x,y,i});
                    }
                    if(arr[x][y]== 'E' && dp[x][y][(i-1+4)%4] == 0){
                        dp[x][y][(i-1+4)%4] = sum;
                        deque.add(new int[]{x,y,(i-1+4)%4});
                    }

                    if(arr[x][y]== 'W' && dp[x][y][(i+1)%4] == 0){
                        dp[x][y][(i+1)%4] = sum;
                        deque.add(new int[]{x,y,(i+1)%4});
                    }
            }

            sum++;

        }

        for (int i = 1; i < n-1; i++) {
            if(dp[i][0][3] !=0 && dp[i][0][3] <= num && arr[i][0] == '.'){
                ans.add(new int[]{i,0});
            }
        }
        for (int i = 1; i < n-1; i++) {
            if(dp[i][m-1][1] != 0 && dp[i][m-1][1] <= num && arr[i][m-1] == '.'){
                ans.add(new int[]{i,m-1});
            }
        }

        for (int i = 1; i < m-1; i++) {
            if(dp[0][i][0] != 0 && dp[0][i][0] <= num && arr[0][i]== '.'){
                ans.add(new int[]{0,i});
            }
        }
        for (int i = 1; i < m-1; i++) {
            if(dp[n-1][i][2] !=0 && dp[n-1][i][2] <= num && arr[n-1][i]== '.'){
                ans.add(new int[]{n-1,i});
            }
        }

        return ans.toArray(new int[ans.size()][2]);

    }
}
