package com.example.demo.codeforces.CF1758;

import java.util.Scanner;

public class C{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt(), x= sc.nextInt();
            int[] ans = new int[n];
            ans[0] = x;
            ans[n-1] = 1;
            if(n%x!=0){
                System.out.println(-1);
                continue;
            }
            for (int i = 1; i < n-1; i++) {
                ans[i] = i+1;
            }
            while (x<n){
                for (int i = 2*x; i <=n ; i+=x) {
                    if(n%i==0){
                        ans[x-1] = i;
                        x= i;
                        break;
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);

        }
    }
}
