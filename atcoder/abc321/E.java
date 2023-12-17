package com.example.demo.atcoder.abc321;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            long x = sc.nextLong();
            long k = sc.nextLong();
            long ans = 0;
            long tem = x;
            while (x>=1 && k>=0){
                ans += sum(x,n,k);
                if(x!=tem){
                    ans -= sum(tem,n,k-1);
                }

                k--;
                tem = x;
                x/=2;
            }
            System.out.println(ans);
        }



    }
    private static long sum (long x, long max, long k ){
        if(k<0){
            return 0;
        }
        if(k==0){
            return 1;
        }
        long size = 1;
        while (k>0){
            x*=2;
            if(x>max){
                return 0;
            }
            size = size << 1L;
            k--;
        }

        return Math.min(max, size+x-1) - x+1;
    }
}
