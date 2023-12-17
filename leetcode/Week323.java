package com.example.demo.leetcode;

import java.util.*;

public class Week323 {
    public int deleteGreatestValue(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int[] g : grid) {
            Arrays.sort(g);
        }
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int[] g : grid) {
                max = Math.max(g[i], max);

            }
            ans +=max;
        }

        return ans;
    }

    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = (int)Math.sqrt(nums[i]);
            if(t*t==nums[i] && map.containsKey(t)){
                map.put(nums[i], map.get(t)+1);
                ans = Math.max(ans, map.get(nums[i]));
            }else{
                map.put(nums[i], 1);
            }

        }
        if(ans<=1){
            return -1;
        }else {
            return ans;
        }
    }

    class Allocator {

        
        int[] arr;
        int n;
        public Allocator(int _n) {
            n = _n;
            arr = new int[n];
        }

        public int allocate(int size, int mID) {
            int loc = -1;
            for (int i = 0; i <n ; i++) {
                int s = i;
                while (i<n&& arr[i]==0){
                    i++;
                }
                if(i-s>=size){
                    for (int j = s; j < s+size; j++) {
                        arr[j]  = mID;
                    }
                    return s;
                }
            }
            return -1;
        }

        public int free(int mID) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] == mID){
                    cnt++;
                    arr[i] = 0;
                }
            }
            return cnt;
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {

        int[][] res = new int[queries.length][2];
        for (int i = 0; i <queries.length ; i++) {
            res[i][0] = queries[i];
            res[i][1] = i;
        }
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Arrays.sort(res, (a,b)->a[0]-b[0]);

        PriorityQueue<int[]>  deque = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] ans = new int[queries.length];
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int t = 0;
        for (int i = 0; i < queries.length; i++) {
//            if(deque.size()>0){
//
//            }
            if(!vis[0][0] && grid[0][0]<res[i][0]){
                deque.add(new int[]{grid[0][0],0,0});
                vis[0][0] = true;
                while (deque.size()>0 && res[i][0]>deque.peek()[0]){
                    int[] p = deque.poll();
                    t++;
                    for(int[] dir: dirs){
                        int x  = dir[0]+p[1];
                        int y = dir[1] + p[2];
                        if(x<0||x>=n || y<0|| y>=m || vis[x][y]){
                            continue;
                        }
                        deque.add(new int[]{grid[x][y], x,y});
                        vis[x][y] = true;
                    }
                }
            }

            while (deque.size()>0 && res[i][0]>deque.peek()[0]){
                int[] p = deque.poll();
                t++;
                for(int[] dir: dirs){
                    int x  = dir[0]+p[1];
                    int y = dir[1] + p[2];
                    if(x<0||x>=n || y<0|| y>=m || vis[x][y]){
                        continue;
                    }
                    deque.add(new int[]{grid[x][y], x,y});
                    vis[x][y] = true;
                }
            }
            ans[i] = t;

        }
        int[] tt = new int[queries.length];
        for(int i = 0; i<queries.length; i++){
            tt[res[i][1]] = ans[i];
        }
        return tt;

    }



}
