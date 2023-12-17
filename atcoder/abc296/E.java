package com.example.demo.atcoder.abc296;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = sc.nextInt();
        }
        boolean[] vis = new boolean[n+1];
        int ans = 0;
        out:for (int i = 1; i <=n ; i++) {
            if(vis[i]){
                continue;
            }
            vis[i] = true;
            Map<Integer, Integer> map = new HashMap<>();

            int cnt = 0;
            map.put(i,cnt);
            int next = arr[i];
            cnt++;
            while (!map.containsKey(next)){
                if(vis[next]){
                    continue out;
                }
                vis[next] = true;
                map.put(next, cnt);
                cnt++;
                next = arr[next];
            }
            ans += cnt - map.get(next);

        }
        System.out.println(ans);

    }
}
