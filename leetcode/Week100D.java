package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Week100D {
    public static void main(String[] args) {

    }

    public int distMoney(int money, int children) {
        int d = money/8;
        if(d== children){
            return d;
        }else if(d>children){
            return children -1;
        }else{
            int l = money%8;
            int s = children-d;
            if(s==1 && l==4){
                return  d-1;
            }else {
                while (l<s){
                    l+=8;
                    d--;
                }
                return d;
            }


        }


    }


    public int maximizeGreatness(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            while (pq.size()>0 && pq.peek()>=nums[i]){
                pq.poll();
            }
            if(pq.size()==0){
                break;
            }else {
                pq.poll();
                ans++;
            }
        }
        return ans;
    }

    public long findScore(int[] nums) {
        long ans = 0;
        int n = nums.length;
        boolean[] vis = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i],i});
        }
        while (pq.size()>0){
            while (pq.size()>0 && vis[pq.peek()[1]]){
                pq.poll();
            }
            if(pq.size()==0){
                break;
            }
            int[] p = pq.poll();
            ans += p[0];
            vis[p[1]] = true;
            if(p[1]>0){
                vis[p[1] -1] = true;
            }
            if(p[1]<n-1){
                vis[p[1] +1] = true;
            }
        }
        return ans;
    }


    public long repairCars(int[] ranks, int cars) {
        int n = ranks.length;
        long left = 1, right = (int)1e15;
        while (left<right){
            long mid = left+right>>1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += (long )Math.sqrt(mid/ranks[i]);
            }
            if(sum>=cars){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
}
