package com.example.demo.codeforces.ezf;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d= sc.nextInt();
            double ans = Math.sqrt( Math.pow(c-a,2)  + Math.pow(b+d,2));
            System.out.println(ans);
        }
    }



}
