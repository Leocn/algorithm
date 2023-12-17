package com.example.demo.codeforces.CF1789;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        out:
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            char[] cs = s.toCharArray();
            int a = 0, b = n-1;
            while (a<b && cs[a] == cs[b]){
                a++;
                b--;
            }
            int c = a;
            if(a>=b){
                System.out.println("YES");
                continue;
            }
            while (a<b && cs[a] != cs[b]){
                a++;
                b--;
            }
            if(a>=b){
                System.out.println("YES");
                continue;
            }
            while (a<b && cs[a] == cs[b]){
                a++;
                b--;
            }
            if(a>=b){
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");

        }
    }

}
