package com.example.demo.codeforces.CF1818;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            int ans = n;
            out:for (int i = 1; i <n ; i++) {
                for (int j = 0; j < k; j++) {
                    if(arr[i].charAt(j)!= arr[0].charAt(j)){
                        ans--;
                        continue out;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
