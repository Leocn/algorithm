package com.example.demo.codeforces.ctr2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();

            String a = sc.next();
            String b = sc.next();
            if(n==m){
                if(a.equals(b)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
                continue;
            }
            if(!b.substring(1).equals(a.substring(n-m+1))){
                System.out.println("NO");
                continue;
            }

            String sub = a.substring(0, n-m+1);
            if(sub.contains(b.substring(0,1))){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }


    }
}
