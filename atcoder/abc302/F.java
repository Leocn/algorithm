package com.example.demo.atcoder.abc302;

import java.io.PrintWriter;
import java.util.*;

public class F {
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        List<Integer>[] arr = new List[n+1];
        List<Integer>[] tar = new List[m+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 1; i <=m ; i++) {
            tar[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            for (int j = 0; j < x; j++) {
                int next = sc.nextInt();
                arr[i+1].add(next);
                tar[next].add(i+1);
            }
        }
        int ans = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        boolean[] vis = new boolean[m+1];
        vis[1] = true;
        while (dq.size()>0){
            int s = dq.size();
            ans++;
            while (s-->0){
                int p = dq.poll();
                for(int next : tar[p]){
                    for(int mm: arr[next]){
                        if(vis[mm]){
                            continue;
                        }
                        if(mm==m){
                            System.out.println(ans-1);
                            return;
                        }
                        vis[mm] = true;
                        dq.add(mm);

                    }

                }
            }
        }
        System.out.println(-1);


    }
}
