package com.example.demo.atcoder.abc304;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        while (dq.size()>0){
            int q = dq.poll();
            for (int i = 1; i < n; i++) {
                if(p[i]==0){
                    continue;
                }
                int len = (a[i] - a[q])*(a[i] - a[q]) + (b[i]-b[q]) * (b[i]-b[q]);
                if(len<=d*d){
                    p[i] = 0;
                    dq.add(i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(p[i] ==0){
                out.println("Yes");
            }else {
                out.println("No");
            }
        }
        out.close();



    }
}
