package com.example.demo.codeforces.CF1796;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        out:while (t-->0){
            String a = sc.next();
            String b = sc.next();
            int n = a.length(), m = b.length();
            if(a.charAt(0)==b.charAt(0)){
                out.println("YES");
                out.println( a.charAt(0) + "*");
                continue;
            }
            if(a.charAt(n-1) == b.charAt(m-1)){
                out.println("YES");
                out.println(   "*" +a.charAt(n-1));
                continue;
            }
            for (int i = 0; i < n-1; i++) {
                for (int j = 0; j < m-1; j++) {
                    if(a.charAt(i) == b.charAt(j) && a.charAt(i+1) == b.charAt(j+1)){
                        out.println("YES");
                        out.println("*" + a.charAt(i)+a.charAt(i+1) + "*" );
                        continue out;
                    }
                }

            }
            out.println("NO");

        }
        out.close();
    }
}
