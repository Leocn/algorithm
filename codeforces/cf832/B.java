package com.example.demo.codeforces.cf832;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = (n+1)/2;
            System.out.println(k);
            int loc = 1;
            int r = 3*n;
            while (loc<r){
                System.out.println(loc + " "  + r);
                loc+=3;
                r-=3;
            }
        }
    }
}
