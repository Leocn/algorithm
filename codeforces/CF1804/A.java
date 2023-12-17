package com.example.demo.codeforces.CF1804;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int x = Math.abs(sc.nextInt());
            int y = Math.abs(sc.nextInt());
            int ans = 0;
            int m = Math.max(x,y);
            int min = Math.min(x,y);
            ans = 2*Math.min(x,y);
            if(x!=y){
                ans += (m-min) + (m-min)-1;
            }
            System.out.println(ans);


        }
    }
}
