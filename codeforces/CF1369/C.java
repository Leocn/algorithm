package com.example.demo.codeforces.CF1369;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), k = sc.nextInt();
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Integer[] w = new Integer[k];
            for (int i = 0; i < k; i++) {
                w[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            Arrays.sort(w);
            int loc = n-1;
            long sum = 0;
            for (int i = 0; i <k ; i++) {
                w[i]--;
                long add = arr[loc--];
                sum += add;
                if(w[i]==0){
                    sum += add;
                }
            }
            loc = 0;
            for (int i = k-1; i >=0 ; i--) {
                if(w[i]>0){
                    sum += arr[loc];
                    loc+= w[i];
                }
            }
            System.out.println(sum);
        }
    }
}
