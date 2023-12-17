package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class M {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] cnt = new long[1000001];
        for (int i = 0; i < n; i++) {
            cnt[sc.nextInt()] ++;
        }
        long sum = ((long)(n-1))*(n)/2;
        for (int i = 0; i <=1000000; i++) {
            if(cnt[i]>1){
                sum -= cnt[i]*(cnt[i]-1)/2;
            }
        }
        System.out.println(sum);
    }
}
