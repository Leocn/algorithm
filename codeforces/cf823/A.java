package com.example.demo.codeforces.cf823;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int c = sc.nextInt();
            int[] arr = new int[101];
            for (int i = 0; i < n; i++) {
                arr[sc.nextInt()] ++;
            }
            int ans = 0;
            for (int i = 0; i < 101; i++) {
                if(arr[i]>0){
                    ans+= Math.min(arr[i], c);
                }
            }
            System.out.println(ans);


        }
    }
}
