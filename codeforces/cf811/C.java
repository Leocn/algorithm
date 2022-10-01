package com.example.demo.codeforces.cf811;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long ans =0;
            int start = 9;
            long i = 1;
            while(n>=start && start!=0){
                ans += start*i;
                n -= start;
                start--;
                i *=10;
            }
            if(n>0){
                ans += n*i;
            }
            System.out.println(ans);
        }
    }
}
