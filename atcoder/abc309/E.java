package com.example.demo.atcoder.abc309;

import java.util.*;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            g[i+1] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            g[a].add(i+2);
        }

        int[] cnt = new int[n+1];
        for (int i = 0; i < m; i++) {
            int x= sc.nextInt();
            int y= sc.nextInt();
            cnt[x] = Math.max(cnt[x], y);
        }
        PriorityQueue<int[]> dq= new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        int[] vis = new int[n+1];
        Arrays.fill(vis, -1);
        for (int i = 1; i <=n; i++) {
            if(cnt[i]>0) {
                dq.add(new int[]{i, cnt[i]});
            }
        }
        int ans = 0;
        while (dq.size()>0){
            int[] p = dq.poll();
            if(p[1]<=vis[p[0]]) continue;
            if(vis[p[0]]==-1){ ans++;}
            vis[p[0]] = p[1];
            if(p[1] == 0) continue;
            List<Integer> list = g[p[0]];
            for(int l: list){
                int mx = Math.max(cnt[l], p[1]-1 );
                dq.add(new int[]{l,mx});
            }

        }
        System.out.println(ans);

    }
}
