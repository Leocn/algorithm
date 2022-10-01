package com.example.demo.codeforces.ecf133;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            System.out.println(n);
            StringBuilder sb = new StringBuilder();
            int[] ans = new int[n];
            for(int i=0;i<n;i++){
                ans[i] = i+1;
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            for (int i = 1; i < n; i++) {
                int tem = ans[n-i];
                ans[n-i] = ans[n-i-1];
                ans[n-i-1] = tem;
                for (int j = 0; j < n; j++) {
                    sb.append(ans[j]).append(" ");
                }
                sb.append("\n");

            }
            System.out.println(sb);
        }
    }
}
