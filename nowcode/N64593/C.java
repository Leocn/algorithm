package com.example.demo.nowcode.N64593;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int n = cs.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            if(cs[i]-'0'==0){
                a++;
            }
            for (int j = i+1; j <n ; j++) {
                if((j-i)%2==0){
                    if(cs[j]-'0'==0){
                        a++;
                    }
                }else {
                    if(cs[j]-'0'==0){
                        b++;
                    }
                }
                int cntA = (j-i+1)/2+(j-i+1)%2;
                int cntB = (j-i+1)/2;
                ans += Math.min(Math.abs(cntA - a) + b, Math.abs(cntB-b) + a);
            }
        }
        System.out.println(ans);
    }
}
