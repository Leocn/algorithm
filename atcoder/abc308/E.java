package com.example.demo.atcoder.abc308;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        char[] cs = sc.next().toCharArray();
        long sum = 0;
        // 01 00 02 11 12 22
        long[] dp = new long[6];
        long[][] d = new long[3][3];
        long[] aa = new long[3];
        int[][][] cnt = new int[3][3][3];
        cnt[0][0][0] = 1;
        cnt[0][0][1] = 2;
        cnt[0][0][2] = 1;
        cnt[0][1][0] = 2;
        cnt[0][1][1] = 2;
        cnt[0][1][2] = 3;
        cnt[0][2][0] = 1;
        cnt[0][2][1] = 3;
        cnt[0][2][2] = 1;

        cnt[1][0][0] = 2;
        cnt[1][0][1] = 2;
        cnt[1][0][2] = 3;
        cnt[1][1][0] = 2;
        cnt[1][1][1] = 0;
        cnt[1][1][2] = 0;
        cnt[1][2][0] = 3;
        cnt[1][2][1] = 0;
        cnt[1][2][2] = 0;

        cnt[2][0][0] = 1;
        cnt[2][0][1] = 3;
        cnt[2][0][2] = 1;
        cnt[2][1][0] = 3;
        cnt[2][1][1] = 0;
        cnt[2][1][2] = 0;
        cnt[2][2][0] = 1;
        cnt[2][2][1] = 0;
        cnt[2][2][2] = 0;


        for (int i = 0; i < n; i++) {
            if(cs[i]=='M'){
               aa[arr[i]]++;
            }else if(cs[i]=='E'){
                for (int j = 0; j < 3; j++) {
                    d[j][arr[i]] += aa[j];
                }
                
            }else {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        sum +=  d[j][k]* cnt[j][k][arr[i]];
                    }
                }
            }
        }
        System.out.println(sum);


    }
}
