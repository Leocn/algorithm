package com.example.demo.atcoder.abc282;

import java.util.*;

public class E {
    static int[] par;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        long m  = sc.nextLong();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(b[2],a[2]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <i ; j++) {
                long p = (power(arr[i],arr[j], m) + power(arr[j],arr[i], m))%m;
                pq.add(new long[]{i,j,p});
            }
        }

        long ans = 0;
        while (n>1){
            long[] p = pq.poll();
            int par1 = getP((int) p[0]);
            int par2 = getP((int) p[1]);
            if(par2 == par1){
                continue;
            }
            ans += p[2];
            par[par1] = par2;
            n--;
        }
        System.out.println(ans);

    }
    public static long power(long x, long y, long mod) {
        long t = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                y -= 1;
                t = t*x%mod;
            } else {
                y /= 2;
                x = x*x%mod;
            }
        }
        return t%mod;
    }

    private static int getP(int x){
        if(par[x]!=x){
            return getP(par[x]);
        }
        return x;
    }


}
