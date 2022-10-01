package com.example.demo.codeforces.ecf133;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if(n==1 ){
                System.out.println(2);
                continue;
            }
            if(n==2){
                System.out.println(1);
                continue;
            }
            int ans = 0;

            ans += n/3;
            n %= 3;
            if(n!=0){
                ans ++;
            }
            System.out.println(ans);
        }
    }
}
