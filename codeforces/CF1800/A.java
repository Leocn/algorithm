package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        out:while (t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            char[] cs = str.toLowerCase().toCharArray();
            StringBuilder sb = new StringBuilder();
            sb.append(cs[0]);
            for (int i = 1; i < n; i++) {
                if(cs[i]!=cs[i-1]){
                    sb.append(cs[i]);
                }
            }
            if(sb.toString().equals("meow")){
                out.println("YES");
            }else {
                out.println("NO");
            }

        }
        out.close();
    }
}
