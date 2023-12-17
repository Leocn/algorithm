package com.example.demo.atcoder.abc283;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] cs = str.toCharArray();
        int n = cs.length;
        int ans = 0;
        for(int i =0; i<n; i++){
            if(cs[i]=='0' && i+1<n && cs[i+1] == '0'){
                i++;
            }
            ans ++;
        }
        System.out.println(ans);

    }
}
