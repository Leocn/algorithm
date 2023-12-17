package com.example.demo.nowcode.N64593;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    static int MOD = (int)1e9+7;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int[][] g = new int[n][k];
        if(k==n){
            System.out.println(1);
            return;
        }
        if(k==n-1){
            System.out.println(n);
            return;
        }
        long ans = 0;

        k = n-k;
//        for (int i = 1; i < n; i++) {
//
//            for (int j = 0; j < i; j++) {
//                if(arr[i]%arr[j] == 0){
//                    int d = arr[i]/arr[j];
//                    g[i] += g[j]+1;
//                    if(g[i]+1>=k){
//                        int sum = g[i]+1;
//                        ans = (ans + C(sum-2, k-2))%MOD;
//                    }
//                }
//
//            }
//        }
        System.out.println(ans);
    }
    private static int C(int sum, int k){
        if(k==0) return 1;
        BigInteger b = new BigInteger("1");
        BigInteger h = new BigInteger("1");
        for (int i = 1; i <=k ; i++) {
            b = b.multiply(new BigInteger(i+""));
            h = h.multiply(new BigInteger((sum-i+1)+""));

        }
        h = h.divide(b).mod(new BigInteger(MOD+""));
        return h.intValue();
    }
}
