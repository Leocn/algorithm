package com.example.demo.atcoder.abc280;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char[] cs = arr[i].toCharArray();
            for (int j = 0; j < cs.length; j++) {
                if(cs[j] == '#'){
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }
}
