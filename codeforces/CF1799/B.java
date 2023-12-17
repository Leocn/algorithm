package com.example.demo.codeforces.CF1799;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n+1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            List<String> list = new ArrayList<String>();
            int min = Integer.MAX_VALUE, loc = 0;
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
                pq.add(new int[]{arr[i], i});
                if(arr[i]<min){
                    min = arr[i];
                    loc = i;
                }
            }
            int cnt = 0;
            while (cnt <=30*n && pq.size()>1){
                int[] p = pq.poll();
                if(p[0] == min){
                    break;
                }
                list.add( p[1]  + " " + loc);
                int c = (int) Math.ceil((double) p[0]/min);
                if(c<min){
                    loc = p[1];
                    min = c;
                }
                pq.add(new int[]{c, p[1]});
                cnt++;

            }
            if(cnt>=30*n){
                out.println(-1);
                continue;
            }
            out.println(list.size());
            for(String s: list){
                out.println(s);
            }
        }
        out.close();
    }
}
