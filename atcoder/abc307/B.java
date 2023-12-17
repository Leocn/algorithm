package com.example.demo.atcoder.abc307;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                if(valid(str[i]+str[j])){
                    System.out.println("Yes");
                    return;
                }
                if(valid(str[j]+str[i])){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");

    }
    static boolean  valid(String word){
        int l = 0;
        int r = word.length()-1;
        while (l<r){
            if(word.charAt(l) != word.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
