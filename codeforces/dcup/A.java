package com.example.demo.codeforces.dcup;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int d = n/k;
            char[] cs = sc.next().toCharArray();
            StringBuilder sb = new StringBuilder();
            int[] ans = new int[26];
            for (int i = 0; i < n; i++) {
                ans[cs[i]-'a'] ++;
            }
            for(int i=0; i<k; i++){

                for(int j =25; j>=0; j--){
                    if(ans[j]>0){
                        char c = (char) ('a' +(j+1));
                        ans[j]--;
                        sb.append(c);
                        break;
                    }
                }
            }
            System.out.println(sb);

        }
    }
}
