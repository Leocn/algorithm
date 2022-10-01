package com.example.demo.codeforces.cf814;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            if((n%2==0 && m%2==0)||(n%2==1 && m%2==1) ){
                System.out.println("Tonya");
            }else{
                System.out.println("Burenka");
            }
        }
    }
}
