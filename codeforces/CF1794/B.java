package com.example.demo.codeforces.CF1794;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i]==1){
                    arr[i]++;
                }
            }
            for (int i = 1; i < n; i++) {
                if(arr[i]%arr[i-1]==0){
                    arr[i] ++;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);

        }
    }

}
