package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = (int) 1e9+7;
        int n = sc.nextInt(), d1 = sc.nextInt(), d2 = sc.nextInt();
        long[] sum = new long[3000];
        long[] s = new long[3000];
        long ans = 1;
        sum[d1] ++;
        s[d2]--;
        long spred = 0;
        for (int i = 0; i < n; i++) {
            spred += sum[ i] + s[ i];
            spred %= MOD;

            sum[i+d1] += spred;
            sum[i+d1] %= MOD;

            s[i+d2] -= spred;
            s[i+d2] %= MOD;

            ans += spred;
            ans%= MOD;

            ans += s[i];
            ans%= MOD;
        }
        System.out.println(ans);

    }
}
