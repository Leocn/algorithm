package com.example.demo.atcoder.abc297;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cs = sc.next().toCharArray();
        int a = -1 , b = 0;
        int c = -1, d= 0;
        int f = 0;
        for (int i = 0; i < 8; i++) {
            if(cs[i]=='B' && a==-1){
                a = i;
            }else if(cs[i]=='B') {
                b = i;
            }
            if(cs[i]=='K'){
                f = i;
            }
            if(cs[i]=='R' && c==-1){
                c = i;
            }else if(cs[i] == 'R'){
                d= i;
            }


        }
        if(a%2==b%2){
            System.out.println("No");
            return;
        }
        if(f<c || f>d){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");
    }
}
