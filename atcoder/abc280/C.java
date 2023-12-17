package com.example.demo.atcoder.abc280;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tar = sc.next();
        int locA = 0;
        int locB = 0;
        int n = str.length();
        while (locA<n && str.charAt(locA) == tar.charAt(locB)){
            locA++;
            locB++;
        }
        System.out.println(locA+1);

    }
}
