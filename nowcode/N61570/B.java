package com.example.demo.nowcode.N61570;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int ans =Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            int sum = 0;
            for(char c: cs){
                int cnt = c-'a';
                int a = Math.min(Math.abs(cnt -i), Math.abs(i+26-cnt));
                a = Math.min(Math.abs(i-26-cnt) , a);
                sum +=a;
            }
            ans = Math.min(ans, sum);
        }
        System.out.println(ans);
    }
}
