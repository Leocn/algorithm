package com.example.demo.atcoder.abc285;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] cs = str.toCharArray();
        for(int i=1; i<n; i++){
            int st = 0;
            while (st+i<n && cs[st]!= cs[st+i]){
                st++;
            }
            System.out.println(st);
        }
    }
}
