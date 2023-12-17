package com.example.demo.GCJ;

import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int k = 1; k <= t; k++) {
            char[] cs = sc.next().toCharArray();
            int n = cs.length;
            int ans = 0;
            boolean[] vis = new boolean[n];
            for (int i = 0; i < n+1; i++) {
                if(cs[i%n] == cs[(i -1+n)%n]){
                    i++;
                    ans++;
                }
            }
            System.out.println("Case #"+k+": "+ans);
        }

    }
}
