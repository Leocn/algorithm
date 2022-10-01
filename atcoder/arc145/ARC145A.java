package com.example.demo.atcoder.arc145;

import java.util.Scanner;

public class ARC145A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n =scanner.nextInt();
        String s = scanner.next();
        char[] cs = s.toCharArray();
        if(n==2 &&s.equals("BA")){
            System.out.println("No");
            return;
        }
        if(cs[n-1]=='B' && cs[0]=='A'){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");

    }
}
