package com.example.demo.nowcode.N59717;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr  = new int[n];
        int[] tar = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] rec = new int[n+1];
        for (int i = 0; i < n; i++) {
            rec[sc.nextInt()]  = i;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = rec[arr[i]];
        }
        System.out.println(n-lengthOfLIS(arr));





    }
    private   static int lengthOfLIS(int[] nums) {
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
            dp[lo] = num;
            if(lo == maxL)
                maxL++;
        }
        return maxL;
    }
}
