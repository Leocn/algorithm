package com.example.demo.leetcode;

import java.util.*;

public class Week139D {
    public static void main(String[] args) {

    }
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 1; i < height.length; i++) {
            if(height[i-1]>threshold){
                ans.add(i);
            }
        }
        return ans;
    }

    static int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    static public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = grid.get(i).get(j);
            }
        }
        int[][] cnt = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cnt[i], Integer.MAX_VALUE/10);
        }

        pq.add(new int[]{0, 0, g[0][0]});
        while (pq.size()>0){
            int[] p = pq.poll();
            for(int[] d: dirs){
                int x = d[0] + p[0];
                int y = d[1] + p[1];
                if(x<0 || x>=n || y<0 || y>=m || cnt[x][y]<= p[2] + g[x][y]){
                    continue;
                }
                cnt[x][y] = p[2] + g[x][y];
                pq.add(new int[]{x,y, cnt[x][y]});
            }
        }
        return cnt[n-1][m-1]< health;
    }

    public int maxValue(int[] nums, int k) {
        int max = 1<<7;
        int n = nums.length;
        boolean[][][] pre = new boolean[n+1][k+1][max+1];
        int ans = 0;
        pre[0][0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= max; l++) {
                    if(pre[i][j][l]){
                        if(j<k){
                            pre[i+1][j+1][l|nums[i]] = true;
                        }

                        pre[i+1][j][l] = true;
                        //   System.out.println((i+1) + " " + (j+1) +" " + (l|nums[i]));

                    }
                }
            }
        }

        boolean[][][] suf = new boolean[n+1][k+1][max+1];
        suf[n][0][0] = true;
        for (int i = n-1; i >=k; i--) {
            for (int j = 0; j <= k; j++) {
                for (int l = 0; l <= max; l++) {
                    if(suf[i+1][j][l]){
                        if(j<k){
                            suf[i][j+1][l|nums[i]] = true;
                        }
                        suf[i][j][l] = true;

                    }
                }
            }
            for (int j = 0; j <= max; j++) {
                for (int l = 0; l <=max; l++) {
                    if(pre[i][k][j] && suf[i][k][l]){
                        ans = Math.max(l ^j, ans);
                    }
                }
            }
        }
        return ans;

    }
    public int maxPathLength(int[][] coordinates, int k) {
        int[] now = Arrays.copyOf(coordinates[k],2);
        Arrays.sort(coordinates, (a,b)->{
            if(a[0] == b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return a[0] - b[0];
        });

        List<Integer> pre = new ArrayList<>();
        List<Integer> suf = new ArrayList<>();
        for (int[] coordinate : coordinates) {
            if (coordinate[0] < now[0] && coordinate[1] < now[1]) {
                pre.add(coordinate[1]);
            }
            if (coordinate[0] > now[0] && coordinate[1] > now[1]) {
                suf.add(coordinate[1]);
            }
        }
        return lengthOfLIS(pre) + 1 + lengthOfLIS(suf);
    }
    public int lengthOfLIS(List<Integer> list) {

        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        int maxL = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while(lo < hi) {
                int mid = lo+(hi-lo)/2;
                if(dp[mid] < num)
                    lo = mid+1;
                else
                    hi = mid;
            }
            System.out.println(lo);
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }

}
