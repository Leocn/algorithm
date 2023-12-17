package com.example.demo.atcoder.abc309;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long sum = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pq.add(new int[]{a,b});
            sum += b;
        }
        int ans = 0;
        while (sum>k && pq.size()>0 ){
            int[] p = pq.poll();
            ans = p[0];
            sum -= p[1];
        }
        System.out.println(ans+1);

    }
}
