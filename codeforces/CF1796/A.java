package com.example.demo.codeforces.CF1796;

import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        String ans = "FBFFBFFBFBFFBFFBFBFFBFFB";
        while (t-->0){
            int n = sc.nextInt();
            String str = sc.next();
            if(ans.contains(str)){
                out.println("YES");
            }else {
                out.println("NO");
            }
        }
        out.close();
    }
}
