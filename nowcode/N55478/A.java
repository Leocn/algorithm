package com.example.demo.nowcode.N55478;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int a = sc.nextInt(), b = sc.nextInt(),c = sc.nextInt();
            System.out.println(f(a,b,c));
        }

    }
    public static int f(int l,int r,int x) { // l <= x <= r
        int cnt = 0;
        while(l <= r) {
            cnt++;
            int mid = (l + r) / 2;
            if (mid == x) break;
            if (mid < x) l = mid + 1;
            else r = mid - 1;
        }
        return cnt;
    }

}
