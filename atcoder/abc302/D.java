package com.example.demo.atcoder.abc302;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long d= sc.nextLong();
        PriorityQueue<Long> pq=  new PriorityQueue<>((a,b)->Long.compare(b,a));
        PriorityQueue<Long> pq2=  new PriorityQueue<>((a,b)->Long.compare(b,a));
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextLong());
        }
        for (int i = 0; i < m; i++) {
            pq2.add(sc.nextLong());
        }
        while (pq.size()>0 && pq2.size()>0){
            long a = pq.peek();
            long b = pq2.peek();
            long dif = Math.abs(a-b);
            if(dif<=d){
                System.out.println(a+b);
                return;
            }
            if(a>b){
                pq.poll();
            }else {
                pq2.poll();
            }
        }

        System.out.println(-1);

    }
}
