package com.example.demo.leetcode;

import java.util.*;

public class Week322 {
    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for(int i=0; i<n-1;i++){
            if(arr[i].charAt(arr[i].length()-1) != arr[i+1].charAt(0)){
                return false;
            }
        }
        if(arr[n-1].charAt(arr[n-1].length()-1) != arr[0].charAt(0)){
            return false;
        }
        return true;
    }

    public long dividePlayers(int[] skill) {
        long ans = 0;
        Arrays.sort(skill);
        int n = skill.length;
        long sum = skill[0] + skill[n-1];
        for (int i = 0; i <n/2 ; i++) {
            if(skill[i] + skill[n-1-i] != sum){
                return -1;
            }
            ans += (long)skill[i] * skill[n-1-i];
        }
        return ans;
    }

    public int minScore(int n, int[][] roads) {

        List[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<int[]>();
        }
        for(int[] r: roads){
            arr[r[0]].add(new int[]{r[1],r[2]});
            arr[r[1]].add(new int[]{r[0],r[2]});
        }
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        int ans = Integer.MAX_VALUE;
        while (dq.size()>0){
            int p = dq.poll();
            List<int[]> list = arr[p];
            for(int[] t : list){
                ans = Math.min(ans, t[1]);
                if(dis[t[0]]> dis[p]+ t[1]){
                    dq.add(t[0]);
                    dis[t[0]] = dis[p]+ t[1];
                }
            }
        }
        return ans;
    }

    public int magnificentSets(int n, int[][] edges) {
        ArrayList[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] r: edges){
            arr[r[0]].add(r[1]);
            arr[r[1]].add(r[0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = 0;
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 1; i <=n ; i++) {
            if( dis[i] ==Integer.MAX_VALUE ){
                List<Integer> record = new ArrayList<>();
                int res =0;
                dq.add(i);
                record.add(i);
                dis[i] = 0;
                while (dq.size()>0){
                    int size = dq.size();
                    res++;
                    while(size-->0){
                        int p = dq.poll();
                        List<Integer> list = arr[p];
                        for(int t : list){
                            if(dis[t] == dis[p]){
                                return -1;
                            }
                            if(dis[t]==Integer.MAX_VALUE){
                                dis[t] = res%2;
                                dq.add(t);
                                record.add(t);
                            }


                        }
                    }

                }

                int max = 0;
                for (int j = 1; j < record.size(); j++) {
                    boolean[] vis = new boolean[n+1];
                    vis[record.get(i)] = true;
                    dq.add(record.get(i));
                    while (dq.size()>0){
                        int size = dq.size();
                        max++;
                        while(size-->0){
                            int p = dq.poll();
                            List<Integer> list = arr[p];
                            for(int t : list){
                                if(vis[t]){
                                    continue;
                                }
                                dq.add(t);
                                vis[t] = true;
                            }
                        }
                    }
                    res = Math.max(max, res);
                }
                ans +=res;
            }


        }
        return ans;
    }
}
