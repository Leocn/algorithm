package com.example.demo.codeforces.cgr22;

import java.util.Scanner;

/**
 * TODO
 * */
public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            int countA = 0;
            int countB = 0;
            for (int i = 0; i < n ; i++) {

                arr[i] = sc.nextInt();
                if(arr[i]%2==0){
                    countA++;
                }else {
                    countB++;
                }
            }
            boolean[][][] dp = new boolean[countB+1][countA+1][2];
            for (int i = 0; i <= countA; i++) {
                dp[0][i][0] = true;
            }
            for (int i = 1; i <=countB ; i++) {
                dp[i][0][0] = (i % 4 != 1 && i % 4 != 2);
                dp[i][0][1] = (i % 4 != 3 && i % 4 != 0);
            }
            for (int j = 1; j <=countB; j++) {
                for (int i = 1; i <= countA; i++) {
                    if(j%2==0){
                        //总和为偶数
                        dp[j][i][0] = dp[j-1][i][1] || dp[j][i-1][0];
                        dp[j][i][1] = dp[j-1][i][0] || dp[j][i-1][1];
                    }else{
                        //总和为奇数
//                        if(i%2==0){
//                            dp[j][i][0] = dp[j-1][i][0] || dp[j][i-1][1];
//                            dp[j][i][1] = dp[j-1][i][0] || dp[j][i-1][1];
//                        }else {
                            dp[j][i][0] = dp[j-1][i][0] || dp[j][i-1][1];
                            dp[j][i][1] = dp[j-1][i][0] || dp[j][i-1][1];
//                        }
                    }

                }
            }
            System.out.println(dp[countB][countA][0]?"Alice":"Bob");


        }
    }
}
