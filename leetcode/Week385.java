package com.example.demo.leetcode;

import java.util.*;

public class Week385 {
    public static void main(String[] args) {

    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for(int a: arr1){
            while (a>0){
                set.add(a);
                a/=10;
            }
        }
        for(int a: arr2){
            while (a>0){
                if(set.contains(a)){
                    ans = Math.max(ans, (""+a).length());
                }
                a/=10;
            }
        }
        return ans;
    }

    public int mostFrequentPrime(int[][] mat) {
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
        int n = mat.length, m = mat[0].length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int l = mat[i][j];
                for(int[] d: dirs){
                    int c = l;
                    int x = i, y = j;
                    while (x +d[0]<n && y+d[1]<m && x +d[0]>=0 && y +d[1]>=0){
                        x+= d[0];
                        y+= d[1];
                        c = c*10 + mat[x][y];
                        if(SET.contains(c)){
                            map.merge(c, 1, Integer::sum);
                        }
                    }

                }
            }
        }
        int max = 0;
        int ans = -1;
        for(int key: map.keySet()){
            if(map.get(key)>max){
                max = map.get(key);
                ans = key;
            }else if(map.get(key) == max){
                ans = Math.max(key, ans);
            }
        }
        return ans;
    }

    static final List<Integer> PRIMES = getPrimesLe(1000000);
    static Set<Integer> SET = new HashSet<>(PRIMES);

    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }


    /**
     * 字典树
     */

    class Node{
        Map<Integer, Node> map = new HashMap<>();
        int cnt;
    }

    public long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        Node root = new Node();
        for(String w: words){
            int n = w.length();
            char[] cs = w.toCharArray();
            Node r = root;
            for (int i = 0; i < n; i++) {
                int loc = (cs[i] - 'a')<<5  | (cs[n-1-i] - 'a');
                r.map.putIfAbsent(loc, new Node());
                r = r.map.get(loc);
                ans += r.cnt;
            }
            r.cnt++;
        }
        return ans;
    }
}

