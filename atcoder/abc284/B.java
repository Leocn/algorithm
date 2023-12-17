package com.example.demo.atcoder.abc284;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int ans = 0;
            while (n-->0){
                int a = sc.nextInt();
                if(a%2!=0){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
