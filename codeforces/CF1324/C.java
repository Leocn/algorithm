package com.example.demo.codeforces.CF1324;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String str = sc.next();
            char[] cs = str.toCharArray();
            int n = str.length() , end = n;
            int ans = 0;
            for (int i = n-1; i >=0; i--) {
                if(cs[i]=='R'){
                    ans = Math.max(ans, end-i);
                    end = i;
                }
            }
            ans = Math.max(ans, end+1);
            System.out.println(ans);

        }
    }
}
