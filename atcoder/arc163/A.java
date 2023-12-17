package com.example.demo.atcoder.arc163;

import java.util.Scanner;

public class A {
    static Scanner sc;
    public static void main(String[] args) {
       sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            solve();
        }
    }
    private static void solve(){

        int n = sc.nextInt();
        String str = sc.next();
        char[] cs = str.toCharArray();
        for (int i =1 ; i <n ; i++) {
            if(cs[i]>cs[0]){
                System.out.println("Yes");
                return;
            }else if(cs[i] == cs[0]){
                if(str.substring(0,i).compareTo(str.substring(i,n))<0){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
}
