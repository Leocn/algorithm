package com.example.demo.leetcode;

import org.assertj.core.data.MapEntry;

import java.util.*;

public class Week346 {
    public static void main(String[] args) {

    }

    public int minLength(String s) {
        out :while (true){
            int len = s.length();
            for (int i = 0; i < len-1; i++) {
                if(s.substring(i, i+2) .equals("AB") || s.substring(i, i+2) .equals("CD")){
                    s = s.substring(0,i) + s.substring(i+2, len);
                    continue out;
                }
            }
            break;
        }
        return s.length();
    }


    public String makeSmallestPalindrome(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0; i <n/2 ; i++) {
            if(cs[i] != cs[n-i-1]){

                if(cs[i]<cs[n-i-1]){

                    cs[n-i-1] = cs[i];
                }else {
                    cs[i] = cs[n-i-1];
                }
            }
        }
        return new String(cs);
    }

    static  List<Integer> list = new ArrayList<>();
    static {
        for (int i = 1; i <=1000 ; i++) {
            if(check(i)){
                list.add(i);
            }
        }
        System.out.println(-1);

    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int l: list){
            if(l<=n){
                ans += l*l;
            }else {
                break;
            }
        }
        return ans;
    }
    private static boolean check(int t ){
        String tar = t*t+"";
        return dfs(tar, 0, 0, t);
    }
    private static boolean dfs(String tar, int loc, int sum, int t){
        if(loc == tar.length()){
            if(sum == t){
                return true;
            }else {
                return false;
            }
        }
        for (int i =loc; i <tar.length() ; i++) {
            if(tar.charAt(loc)=='0'){
                return dfs(tar, loc+1, sum, t);
            }else {
                int a = Integer.parseInt(tar.substring(loc, i+1));
                if(a+sum<=t){
                    if(dfs(tar, i+1,sum+a, t)){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    static int[] vis;
    static int[][] cnt;
    static List<Integer>[] arr;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        cnt = new int[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if(e[2] == -1){
                cnt[e[0]][e[1]] = 1;
                cnt[e[1]][e[0]] = 1;
                map.put(e[0] +" " +e[1], i);
                map.put(e[1] +" " +e[0], i);
                edges[i][2] = 1;
            }else {
                cnt[e[0]][e[1]] = e[2];
                cnt[e[1]][e[0]] = e[2];
            }

            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);

        }

        vis  = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        vis[source] = 0;
        PriorityQueue<Integer> dq = new PriorityQueue<>((a,b)->Integer.compare(vis[a],vis[b]));
        dq.add(source);
        while (dq.size()>0){
            int p = dq.poll();
            for(int t: arr[p]){
                if(vis[t]> vis[p] + cnt[p][t]){
                    vis[t] = vis[p] + cnt[p][t];
                    dq.add(t);
                }
            }
        }
        if(vis[destination]>target ){
            return  new int[][]{};
        }
        System.out.println(vis[destination]);

        int[] dis  = new int[n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        pq.add(new int[]{0, source});

        while (pq.size()>0){
            int[] a = pq.poll();
            int v = a[0], p= a[1];
            for(int t: arr[p]){
                String str = p+ " " + t;
                if(map.containsKey(str )){
                    int z = target - vis[destination] - dis[p] + vis[t];
                    if(edges[map.get(str)][2]<z){
                        edges[map.get(str)][2]=z;
                        cnt[p][t] = z;
                        cnt[t][p] = z;
                        v = z;

                    }
                    map.remove(str);
                    map.remove(t+ " " + p);

                }

                if(dis[t]> dis[p] + v){
                    dis[t] = dis[p] + v;
                    pq.add(new int[]{dis[t], t});
                }
            }
        }
        System.out.println(dis[destination]);
        if(dis[destination]!= target){

            return new int[][]{};
        }
        return  edges;
    }
}
