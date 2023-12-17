package com.example.demo.codeforces.CF1799;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n+1];
            int s = n;
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if(set.contains(arr[i])){
                    continue;
                }
                ans[s] = i+1;
                s--;
                set.add(arr[i]);
                if(s==0){
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <=n; i++) {
                if(ans[i]==0){
                    sb.append(-1);
                }else {
                    sb.append(ans[i]);
                }
                sb.append(" ");
            }
            out.println(sb);
        }
        out.close();


    }
}
