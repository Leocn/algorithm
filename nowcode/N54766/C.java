package com.example.demo.nowcode.N54766;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            char[] cs = sc.next().toCharArray();
            Set<Character> set = new HashSet<>();
            int ans = 0;
            for(char c: cs){
                if(set.contains(c)){
                    ans++;
                }else {
                    ans+=2;
                }
                set.add(c);
            }
            System.out.println(ans);
        }
    }
}
