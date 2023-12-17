package com.example.demo.nowcode.N65051;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = (int) 1e9+7;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long[][] cs = new long[32][2];
        for (int i = 0; i < n; i++) {
            int c = arr[i];
            int t = 0;
            while (c>0){
                if(c%2==0){
                    sum = (sum + cs[t][1]*(1L<<t) * (n-i))%MOD;
                    cs[t][0] += (i+1);
                }else {
                    sum = (sum + cs[t][0]*(1L<<t)* (n-i))%MOD;
                    cs[t][1] += (i+1);
                }
                c/=2;
            }

        }
        System.out.println(sum);


    }
}
