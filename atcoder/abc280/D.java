package com.example.demo.atcoder.abc280;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long ans = 0;
        for (int i = 2; (long)i*i <=k ; i++) {
            int cnt = 0;
            while (k%i==0) {
                cnt++;
                k /= i;
            }
            long m = 0;
            while (cnt>0){
                m += i;
                long tem = m;
                while (tem%i == 0){
                    tem /= i;
                    cnt--;
                }
            }
            ans = Math.max(ans, m);

        }
        ans = Math.max(ans, k);

        System.out.println(ans);

    }

}
