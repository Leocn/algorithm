package com.example.demo.nowcode.N61570;

import java.math.BigInteger;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MOD = (int)1E9+7;
        long n =  sc.nextInt();
        long sum = 2L *n + 2L *(n-2);
        BigInteger bg = BigInteger.valueOf(sum);
        BigInteger bg1 = bg.add(BigInteger.ONE);
        long ans =   ((n*n+1)%MOD*n%MOD*n%MOD*2%MOD - bg.multiply(bg1).divide(BigInteger.valueOf(2)).mod(BigInteger.valueOf(MOD)).intValue()  - 10 + MOD)%MOD;
        System.out.println(ans);

    }
}
