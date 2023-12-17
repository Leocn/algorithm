package com.example.demo.codeforces.CF1788;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i] == 2){
                    cnt++;
                }
            }
            if(cnt%2!=0){
                System.out.println(-1);
                continue;
            }
            if(cnt==0){
                System.out.println(1);
                continue;
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]==2){
                    ans++;
                }
                if(ans == cnt/2){
                    System.out.println(i+1);
                    break;
                }
            }

        }
    }
}
