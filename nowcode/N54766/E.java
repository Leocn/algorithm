package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        int[] arr  = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        int left = max, right = (int)1e+9;
        while (left< right){
            int mid = left+right>>1;
            int s = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {

                while (i<n && s+arr[i]<=mid){
                    s+=arr[i];
                    i++;
                }
                cnt++;
                if(i==n){
                    break;
                }
                s=0;
                i--;

            }
            if(cnt<=x){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
