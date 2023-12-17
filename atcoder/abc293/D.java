package com.example.demo.atcoder.abc293;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][][]  arr = new int[n+1][2][];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int from = sc.next().equals("R")?0:1;
            int y = sc.nextInt();
            int to = sc.next().equals("R")?0:1;
            arr[x][from] = new int[]{y, to};
            arr[y][to] = new int[]{x, from};
        }

        int ans1 = 0, ans2 = 0;
        boolean[] vis = new boolean[n+1];
        out: for (int i = 1; i <= n; i++) {
            if(vis[i]){
                continue ;
            }
            Deque<int[]> dq = new ArrayDeque<>();
            dq.add(new int[]{i, 0});
            dq.add(new int[]{i, 1});

            while (dq.size()>0){
                int[] p = dq.poll();
                vis[p[0]] = true;
                int x = p[0], loc = p[1];
                int[] next = arr[x][loc];
                if(next==null){
                    continue;
                }
                if(vis[next[0]]){
                    ans1++;
                    continue out;
                }
                dq.add(new int[]{next[0], next[1]^1});
            }
            ans2++;
        }
        System.out.println(ans1 + " " + ans2) ;
    }
}
