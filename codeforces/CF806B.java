package com.example.demo.codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CF806B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            Set<Character> set = new HashSet<>();
            int x = sc.nextInt();
            String str = sc.next();
            int start = 0;
            int ans = 0;
            while(start<x){
                if(set.contains(str.charAt(start))){
                    ans ++;
                }else{
                    set.add(str.charAt(start));
                    ans += 2;
                }
                start++;
            }
            System.out.println(ans);

        }
    }
}
