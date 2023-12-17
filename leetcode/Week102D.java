package com.example.demo.leetcode;

import java.util.*;

public class Week102D {
    public static void main(String[] args) {

    }

    public int[] findColumnWidth(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i] = Math.max(ans[i], String.valueOf(grid[j][i]).length());
            }
        }
        return ans;
    }

    public long[] findPrefixScore(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];
        long max = 0;
        long[] s = new long[n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            s[i] = nums[i] + max;
        }
        ans[0] = s[0];
        for (int i = 1; i < n; i++) {
            ans[i] = s[i] + ans[i-1];
        }
        return ans;
    }
    Map<Integer, Integer> map;
    public TreeNode replaceValueInTree(TreeNode root) {
        map = new HashMap<>();
        dfs(0, root);
        dfs2(0, root, null);
        return root;
    }
    private void dfs(int loc, TreeNode root ){
        if(root==null) return;
        map.put(loc , map.getOrDefault(loc,0)+root.val );
        dfs(loc+1, root.left);
        dfs(loc+1, root.right);

    }

    private void dfs2(int loc, TreeNode root,TreeNode p){
        if(p==null){
            root.val = 0;
        }
        if(root==null){
            return;
        }

        int d = 0;
        if(root.left!=null){
            d+= root.left.val;
        }
        if(root.right!=null){
            d+=root.right.val;
        }
        if(d==0){
            return;
        }
        int s = map.get(loc+1);
        if(root.left!=null){
            root.left.val = s-d;
            dfs2(loc+1, root.left, root);
        }
        if(root.right!=null){
            root.right.val = s-d;
            dfs2(loc+1, root.right, root);
        }
    }

    class Graph {
        List[] arr;
        int[][] deg;
        int n;
        public Graph(int _n, int[][] edges) {
            n = _n;
            arr = new List[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new ArrayList<>();
            }
            deg = new int[n][n];
            for(int[] e: edges){
                arr[e[0]].add(e[1]);
                deg[e[0]][e[1]] = e[2];
            }
        }

        public void addEdge(int[] edge) {
            arr[edge[0]].add(edge[1]);
            deg[edge[0]][edge[1]] = edge[2];
        }

        public int shortestPath(int node1, int node2) {
            int[] dis = new int[n];
            Arrays.fill(dis, -1);
            dis[node1] = 0;
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(node1);
            while (dq.size()>0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                for(int next :list){
                    if(dis[next]!=-1&& dis[next]<=dis[p] + deg[p][next]){
                        continue;
                    }
                    dis[next] = dis[p] + deg[p][next];
                    dq.add(next);
                }
            }
            return dis[node2];
         }
    }
}
