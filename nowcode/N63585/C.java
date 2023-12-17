package com.example.demo.nowcode.N63585;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int a = 1, b = n;
        for (int i = 0; i < n; i++) {
            if(i%2==0){
                sb.append(a++).append(" ");
            }else {
                sb.append(b--).append(" ");
            }
        }
        System.out.println(sb);
    }
}