package com.example.demo.codeforces.ecf141;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer[] arr = new Integer[n];
            Integer[] arr2 = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                arr2[i] = arr[i];
            }
            Arrays.sort(arr);
            int win = 0, sum = 0, preSum =0;
            for(int i=0 ;i<n; i++){
                if(arr[i]+sum<=m){
                    win++;
                    sum += arr[i];
                }else {
                    break;
                }
            }
            if(win==n){
                System.out.println(1);
                continue;
            }
            for(int i =0; i<win-1; i++){
                preSum += arr[i];
            }
            if(preSum+arr2[win]<= m){
                System.out.println(n-win);
            }else{
                System.out.println(n-win+1);
            }

        }

    }
}
