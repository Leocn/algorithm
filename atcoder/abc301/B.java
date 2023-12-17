package com.example.demo.atcoder.abc301;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            int d = arr[i + 1] - arr[i];
            int abs = Math.abs(d);
            sb.append(arr[i]).append(" ");
            if(d ==1 || d ==-1){
                continue;
            }
            while (arr[i] + (d/abs)!=arr[i+1]){
                sb.append(arr[i] + (d/abs )).append(" ");
                arr[i] += d/(abs);
            }
        }
        sb.append(arr[n-1]);
        System.out.println(sb);
    }
}
