package com.example.demo.codeforces.cf822;

import java.util.Arrays;
import java.util.Scanner;

public class A{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i]= sc.nextInt();
            }
            Arrays.sort(arr);
            long ans = Integer.MAX_VALUE;
            for (int i = 0; i <n-2 ; i++) {
                ans = Math.min(arr[i+2]+arr[i+1] - arr[i], ans);
            }
            for (int i = n-1; i >=2 ; i--) {
                ans = Math.min(2L * arr[i] - arr[i-1]- arr[i-2]  ,ans);
            }
            for (int i = 1; i < n-1; i++) {
                ans = Math.min(arr[i+1] -arr[i-1] ,ans);
            }

            System.out.println(ans);
        }
    }
}
