package com.example.demo.codeforces;

import java.util.Scanner;

public class CF805A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int x = scanner.nextInt();
            String s = x+"";
            int l = s.length();
            int m = (int) Math.pow(10, l-1);
            System.out.println(x-m);
        }

    }
}
