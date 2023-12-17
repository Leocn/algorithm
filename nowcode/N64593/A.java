package com.example.demo.nowcode.N64593;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        while (q-->0){
            int m = sc.nextInt(), x = sc.nextInt();
            int ans = x%m;
            if(ans ==0) ans = m;
            System.out.println(ans);
        }
    }
}
