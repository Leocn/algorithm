package com.example.demo.leetcode;

import cn.hutool.core.lang.tree.Tree;

import java.util.*;

public class Week370 {
    public static void main(String[] args) {

    }


    public int findChampion(int[][] grid) {
        int n = grid.length;
        out:for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j){
                    continue;
                }
                if(grid[i][j] == 0){
                    continue out;
                }
            }
            return i;
        }
        return 0;
    }

    public int findChampion(int n, int[][] edges) {
        int m = edges.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            g[e[0]].add(e[1]);
        }
        out:for (int i = 0; i < n; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            boolean[] vis = new boolean[n];
            dq.add(i);
            vis[i] = true;
            while (dq.size()>0){
                int p = dq.poll();
                for(int w: g[p]){
                    if(vis[w] ) continue;
                    vis[w] = true;
                    dq.add(w);
                }

            }
            for (int j = 0; j < n; j++) {
                if(!vis[j]){
                    continue out;
                }
            }
            return i;
        }
        return -1;
    }

    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e: edges){
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        long[] ans =  dfs(0, g,-1, values);
        return  ans[0];
    }
    private long[] dfs(int cur, ArrayList<Integer>[] g, int p, int[] values){
        long[] res = new long[2];
        long sum = 0 , f = 0;
        for(int w: g[cur]){
            if(w==p){
                continue;
            }
            long[] a = dfs(w, g, cur, values);
            f += a[1];
            sum += a[0];
        }
        res[0] = Math.max(values[cur] + sum, f);
        if(g[cur].size()==1 && cur!=0){
            res[0] = 0;
        }
        res[1] = f + values[cur];
        return res;
    }


    public long maxBalancedSubsequenceSum(int[] nums) {
        long ans = nums[0];
        int n = nums.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }
        FenwickTree tree = new FenwickTree(arr);

        for (int i = 0; i < n; i++) {
            int d = nums[i] - i;
            long q = tree.query(d);
            long res = nums[i] + Math.max(0, q);
            ans = Math.max(res, ans);
            tree.update(d, res);
        }



        return ans;
    }

    /**
     * 离散 树状数组
     * */
    public class FenwickTree {
        private long[] tree;
        private int[] a;
        private Map<Integer, Integer> map = new HashMap<>();

        public FenwickTree(int[] nums) {
            discretize(nums);
            this.tree = new long[nums.length + 1];
        }

        private void discretize(int[] nums) {
            this.a = Arrays.copyOf(nums, nums.length);
            Arrays.sort(a);
            for (int i = 0; i < a.length; ++i) {
                map.put(a[i], i + 1);
            }
        }

        private int lowbit(int x) {
            return x & (-x);
        }

        public void update(int num, long val) {
            int x = map.get(num);
            while (x <= a.length) {
                tree[x] = Math.max(tree[x], val);
                x += lowbit(x);
            }
        }

        public long query(int num) {
            int x = map.get(num);
            long res = 0;
            while (x > 0) {
                res = Math.max(res, tree[x]);
                x -= lowbit(x);
            }
            return res;
        }
    }

}
