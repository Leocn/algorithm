package com.example.demo.nowcode.N55352;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        int n = cs.length;
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        int c= 0, d= 0;
        for (int i = n-1; i >=0 ; i--) {
            if(((n-1-i)&1)==0){
                a.append(cs[i]);
                c+=cs[i]-'0';
            }else {
                b.append(cs[i]);
                d+=cs[i]-'0';
            }
        }
        System.out.println(a);
        if(d>0){
            System.out.println(b);
        }else {
            System.out.println(0);
        }


    }
}
