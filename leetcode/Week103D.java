package com.example.demo.leetcode;

import java.util.*;

public class Week103D {
    public static void main(String[] args) {

    }
    public int maximizeSum(int[] nums, int k) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            ans += nums[nums.length-1]+i;
        }
        return ans;
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int n = A.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            set.add(A[i]);
            int cnt = 0;
            for (int j = 0; j <=i; j++) {
                if(set.contains(B[j])){
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }

    public int findMaxFish(int[][] grid) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;
        boolean[][] vis =  new boolean[n][m];
        int[][] dirs = new int[][]{{-1,0}, {1,0},{0,1},{0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==0){
                    continue;
                }
                Deque<int[]> dq = new ArrayDeque<>();
                dq.add(new int[]{i,j});
                vis[i][j] = true;
                int sum = 0;
                while (dq.size()>0){
                    int[] p = dq.poll();
                    sum += grid[p[0]][p[1]];
                    for(int[] d: dirs){
                        int x = d[0]+ p[0];
                        int y = d[1] + p[1];

                        if(x<0 || x>=n || y<0 || y>=m){
                            continue;
                        }
                        if(vis[x][y]){
                            continue;
                        }
                        if(grid[x][y]>0){
                            vis[x][y] = true;
                            dq.add(new int[]{x,y});
                        }
                    }
                }
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }
        int[] tree;
        int lowbit(int x) {
            return x & -x;
        }
        int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
            return ans;
        }
        void add(int x, int u) {
            for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
        }
        int n ;
        public long countOperationsToEmptyArray(int[] nums) {

             n = nums.length;
            long ans = n;
            tree = new int[n + 1];
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = nums[i];
                arr[i][1] = i;
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            ans += arr[0][1];
            int loc = arr[0][1];
            add(loc+1,1);
            for (int i = 1; i <n ; i++) {
                int newLoc = arr[i][1];
                int s = 0;
                if(newLoc>loc){
                    s = (newLoc-loc-1) - (query(newLoc+1) - query(loc+1));
                }else {
                    s = (n- newLoc-1) + (loc) - (query(newLoc) + query(n) - query(newLoc +1));
                }
                ans += s;
                add(newLoc+1,1);
            }
            return ans;


        }
}
