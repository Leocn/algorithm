package com.example.demo.codeforces.CF1328;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int st = 1;
            while (k>st){
                k-=st;
                st++;
            }

            char[] cs = new char[n];
            Arrays.fill(cs,'a');

            cs[n-st-1] = 'b';
            cs[n-k] = 'b';
            System.out.println(new String(cs));
        }
    }
}
