package com.example.demo.codeforces;

import java.util.Scanner;

/**
 *
 * 如果第一次用bad key 则后续都用bad key
 * bad key最多用Math.min(n, i+31) 次
 * */
public class CF806G {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            long k = sc.nextInt();;
            long[] array = new long[n+1];
            for(int i=1; i<=n; i++){
                array[i] = sc.nextLong();
            }
            long[] pre = new long[n+1];
            for(int i=1; i<=n; i++){
                pre[i] = pre[i-1] + array[i];
            }
            long ans = Math.max(0, pre[n] -  n *k);
            for(int i=0; i<n; i++){
                long cur =0;
                long d = 2;
                for(int j=i+1; j<=Math.min(n, i+32); j++){
                    cur += array[j]/d;
                    d *= 2;
                }
                ans = Math.max(ans, pre[i]+ cur -  i *k);
            }

            System.out.println(ans);
        }
    }
}
