package com.example.demo.nowcode.N64272;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = (int)1e9+7;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) arr[i] *(arr[i]+1)/2)%mod;
        }
        for (int i = 1; i <n-1 ; i++) {
            int f = i-1, r = i+1;
            while (f>=0 && r<=n-1){
                ans = (ans + Math.min(arr[f], arr[r]))%mod;
                if(arr[f] == arr[r]){
                    f--;
                    r++;
                }else {
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
