package com.example.demo.codeforces.TFR9;

import java.util.Scanner;

public class H {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = "TheForces rounds are the best rounds ever.".toCharArray();
        int n = sc.nextInt();
        int ans = cs[n-1]-'0'+48;
        System.out.println(ans);
    }
}
