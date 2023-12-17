package com.example.demo.leetcode;

import java.util.*;

public class Week337 {
    public static void main(String[] args) {

    }

    public int[] evenOddBit(int n) {
        int ans1 =0, ans2 = 0;
        int loc = 0;
        while (n>0){
            int t = n%2;
            if(t==1){
                if(loc%2==0){
                    ans1++;
                }else {
                    ans2++;
                }
            }
            loc++;
            n /=2;
        }
        return  new int[]{ans1,ans2};
    }

    public boolean checkValidGrid(int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==0){
                    if(i!=0||j!=0){
                        return false;
                    }
                    dq.add(new int[]{0, i, j});
                    break;
                }
            }
        }
        int ans = 0;
        int[][] dirs = new int[][]{{-2, 1}, {-2, -1}, {-1,2}, {-1,-2},{2, 1}, {2, -1}, {1,2}, {1,-2} };
        while (dq.size()>0){
            int[] p = dq.poll();
            ans = p[0];
            for(int[] d: dirs){
                int x = p[1] + d[0], y = p[2] + d[1];
                if(x>=n || x<0 || y>=n || y<0){
                    continue;
                }
                if(grid[x][y]!= p[0]+1){
                    continue;
                }
                dq.add(new int[]{p[0]+1, x, y});
            }
        }
        if(ans == n*n-1){
            return true;
        }else {
            return  false;
        }
    }


    public int findSmallestInteger(int[] nums, int value) {
        int[] cnt = new int[value+1];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int d = nums[i] %value;
            if(d<0){
                d = (d+value)%value;
            }
            cnt[d]++;
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int d = i%value;
            if(cnt[d]>0){
                cnt[d]--;
                ans = d;
            }else {
                break;
            }
        }
        return ans+1;
    }

    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int s = 1<<n;
        int ans = 0;
        out:for (int i = 1; i < s; i++) {
            int[] cnt = new int[3001];
            int tem = i;
            int loc = 0;
            while (tem>0){
                int d = tem&1;
                if(d==1){
                    if(nums[loc]+k>=0){
                        if(cnt[nums[loc]+k]>0){
                            continue  out;
                        }
                    }
                    if(nums[loc]-k>=0){
                        if(cnt[nums[loc]-k]>0){
                            continue  out;
                        }
                    }

                    cnt[nums[loc]]++;
                }
                tem>>=1;
                loc++;
            }
            ans++;
        }
        return ans;
    }

}
