package com.example.demo.codeforces.CF1711;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            int[] ans = new int[n];
            for (int i = 1; i <=n ; i++) {
                ans[i-1]= i;
            }
            for (int i = 0; i < n-1; i+=2) {
                int tem = ans[i];
                ans[i] = ans[i+1];
                ans[i+1] = tem;
            }
            if(ans[n-1] == n){
                ans[0] = n;
                ans[n-1] = Math.min(2, n);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
