package com.example.demo.nowcode.N61570;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n =  sc.nextInt(), m = sc.nextInt();
        long a = sc.nextInt(), b = sc.nextInt();
        long ans = 0;
        for (int i = 0; i*2 <=n && i<=m ; i++) {
            long sum = a*i;
            sum += b* Math.min( n- 2*i, (m-i)/2  );
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
