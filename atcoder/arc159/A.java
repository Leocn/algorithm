package com.example.demo.atcoder.arc159;

import java.io.PrintWriter;
import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt(), k = sc.nextInt();
        List[] arr = new List[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        int[][] re = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int d  = sc.nextInt();
                if(d==1){
                    arr[i].add(j);
                }
                re[i][j] = d;
            }
        }
        int q = sc.nextInt();
        out:while (q-->0){
            long from = sc.nextLong()-1;
            long to = sc.nextLong()-1;
            int cnt =0;

            from = from%n;
            to = to%n;

            Deque<Integer> dq = new ArrayDeque<>();
            dq.add((int)from);
            boolean[] vis = new boolean[n];
            int ans = -1;
            while (dq.size()>0){
                int s = dq.size();
                cnt++;
                while (s-->0){
                    int p = dq.poll();
                    List<Integer> list = arr[p];
                    for(int next:list){
                        if(vis[next] ){
                            continue;
                        }
                        if(next==to){
                            out.println(cnt);
                            continue out;
                        }
                        dq.add(next);
                        vis[next] = true;
                    }
                }
            }
            out.println(-1);

        }
        out.close();
    }
}
