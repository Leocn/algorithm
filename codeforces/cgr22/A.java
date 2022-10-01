package com.example.demo.codeforces.cgr22;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int i = 0; i < n ; i++) {
                arr[i] = sc.nextInt();
            }
            int locA = 0;
            int locB = 0;
            Long[] deA = new Long[n];
            Arrays.fill(deA,0l);
            Long[] deB = new Long[n];
            Arrays.fill(deB,0l);
            for (int i = 0; i < n; i++) {
                if(arr[i]==1){
                    deA[locA++] = sc.nextLong();
                }else {
                    deB[locB++] = sc.nextLong();
                }
            }
            Arrays.sort(deA, (a, b) -> Long.compare(b, a));
            Arrays.sort(deB, (a, b) -> Long.compare(b, a));
            long ans= 0;
            if(locA==locB){
                for (int i = 0; i < locA; i++) {
                    ans += 2*(deA[i]+deB[i]);
                }
                ans = Math.max(ans- deA[locA-1] , ans-deB[locA-1]);
            }else if(locA>locB){
                for (int i = 0; i < locB; i++) {
                    ans += 2*(deA[i]+deB[i]);
                }
                for (int i = locB; i < locA; i++) {
                    ans += deA[i];
                }
            }else {
                for (int i = 0; i < locA; i++) {
                    ans += 2*(deA[i]+deB[i]);
                }
                for (int i = locA; i < locB; i++) {
                    ans += deB[i];
                }
            }
            System.out.println(ans);
        }
    }
}
