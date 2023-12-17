package com.example.demo.codeforces.cf627;

import com.example.demo.nowcode.I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class F {
    static int[] arr;
    static List[] g;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr  =new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = sc.nextInt();
        }
        g = new List[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        ans = new int[n+1];
        dfs(1, -1);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <=n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println( sb);
    }

    private static int dfs(int now, int from){
        int x = arr[now]==0?1:-1;
        List<Integer> list = g[now];
        ans[now] = x;
        int ret = x;
        for(int l: list){
            if(l==from){
                continue;
            }
            int res = dfs(l, now);
            if(res>0){
                ans[now] += res;
            }
            ret = Math.max(res+x, ret);
        }

        return Math.max(0, ret);


    }
}
