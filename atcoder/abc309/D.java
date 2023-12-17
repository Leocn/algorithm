package com.example.demo.atcoder.abc309;

import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] g = new ArrayList[n1+n2+1];
        for (int i = 0; i < n1+n2; i++) {
            g[i+1] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        int cnt = 0;
        boolean[] vis = new boolean[n1+n2+1];
        vis[1] = true;
        while (dq.size()>0){
            int size = dq.size();
            cnt++;
            while (size-->0){
                int p = dq.poll();
                List<Integer> list = g[p];
                for(int l: list){
                    if(vis[l]) continue;
                    dq.add(l);
                    vis[l] = true;
                }
            }
        }
        dq.add(n1+n2);
        vis[n1+n2] = true;
        while (dq.size()>0){
            int size = dq.size();
            cnt++;
            while (size-->0){
                int p = dq.poll();
                List<Integer> list = g[p];
                for(int l: list){
                    if(vis[l]) continue;
                    dq.add(l);
                    vis[l] = true;
                }
            }
        }
        System.out.println(cnt-1);

    }
}
