package com.example.demo.codeforces.cf832;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            long sum = 0;
            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
                sum += arr[i];
            }
            System.out.println(Math.abs(sum));
        }
    }
}
