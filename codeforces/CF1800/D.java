package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            String str =sc.next();
            char[] cs = str.toCharArray();
            int ans = n-1;

            for (int i = 1; i <n-1 ; i++) {
                if (cs[i-1] == cs[i+1] ){
                    ans--;
                }

            }
            out.println(ans);
        }
        out.close();
    }
}
