package com.example.demo.nowcode.N63585;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] w = new long[n+1];
        long[][] cnt = new long[n+1][2];
        boolean[] has = new boolean[n+1];
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }
        dfs(1, cnt, has, g, w);
        System.out.println (Math.max(cnt[1][0] , cnt[1][1]));

    }

    private static void dfs(int p, long[][] cnt, boolean[] has, ArrayList<Integer>[] g, long[] w){
        has[p] = true;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for(int c: g[p]){
            if(has[c]) continue;
            dfs(c, cnt, has, g, w);
            list.add(c);
            cnt[p][0] += Math.max(cnt[c][0] , cnt[c][1]);

        }
        sum = cnt[p][0];
        cnt[p][1] = cnt[p][0];
        for(int c: list){
            long q = (long) Math.sqrt(w[c] * w[p]);
            if(q*q == w[c] * w[p]){
                long d = sum - Math.max(cnt[c][0] , cnt[c][1]);
                cnt[p][1] = Math.max(cnt[p][1], d + cnt[c][0] + 2);
            }
        }
    }
}
