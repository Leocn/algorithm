package com.example.demo.codeforces.ctr2;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            long n = sc.nextLong();
            long x = sc.nextLong();
            if(n==1){
                long start = sc.nextLong();
                System.out.println(0);
                continue;
            }
            long start = sc.nextLong();
            long max = start;
            long min = start;
            long ans = 0;
            for (int i = 1; i <n ; i++) {
                long a = sc.nextLong();
                max = Math.max(a,max);
                min = Math.min(a,min);
                if(max-min>2*x){
                    ans ++;
                    max = a;
                    min = a;
                }

            }

            System.out.println(ans);

        }
    }
}
