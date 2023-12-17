package com.example.demo.codeforces.CF1793;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            long x = sc.nextInt();
            long y = sc.nextInt();
            long ans = x-y;
            List<Long> pre = new ArrayList<>();
            List<Long> suf = new ArrayList<>();
            suf.add(y);
            while (y<x-1){
                pre.add(y+1);
                suf.add(y+1);
                y++;
            }
            suf.add(x);
            Collections.reverse(pre);
            StringBuilder sb = new StringBuilder();
            out.println(pre.size()+suf.size());
            for(Long l: pre){
                sb.append(l).append(" ");
            }
            for(Long l: suf){
                sb.append(l).append(" ");
            }
            out.println(sb);

        }
        out.close();
    }
}
