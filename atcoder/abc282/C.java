package com.example.demo.atcoder.abc282;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        char[] cs = sc.next().toCharArray();
        boolean flag = true;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(flag && cs[i]==','){
                cs[i] ='.';
            }
            if(cs[i]=='\"'){
                cnt++;
            }
            if(cnt %2==1){
                flag = false;
            }
            if(cnt%2==0){
                flag = true;
            }
        }
        System.out.println(new String(cs));
    }
}
