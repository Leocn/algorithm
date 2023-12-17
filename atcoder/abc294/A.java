package com.example.demo.atcoder.abc294;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            if(s%2==0){
                sb.append(s).append(" ");
            }
        }
        System.out.println(sb);

    }
}
