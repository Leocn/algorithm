package com.example.demo.codeforces.CF1814;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong(), k = sc.nextLong();
            if((n&1)==0){
                System.out.println("YES");
            }else {
                if((k&1)==1){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

}
