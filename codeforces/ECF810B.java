package com.example.demo.codeforces;

import java.util.Scanner;

public class ECF810B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            long[] record = new long[n];
            for(int i=0; i<n; i++){
                record[i] = sc.nextLong();
            }
            long[] left = new long[n+1];
            long[] right = new long[n+1];
            for(int i=1; i<n; i++){
                left[i] += left[i-1];
                left[i] += Math.max(0, record[i-1]- record[i]);
            }
            for(int i=n-1; i>0; i--){
                right[i] +=  right[i+1];
                right[i] +=  Math.max(0,  record[i]- record[i-1]);
            }
            while (m>0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(a>b){
                    System.out.println(right[b]- right[a]);
                }else{
                    System.out.println(left[b-1]- left[a-1]);
                }
                m--;
            }
        }

}
