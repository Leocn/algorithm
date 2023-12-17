package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class Week349 {
    public static void main(String[] args) {

    }
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=2){
            return -1;
        }
        return nums[1];

    }

    public String smallestString(String s) {
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int i = 0; i <n ; i++) {
            if(cs[i]!='a'){
                while (i<n && cs[i]!='a'){
                    cs[i] = (char)(cs[i]-1);
                    i++;
                }
                return new String(cs);
            }
        }
        cs[n-1] = 'z';
        return new String(cs);
    }

    public long minCost(int[] nums, int x) {
        long ans = Long.MAX_VALUE, s= 0;
        int n = nums.length;
        int[] min = new int[n];
        Arrays.fill(min, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                min[i] = Math.min(min[i], min[(i+j)%n]);
                sum += min[i];
            }
            sum += s *x;
            ans = Math.min(ans, sum);
            s++;
        }
        LinkedList<int[]> lis = new LinkedList<int[]>();
        int a = lis.peekLast()[1];
        return ans;

    }

}
