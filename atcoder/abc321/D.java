package com.example.demo.atcoder.abc321;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long p = sc.nextInt();
        long[] a = new long[n];
        long[] b = new long[m];
        for (int i = 0; i < n; i++) {
            a[i]= sc.nextInt();
        }
        PriorityQueue<Long> pq = new PriorityQueue<>((h,c)->Long.compare(c,h));
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            pq.add(b[i]);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        long[] sum = new long[m+1];
        for (int i = 0; i < m; i++) {
            sum[i+1] = sum[i] + b[i];
        }
        long ans = 0;

        for (int i = 0; i < n; i++) {
            long d = a[i];
            while (pq.size()>0 &&pq.peek()+d>=p){
                pq.poll();
            }
            int size = pq.size();
            ans += sum[size] + size*d + (m-size)* p;
        }
        System.out.println(ans);

    }
}
