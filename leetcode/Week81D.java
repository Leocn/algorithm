package com.example.demo.leetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Week81D {

    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        List[] arr = new ArrayList[n];
        for(int i=0; i<n-1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        boolean[] vis = new boolean[n];
        Deque<Integer> dq  = new ArrayDeque<>();
        int sum = 0;
        for(int i=0; i<n-1 ; i++){
            if(vis[i] ){
                 continue;
            }
            dq.add(i);
            int cnt = 0;
            while (dq.size()>0){
                cnt++;
                int p = dq.poll();
                vis[p] = true;
                List<Integer> t = arr[p];
                for(int a : t){
                    if(vis[a]){
                        continue;
                    }
                    dq.add(a);
                }
            }
            if(cnt==n) continue;
            ans += (long)cnt*sum;
            sum += cnt;

        }
        return ans;
    }


    public int distinctSequences(int n) {
        int[][] dp = new int[n+1][7];
        Arrays.fill(dp[1],1);
        for (int i = 2; i <= n; i++) {
            for(int j=1; j<=6; j++){
                for (int k = 1; k <=6; k++) {
                    if(j!=k && gcd(j,k) == 1){
                        dp[i][j] += dp[i-1][k]-dp[i-2][j];
                    }
                }
                if(i>3){
                    dp[i][j] += dp[i-3][j];
                }
            }
        }
        int ans = 0;
        for(int i =1; i<=6; i++){
            ans += dp[n][i];
        }
        return ans;

    }
    public int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }

}
