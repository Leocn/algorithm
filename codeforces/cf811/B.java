package com.example.demo.codeforces.cf811;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] s = new int[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            int ans = 0;
            for (int i = n-1; i >=0 ; i--) {
                if(set.contains(s[i])){
                    ans = i+1;
                    break;
                }
                set.add(s[i]);
            }
            System.out.println(ans);
        }
    }
}
