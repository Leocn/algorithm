package com.example.demo.atcoder.abc303;

import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        char[] tar = sc.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if(cs[i] == tar[i]){
                continue;
            }
            if((cs[i]=='l' && tar[i]=='1')|| (tar[i]=='l' && cs[i]=='1') || (tar[i]=='0' && cs[i]=='o') ||(tar[i]=='o' && cs[i]=='0') ){
                continue;
            }
            System.out.println("No");
            return;
        }
        System.out.println("Yes");

    }
}
