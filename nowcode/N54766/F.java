package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt(), m = sc.nextInt();
        int ans = 0;
        for (int i = 1; i*x <=m;  i++) {
            for (int j = 1; j*y <= m-i*x ; j++) {
                ans = Math.max(i*x+ j*y,ans);
            }
        }
        System.out.println(ans);
    }
}
