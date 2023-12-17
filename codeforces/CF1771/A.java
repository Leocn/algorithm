package com.example.demo.codeforces.CF1771;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int max = arr[n-1] - arr[0];
            int left = 1, right = 1;
            for (int i = 0; i < n-1; i++) {
                if(arr[i]==arr[i+1]){
                    left++;
                }else {
                    break;
                }
            }
            for (int i = n-1; i >0 ; i--) {
                if(arr[i] == arr[i-1]){
                    right++;
                }else {
                    break;
                }
            }
            long ans = (long)left*right*2;
            if(left==n){
                System.out.println((long)n*(n-1));
            }else{
                System.out.println(ans);
            }
        }
    }
}
