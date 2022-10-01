package com.example.demo.atcoder.abc266;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<Integer, Long> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int n = sc.nextInt();
        int tMax = 0;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int loc = sc.nextInt();
            long s = sc.nextLong();
            map1.put(t, s);
            map2.put(t, loc);
            tMax = Math.max(tMax, t);
        }
        long ans = 0;
        long[][] dp = new long[tMax+1][5];
        if(map1.containsKey(0)){
            if(map2.get(0)==0){
                dp[0][0] = map1.get(0);
            }
        }
        for (int i = 1; i <= tMax; i++) {
            long s = map1.getOrDefault(i,0l);
            int loc = map2.getOrDefault(i,-1);
            for (int j = 0; j < Math.min(i+1,5); j++) {
                if(loc==j){
                    dp[i][j] =  Math.max(dp[i-1][j],Math.max((j>0? dp[i-1][j-1]:0) , (j<4? dp[i-1][j+1]:0)))+ s;
                    ans = Math.max(ans, dp[i][j]);
                }else {
                    dp[i][j] =  Math.max(dp[i-1][j],Math.max((j>0? dp[i-1][j-1]:0) , (j<4? dp[i-1][j+1]:0)));
                }
            }

        }
        System.out.println(ans);

    }
}
