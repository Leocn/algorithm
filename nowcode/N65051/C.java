package com.example.demo.nowcode.N65051;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = (int) 1e9+7;
        int n = sc.nextInt();
        int k =sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        long sum = arr[n-1];
        int min = Math.min(k, n-1);
        for (int i = 0; i < min; i++) {
            sum = sum*arr[n-i-2]%MOD;
        }
        sum = (sum + k)%MOD;
        for (int i = 0; i < n-2-min; i++) {
            sum = (sum +arr[i])%MOD;
        }
        System.out.println(sum);


    }
}
