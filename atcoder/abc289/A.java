package com.example.demo.atcoder.abc289;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                sb.append('0');
            }else {
                sb.append('1');
            }
        }
        System.out.println(sb);
    }
}
