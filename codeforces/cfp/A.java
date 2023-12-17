package com.example.demo.codeforces.cfp;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            int ans = cs[0]-'0';
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <n ; i++) {
                int r = cs[i]-'0';
                if(r==ans){
                    sb.append("-");
                    ans -= r;
                }else{
                    sb.append("+");
                    ans += r;
                }
            }
            System.out.println(sb);
        }
    }
}
