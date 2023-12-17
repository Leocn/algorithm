package com.example.demo.atcoder.abc301;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        long tar = sc.nextLong();
        long ans = 0;
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if(cs[i]=='1'){
                ans |= (1L <<(n-i-1));
            }
        }
        if(ans>tar){
            System.out.println(-1);
            return;
        }


        for (int i = 0; i < n; i++) {
            if(cs[i]=='?'){
                ans|= (1L <<(n-i-1));
                if(ans>tar){
                    ans -= (1L <<(n-i-1));
                }
            }
        }
        System.out.println(ans);

    }
}
