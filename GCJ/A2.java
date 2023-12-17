package com.example.demo.GCJ;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            int ans = 0;
            int m = sc.nextInt(), r = sc.nextInt(), n = sc.nextInt();
            int[] arr  =new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int left = 0;
            for (int i = 0; i < n; i++) {
                int s = i;
                while (s<n&& arr[s]-left<=r){
                    s++;
                }
                if(s>=n){
                    if(left>=m){

                    }else if(left<m&& arr[n-1] + r>=m){
                        ans++;
                    }else {
                        ans = -1;
                    }
                    break;
                }
                if(s==i){
                    ans = -1;
                    break;
                }
                ans++;
                left = arr[s-1] + r;
            }
            if(ans==-1){
                System.out.println("Case #"+k+": IMPOSSIBLE" );
            }else {
                System.out.println("Case #"+k+": " + ans );
            }


        }
    }
}
