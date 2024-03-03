package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Week386 {
    public static void main(String[] args) {

    }
    public boolean isPossibleToSplit(int[] nums) {
        int[] cnt = new int[101];
        for(int num: nums){
            cnt[num]++;
            if(cnt[num]>2){
                return false;
            }
        }
        return true;
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;
        int n = bottomLeft.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                long a = Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                long b = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                long c = Math.min(topRight[i][0], topRight[j][0]);
                long d = Math.min(topRight[i][1], topRight[j][1]);

                long s = Math.max(0, Math.min(d-b,c-a));
                ans = Math.max(s*s, ans);
            }
        }
        return ans;
    }

//    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
//        int ans = 0;
//        int sum = 0;
//        int n = nums.length, m = changeIndices.length;
//        if(m<=n){
//            return -1;
//        }
//        for (int i = 0; i < n; i++) {
//            if (nums[i]>m-n){
//                return -1;
//            }
//            sum += nums[i];
//        }
//        if(sum + n > m){
//            return -1;
//        }
//
//        for (int i = sum + n; i < m; i++) {
//            if(check(nums, changeIndices, i)){
//                return i+1;
//            }
//        }
//
//        return -1;
//
//    }
//
//    private boolean check(int[] nums, int[] changeIndices, int mx) {
//        int[] lastT = new int[nums.length];
//        Arrays.fill(lastT, -1);
//        for (int t = 0; t < mx; t++) {
//            lastT[changeIndices[t] - 1] = t;
//        }
//        for (int t : lastT) {
//            if (t < 0) { // 没有标记时间
//                return false;
//            }
//        }
//
//        int cnt = 0;
//        for (int i = 0; i < mx; i++) {
//            int idx = changeIndices[i] - 1;
//            if (i == lastT[idx]) { // 一定要标记
//                if (nums[idx] > cnt) { // 无法减一
//                    return false;
//                }
//                cnt -= nums[idx]; // 减一的时间
//            } else {
//                cnt++; // 留着后面减一
//            }
//        }
//        return true;
//    }

    /**
     * 反悔贪心 二分
     * @param nums
     * @param changeIndices
     * @return
     */

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int n = nums.length;
        int m = changeIndices.length;
        if (n > m) {
            return -1;
        }

        long slow = n; // 慢速复习+考试所需天数
        for (int v : nums) {
            slow += v;
        }

        int[] firstT = new int[n];
        Arrays.fill(firstT, -1);
        for (int t = m - 1; t >= 0; --t) {
            firstT[changeIndices[t] - 1] = t;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int left = n - 1, right = m + 1;
        while (left < right) {
            pq.clear();
            int mid = (left + right) / 2;
            if (check(nums, changeIndices, firstT, pq, slow, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right > m ? -1 : right;
    }

    private boolean check(int[] nums, int[] changeIndices, int[] firstT, PriorityQueue<int[]> pq, long slow, int mx) {
        int cnt = 0;
        for (int t = mx - 1; t >= 0; t--) {
            int i = changeIndices[t] - 1;
            int v = nums[i];
            if (v <= 1 || t != firstT[i]) {
                cnt++; // 留给左边，用来快速复习/考试
                continue;
            }
            if (cnt == 0) {
                if (pq.isEmpty() || v <= pq.peek()[0]) {
                    cnt += 1; // 留给左边，用来快速复习/考试
                    continue;
                }
                slow += pq.poll()[0] + 1;
                cnt += 2; // 反悔：一天快速复习，一天考试
            }
            slow -= v + 1;
            cnt--; // 快速复习，然后消耗一天来考试
            pq.offer(new int[]{v, i});
        }
        return cnt >= slow; // 剩余天数不能慢速复习+考试
    }

}
