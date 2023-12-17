package com.example.demo.nowcode.N55352;

import java.util.Arrays;
import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        double[][] dp = new double[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[i];
        }
        double[] ans = new double[n];
        Arrays.fill(ans, 1);
        int cnt  = 1;
        while (cnt<n){
            double[] tem = new double[n];
            for (int i = 0; i < n; i+=2*cnt) {
                for (int k = i; k <i+2*cnt ; k++) {
                    int w = k%(2*cnt)<cnt?0:1;
                    w^=1;
                    double s = 0;
                    for (int j = i+w*cnt; j <i+(w+1)*cnt ; j++) {


                        s+= ans[j] *arr[k] /(arr[k] +arr[j]);


                    }
                    tem[k] = ans[k] * s;
                }


            }
            ans = tem;
            cnt*=2;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }


    }
}
