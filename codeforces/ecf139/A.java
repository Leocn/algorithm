package com.example.demo.codeforces.ecf139;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int ans = 0;
            while (n>10){
                n/=10;
                ans += 9;
            }
            System.out.println(ans+n);
        }
    }
}
