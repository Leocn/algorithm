package com.example.demo.codeforces.CF1368;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long st = 1;
        while (Math.pow(st,10)<k){
            st++;
        }
        long f = (long)Math.pow(st, 10);
        long[] cnt = new long[10];
        Arrays.fill(cnt, st);
        int s = 0;
        while (f/st*(st-1)>=k){
            cnt[s++] = st-1;
            f/=st;
            f*=st-1;
        }
        StringBuilder sb = new StringBuilder();
        String str = "codeforces";
        for (int i = 0; i < 10; i++) {
            sb.append((str.charAt(i)+"").repeat((int)cnt[i]));
        }
        System.out.println(sb);


    }
}
