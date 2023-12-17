package com.example.demo.codeforces.TFR9;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] == 'a'||cs[i] == 'e'||cs[i] == 'i'||cs[i] == 'o'||cs[i] == 'u'){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
