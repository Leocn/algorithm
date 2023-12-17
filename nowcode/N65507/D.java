package com.example.demo.nowcode.N65507;

import java.math.BigInteger;
import java.util.*;

public class D {
    static int[] record;
    static int[] cnt;
    static int sum;
    static int MOD = (int)1e9+7;
    static long[] ss = new long[200000+1];
    static {
        ss[0] = 1;
        for (int i = 0; i < 200000; i++) {
            ss[i+1] = ss[i] * 2%MOD;
         }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i <=n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            g[a].add(b);
            g[b].add(a);
        }

        record = new int[n+1];
        cnt = new int[n+1];
        Set<Long> set = new HashSet<>();
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{1,-1});
        int dis = 0;
        while (dq.size()>0){
            int size = dq.size();
            dis++;
            while (size-->0){
                int[] p = dq.poll();
                for(int cur: g[p[0]]){
                    if(cur== p[1]) continue;
                    set.add((1L<<26) * cur + p[0] );
                    set.add((1L<<26) * p[0] + cur);

                    if(record[cur] == 0){
                        cnt[cur]++;
                        record[cur] = dis;
                        dq.add(new int[]{cur, p[0]});
                    }else {
                        if(record[cur] == dis){
                            cnt[cur]++;
                        }else {
                           if(!set.contains((1L<<26) * cur + p[0])){
                               sum++;
                           }

                        }

                    }
                }
            }
        }

        long ans = 0;
        for (int i = 2; i <=n; i++) {
            ans = (ans+record[i])%MOD;
        }
       long all = 1;
        for (int i = 2; i <=n ; i++) {
            all = all * (ss[record[i]]-1+MOD)%MOD;
        }

        all = all * ss[sum] %MOD;

        System.out.println(ans + " " + all);



    }



}
