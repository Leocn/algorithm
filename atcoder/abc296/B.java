package com.example.demo.atcoder.abc296;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 7; i >=0; i--){
            char[] cs = sc.next().toCharArray();
            for (int j = 7; j >=0; j--) {
                if(cs[j]=='*'){
                    char s = (char)(j+'a');
                    String ans  = ""+s+(i+1);
                    System.out.println(ans);
                    return;
                }
            }
        }
    }
}
