package com.example.demo.codeforces.CF1324;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
             for (int i = 0; i < n-1; i++) {
                if((arr[i+1]- arr[i])%2!=0){
                    System.out.println("NO");
                    continue out;
                }
            }
            System.out.println("YES");
        }
    }
}
