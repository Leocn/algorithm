package com.example.demo.nowcode.N64272;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double v =sc.nextInt();
        double x = sc.nextInt(), y = sc.nextInt();
        double left = 0, right = 1e9;
        double mid = 0;
        for (int i = 0; i < 64; i++) {
            mid = (left+right)/2;
            double d= 1- (x/ Math.pow(v+mid*x,2) * y);
            if(d>0){
                right = mid;
            }else {
                left = mid;
            }
        }
        double ans = mid + y/(v+mid*x);
        System.out.println(ans);

    }
}
