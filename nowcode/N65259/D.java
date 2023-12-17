package com.example.demo.nowcode.N65259;

import java.util.PriorityQueue;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();
        int[] a = new int[n];
        int[] k = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + a[i];
        }
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((f,b)->f[0]-b[0]);
        for (int i = 0; i < n; i++) {
            int l = i, r = n;
            long s = (long) k[i] * c[i];
            while (l<r){
                int mid = l+r>>1;
                if(sum[mid+1]-sum[i]<=s){
                    l = mid+1;
                }else {
                    r = mid;
                }
            }
            pq.add(new int[]{l-1-i+1, i});
            max = Math.max(l-1-i+1,max);
        }
        int ans = max- pq.peek()[0];
        for (int i = 0; i < m; i++) {
            int[] p = pq.poll();
            int l = i, r = n;
            c[p[1]]++;
            long s = (long) k[p[1]] * c[p[1]];
            while (l<r){
                int mid = l+r>>1;
                if(sum[mid+1]-sum[i]<=s){
                    l = mid+1;
                }else {
                    r = mid;
                }
            }

            max = Math.max(l-1-i+1,max);
            pq.add(new int[]{l-1-i+1, p[1]});
            ans = Math.min(ans, max- pq.peek()[0]);

        }
        System.out.println(ans);


    }
}
