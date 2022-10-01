package com.example.demo.codeforces.cf815;


import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
               arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int ans = arr[n-1] + arr[n-2] - arr[1] -arr[0];
            System.out.println(ans);
        }
    }

}
