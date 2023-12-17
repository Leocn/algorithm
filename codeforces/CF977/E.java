package com.example.demo.codeforces.CF977;

import java.util.*;

/**
 * @Description CF977E
 * @Author Leon
 * @Date 2023/09/28
 */
public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] cnt = new int[n+1];
            ArrayList<Integer>[] g = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                g[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt(), b = sc.nextInt();
                g[a].add(b);
                g[b].add(a);
                cnt[a]++;
                cnt[b]++;
            }
            boolean[] vis = new boolean[n+1];

            int ans = 0;
            for (int i = 1; i<=n; i++) {
                if(vis[i] || cnt[i]!=2){
                    continue;
                }

                Deque<Integer> dq = new ArrayDeque<>();
                dq.add(i);
                vis[i] = true;
                boolean flag = true;
                while (dq.size()>0){
                    int p = dq.poll();

                    for(int next: g[p]){
                        if(vis[next]){
                            continue;
                        }
                        if(cnt[next]!=2){
                            flag = false;
                        }
                        dq.add(next);
                        vis[next] = true;
                    }
                }
                if(flag){
                    ans++;
                }
            }
            System.out.println(ans);
        }
    }
}
