package com.example.demo.atcoder.abc308;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long[] p = new long[n];
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextLong();
        }
        long[] l =  new long[m];
        long[] d =  new long[m];
        for (int i = 0; i < m; i++) {
            l[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextLong();
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        PriorityQueue<long[]> use = new PriorityQueue<>((a,b)-> Long.compare(b[1], a[1]));
        for (int i = 0; i < m; i++) {
            pq.add(new long[]{l[i], d[i]});
        }
        Arrays.sort(p);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long poll = p[i];
            while (pq.size()>0 && pq.peek()[0]<= poll){
                use.add(pq.poll());
            }
            if(use.size()>0){
                ans += p[i] -  use.poll()[1];
            }else {
                ans += p[i] ;
            }
        }

        System.out.println(ans);


    }
}
