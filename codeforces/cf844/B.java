package com.example.demo.codeforces.cf844;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long ans = 0;
            int[] b = new int[n+1];
            b[0] = 1;
            for (int i = 1; i < n; i++) {
                b[i] = Math.min(b[i-1]+1, arr[i]);
            }
            for (int i = 0; i < n; i++) {
                ans += arr[i]- b[i];
            }
            System.out.println(ans);

        }
    }
}
