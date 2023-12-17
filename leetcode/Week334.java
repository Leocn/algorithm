package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Week334 {
    public static void main(String[] args) {
        maxNumOfMarkedIndices(new int[]{42,83,48,10,24,55,9,100,10,17,17,99,51,32,16,98,99,31,28,68,71,14,64,29,15,40});
    }

    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int sumL[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            sumL[i+1] = sumL[i] + nums[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.abs(sumL[n]-nums[i] -sumL[i] - (sumL[i]));
        }
        return ans;
    }

    public int[] divisibilityArray(String word, int m) {
        char[] cs = word.toCharArray();
        int n = word.length();
        int[] ans = new int[n];
        long sum =0;
        for (int i = 0; i < n; i++) {
            sum =  sum *10 + (cs[i]-'0');

            sum%=m;
            if(sum==0){
                ans[i] = 1;
            }

        }
        return ans;
    }

    public static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int s = n/2, ans = 0;
        for (int i = 0; i < n/2; i++) {
            if(s==n){
                break;
            }
            while (s<n && nums[s]<2*nums[i]){

                s++;
            }
            if(s==n){
                break;
            }
            ans+=2;
        }
        return ans;
    }

    public int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(grid[0][1]>1 && grid[1][0]>1){
            return -1;
        }
        int[][] dirs = new int[][]{{0,1},{1,0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,0});
        int[][] max = new int[m][n];
        for(int[] mm: max){
           Arrays.fill(mm, Integer.MAX_VALUE);
        }
        while (pq.size()>0){
            int[] p = pq.poll();
            for(int[] d : dirs){
                int x = d[0] + p[1];
                int y = d[1] + p[2];
                if(x>=m || y>=n){
                    continue;
                }
                int  next = p[0]+1;
                if(grid[x][y]>p[0]+1){
                    next = (grid[x][y] -p[0])/2 *2 + p[0]+1;
                }

                if(max[x][y]<=next){
                    continue;
                }
                max[x][y] = next;
                if(x==m-1 && y==n-1){
                    return max[x][y];
                }
                pq.add(new int[]{next, x,y});
            }
        }
        return -1;

    }
}
