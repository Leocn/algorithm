package com.example.demo.codeforces.cf844;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int m1 = sc.nextInt(), m2 = sc.nextInt();
            int d1 = sc.nextInt(), d2 = sc.nextInt();
            int min1 = Math.abs(d1-m1) + Math.min(y-m2 + y-d2, m2+d2);
            int min2= Math.abs(d2-m2) + Math.min(x-m1 + x-d1, m1+d1);
            int ans = z + Math.min(min1, min2);
            System.out.println(ans);
        }
    }
}
