package com.example.demo.codeforces.CF1802;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int now = 0, ans = 0, cnt = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]==2){
                    now = 1+ (cnt-1)/2+ (cnt-1)%2;
                    continue;
                }
                cnt++;
                now++;
                ans =Math.max(ans, now);
            }

            System.out.println(ans);


        }
    }
}
