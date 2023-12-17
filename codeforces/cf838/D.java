package com.example.demo.codeforces.cf838;

import java.util.Scanner;

public class D {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int x = 1, y = 2;
            int res = gcd(x,y);
            for (int i = 3; i <= n; i++) {
                int a = gcd(x,i);
                int b = gcd(y,i);
                if(a!=b && Math.min(a,b)>=res){
                    if(a>b){
                        y = i;
                        res = a;
                    }else{
                        x = i;
                        res = b;
                    }
                }
            }
            System.out.println("! " + x+ " " + y);
            System.out.flush();
            int ans = sc.nextInt();

        }
    }
    private static int gcd(int x, int y){
        System.out.println("? " + x + " " + y);
        System.out.flush();
        return sc.nextInt();
    }
}
