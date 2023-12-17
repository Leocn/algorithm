package com.example.demo.codeforces.CF1795;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            StringBuilder sb = new StringBuilder(b);
            sb.reverse();
            sb = new StringBuilder(a).append(sb);
            String s = sb.toString();
            int ans = 0;
            for(int i=0; i<n+m-1;i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    ans ++;
                }
            }
            if(ans>1){
                out.println("NO");
            }else {
                out.println("YES");
            }

        }
        out.close();
    }
}
