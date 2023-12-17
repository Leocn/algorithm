package com.example.demo.codeforces.cf847;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String n = sc.next();
            String p = "3141592653589793238462643383279";
            int s = n.length();
            for (int i = 0; i < s; i++) {
                if(n.charAt(i)!=p.charAt(i)){
                    s = i;
                    break;
                }
            }
            System.out.println(s);

        }
    }
}
