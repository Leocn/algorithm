package com.example.demo.codeforces.TFR9;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int maxL = 0;
        int[] dp = new int[arr.length];
        for(int num : arr) {
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
        System.out.println( maxL);


    }
}
