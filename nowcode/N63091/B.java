package com.example.demo.nowcode.N63091;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        long a = 0 , b = 0;

        for (int i = 0; i < cs.length; i++) {
            if(cs[i]=='0'){
                long tem = a;
                a = b;
                b = tem+(i+1);
            }else {
                long tem = b;
                b = a;
                a = tem +(i+1);
            }
        }
        System.out.println(Math.min(a,b));
    }
}
