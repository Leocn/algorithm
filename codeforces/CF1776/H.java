package com.example.demo.codeforces.CF1776;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int arrA[] = new int[n];
            int[] arrB = new int[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrB[i] = sc.nextInt();
            }
            int loc = 0;
            int[] cnt = new int[n+1];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                while (i<n && cnt[arrA[i]]==1){
                    i++;
                }
                if(i>=n){
                    break;
                }
                while (loc<n && arrB[loc]!=arrA[i]){
                    cnt[arrB[loc]]=1;
                    loc++;
                    ans++;
                }
                cnt[arrA[i]]=1;
                loc++;
            }
            System.out.println(ans);
        }
    }
}
