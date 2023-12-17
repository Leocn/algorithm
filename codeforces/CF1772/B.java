package com.example.demo.codeforces.CF1772;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c= sc.nextInt(), d = sc.nextInt();
            if(a<b && c<d && a<c&&b<d){
                System.out.println("YES");
                continue;
            }
            if(c<a && d<b && c<d&&a<b){
                System.out.println("YES");
                continue;
            }

            if(d<c && b<a && d<b&&c<a){
                System.out.println("YES");
                continue;
            }
            if(b<d && a<c && b<a&&d<c){
                System.out.println("YES");
                continue;
            }

            System.out.println("NO");
        }
    }
}
