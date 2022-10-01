package com.example.demo.codeforces.cf811;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int H = sc.nextInt();
            int M = sc.nextInt();
            int start = H*60+M;
            int min = Integer.MAX_VALUE;
            while (n>0){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int end = a*60+b;
                if(end<start){
                    end+= 24*60;
                }

                int ans = end- start;
                min = Math.min(ans, min);
                n--;
            }

            System.out.println(min/60+" "+min%60);


        }
    }
}
