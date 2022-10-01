package com.example.demo.codechef;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.max(arr[i]-1, m-arr[i]);
            }
            System.out.println(ans);
        }
    }
}
