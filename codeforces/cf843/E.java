package com.example.demo.codeforces.cf843;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            long s1 = 0, s2 = 0;
            while (n-->0){
                int x = sc.nextInt();
                if(x>0){
                    s2 += x;
                    s1 = Math.max(0, s1-x);
                }else if(x<0){
                    s1 -= x;
                    s2 = Math.max(0, s2+x);
                }
                System.out.println(s1 + " "  +s2);
            }
            System.out.println(s1+s2);
        }
    }
}
