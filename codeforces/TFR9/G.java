package com.example.demo.codeforces.TFR9;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=2023 ; i++) {
            sb.append(i);
        }
        System.out.println(sb.charAt(n-1));
    }
}
