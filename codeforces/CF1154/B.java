package com.example.demo.codeforces.CF1154;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr =  new int[n];
        for (int  i = 0; i < n; i++) {
           arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if(arr[i]!= arr[0] && arr[i]!=arr[n-1] && arr[i]*2 != arr[0] +arr[n-1]){
                System.out.println(-1);
                return;
            }
        }
        if((arr[0] + arr[n-1])%2==0){
            System.out.println((-arr[0] + arr[n-1])/2);
        }else {
            System.out.println(arr[n-1] - arr[0] );
        }
    }
}
