package com.example.demo.leetcode;

import java.util.*;

public class Week338 {
    public static void main(String[] args) {

    }
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if(numOnes>=k){
            return  k;
        }
        if(numOnes+numZeros>=k){
            return numOnes;
        }
        return numOnes-(k-(numOnes+numZeros));
    }


    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        int cnt[] = new int[n];
        for(int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
            cnt[e[0]]++;
            cnt[e[1]]++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < n; i++) {
            if(cnt[i]==1){
                if(coins[i]==1){
                    pq.add(new int[]{i, 0});
                }else {
                    pq.add(new int[]{i,-1});
                }
            }
        }
        int ans = 0;
        int[] record = new int[n];
        Arrays.fill(record, -1);
        while (pq.size()>0){
            int s = pq.size();
            while (s-->0){
                int[] p = pq.poll();
                List<Integer> list = arr[p[0]];
                for (int next : list){
                    if(cnt[next]==0){
                        continue;
                    }
                    if(p[1]>=2){
                        ans ++;
                    }
                    cnt[next]--;
                    cnt[p[0]]--;
                    if(p[1]!=-1){
                        record[next] = Math.max(p[1]+1, record[next]);
                    }

                    if(cnt[next]!=1){
                        continue;
                    }
                    if(p[1]==-1 && coins[next]==0){
                        pq.add(new int[]{next,Math.max(record[next] , -1)});
                    }else {

                        pq.add(new int[]{next, Math.max(record[next] , p[1] +1) });
                    }
                }

            }
        }




        return 2*ans;
    }
}
