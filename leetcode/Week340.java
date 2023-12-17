package com.example.demo.leetcode;

import org.assertj.core.data.MapEntry;

import java.util.*;

public class Week340 {
    public static void main(String[] args) {
        System.out.println(minimumVisitedCells(new int[][]{{2,1,0},{1,0,0}}));
        ///////System.out.println(minimumVisitedCells(new int[][]{{3,4,2,1},{4,2,3,1},{2,1,0,0},{2,4,0,0}}));
    }
    public int diagonalPrime(int[][] nums) {
        int n  = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime(nums[i][i])){
                ans = Math.max(ans,nums[i][i] );
            }
            if(isPrime(nums[i][n-1-i])){
                ans = Math.max(ans,nums[i][n-1-i] );
            }
            ;
        }

        return ans;
    }
    static boolean isPrime(int s){
        if(s<=2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(s);i++){
            if(s%i!=0){
                return false;
            }
        }
        return true;
    }

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list =map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            map.put(nums[i], list);
        }
        for(Map.Entry<Integer, List<Integer>> m : map.entrySet()){
            int k = m.getKey();
            List<Integer> list = m.getValue();
            long s = 0;
            for (int i = 1; i < list.size(); i++) {
                s+= list.get(i)-list.get(0);
            }
            ans[list.get(0)] = s;
            long cnt = 1;
            for (int i = 1; i < list.size(); i++) {
                s-= (long)(n-i)*(list.get(i)- list.get(i-1));
                s+= cnt*(list.get(i)- list.get(i-1));
                cnt++;
                ans[list.get(i)] = s;
            }
        }
        return ans;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int left = 0, right = (int)1e9+100;
        int n = nums.length;
        while (left<right){
            int mid = left+right>>1;
            int cnt = 0;
            for (int i = 0; i < n-1; i++) {
                if(nums[i+1] - nums[i]<=mid){
                    cnt++;
                    i++;
                }
            }
            if(cnt>=p){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    public static int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]>[] Rows = new PriorityQueue[m];
        PriorityQueue<int[]>[] Columns = new PriorityQueue[n];
        for (int i = 0; i < m; i++) {
            Rows[i] = new PriorityQueue<>((a,b)->{
                if(a[1]- b[1]==0){
                    return a[0]-b[0];
                }else {
                    return  a[1] - b[1];
                }
            });
        }

        for (int i = 0; i < n; i++) {
            Columns[i] = new PriorityQueue<>((a,b)->{
                if(a[1]- b[1]==0){
                    return a[0]-b[0];
                }else {
                    return  a[1] - b[1];
                }
            });
        }

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        Columns[0].add(new int[]{grid[0][0], 0});
        Rows[0].add(new int[]{grid[0][0], 0});
        for (int i = 1; i <m ; i++) {
            while (Columns[0].size()>0 && Columns[0].peek()[0]<i){
                Columns[0].poll();
            }
            if(Columns[0].size()>0){

                dp[i][0] = Columns[0].peek()[1]+1;
                Columns[0].add(new int[]{grid[i][0] + i,dp[i][0]});
                Rows[i].add(new int[]{grid[i][0],dp[i][0]});
            }

        }


        for (int i = 1; i <n ; i++) {
            while (Rows[0].size()>0 && Rows[0].peek()[0]<i){
                Rows[0].poll();
            }
            if(Rows[0].size()>0){
                dp[0][i] = Rows[0].peek()[1]+1;
                Rows[0].add(new int[]{grid[0][i] + i,dp[0][i]});
                Columns[i].add(new int[]{grid[0][i],dp[0][i]});
            }
        }

        for (int i = 1, j=1; i < m || j<n; i++, j++) {

            if(i>=m){
                i = m-1;
            }
            if(j>=n){
                j = n-1;
            }

            for (int k = i; k <m ; k++) {
                while (Columns[j].size()>0 && Columns[j].peek()[0]<i){
                    Columns[j].poll();
                }
                if(Columns[j].size()>0){
                    dp[k][j] = Columns[j].peek()[1]+1;
                    Columns[j].add(new int[]{grid[k][j] + k,dp[k][j]});
                    Rows[k].add(new int[]{grid[k][j] +j,dp[k][j]});
                    System.out.println(k+ " " + j + " " +dp[k][j]);

                }
            }


            for (int k = j+1; k <n ; k++) {
                while (Rows[i].size()>0 && Rows[i].peek()[0]<i){
                    Rows[i].poll();
                }
                if(Rows[i].size()>0){
                    if(i==1 && k==3){
                        System.out.println(i+ " " + k + " " +dp[i][k]);
                        System.out.println(i+ " " + k + " " +Rows[i].peek()[0]);
                    }
                    dp[i][k] = Rows[i].peek()[1]+1;
                    Rows[i].add(new int[]{grid[i][k] + i,dp[i][k]});
                    Columns[k].add(new int[]{grid[i][k]+k,dp[i][k]});
                }
                System.out.println(i+ " " + k + " " +dp[i][k]);
            }

        }
        return dp[m-1][n-1];

    }

    public int minimumVisitedCellsT(int[][] grid) {
        int[] row = new int[grid.length], col = new int[grid[0].length];
        for (ArrayDeque<int[]> deque = new ArrayDeque<>(List.of(new int[3])); !deque.isEmpty();) {
            int[] poll = deque.poll();
            if (poll[1] == grid.length - 1 && poll[2] == grid[0].length - 1) {
                return poll[0] + 1;
            }
            for (row[poll[1]] = Math.max(row[poll[1]], poll[2] + 1); row[poll[1]] <= Math.min(grid[0].length - 1,
                    poll[2] + grid[poll[1]][poll[2]]); row[poll[1]]++) {
                deque.offer(new int[] { poll[0] + 1, poll[1], row[poll[1]] });
            }
            for (col[poll[2]] = Math.max(col[poll[2]], poll[1] + 1); col[poll[2]] <= Math.min(grid.length - 1,
                    poll[1] + grid[poll[1]][poll[2]]); col[poll[2]]++) {
                deque.offer(new int[] { poll[0] + 1, col[poll[2]], poll[2] });
            }
        }
        return -1;
    }
}
