package com.example.demo.codeforces.CF1789;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(gcd(arr[i],arr[j])<=2){
                        System.out.println("YES");
                        continue out;
                    }
                }
            }
            System.out.println("NO");
        }
    }
    private static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }
}
