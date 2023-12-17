package com.example.demo.nowcode.N65157;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int ans = 0;
        int a =0, b = 0;
        for(char c: cs){
            if(c=='a'){
                a++;
            }else {
                b++;
            }
            if(a%10==0) ans++;
            if(a/10 == 0) ans++;
            if(b%10==0) ans++;
            if(b/10 == 0) ans++;
        }
        System.out.println(ans);
    }
}
