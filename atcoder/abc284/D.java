package com.example.demo.atcoder.abc284;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            long p = 0, q = 0;
            for (long i = 2; i * i * i <= n; i++) {
                if (n % i != 0) continue;
                if ((n / i) % i == 0) {
                    p = i;
                    q = n / i / i;
                } else {
                    q = i;
                    p = (long) Math.sqrt(n / i);
                }
                break;
            }
            System.out.println(p + " "+ q);

        }
    }


}
