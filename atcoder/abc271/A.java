package com.example.demo.atcoder.abc271;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int str = sc.nextInt();
        String ans = Integer.toString(str,16).toUpperCase();
        if(ans.length()==1){
            ans = "0"+ans;
        }
        System.out.println(ans);
    }
}
