package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
            long ans = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i] ==0){
                    if(pq.size()>0){
                        ans += pq.poll();
                    }
                }else {
                    pq.add(arr[i]);
                }
            }
            out.println(ans);
        }
        out.close();
    }
}
