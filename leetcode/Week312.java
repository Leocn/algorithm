package com.example.demo.leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class Week312 {
    public static void main(String[] args) {
        //goodIndices(new int[]{440043,276285,336957},1);


    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] ans = new String[n];
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->b-a);
        for (int i = 0; i < n; i++) {
            map.put(heights[i],i);
        }
        for (int i = 0; i < n; i++) {
            ans[i] = names[map.pollFirstEntry().getValue()];
        }
        return ans;
    }

    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = -1;
        int res = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>max){
                max = nums[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums[i]==max){
                res++;
            }else {
                res =0;
            }
            ans = Math.max(ans, res);
        }
        return ans;

    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] record = new int[n+1];
        int m = 1;
        int s = nums[0];
        record[1] =1;
        for (int i = 1; i < n; i++) {
            if(nums[i]-s<=0){
                m++;

            }else{
                m=1;
            }
            s= nums[i];
            record[i+1] = m;
        }

        int[] up = new int[n+1];
        int min =1;
        int u = nums[n-1];
        up[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            if(nums[i]-u<=0){
                min++;

            }else{
                min=1;
            }
            u= nums[i];
            up[i] = min;
        }
        for (int i = k; i < n-k; i++) {
            if(record[i]>=k && up[i+1]>=k){
                ans.add(i);
            }
        }
        return ans;

    }

    /**
     * 并查集
     * */
    int[] fa;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        var n = vals.length;
        List<Integer> g[] = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x); // 建图
        }

        fa = new int[n];
        for (var i = 0; i < n; i++) fa[i] = i;
        // size[x] 表示节点值等于 vals[x] 的节点个数，如果按照节点值从小到大合并，size[x] 也是连通块内的等于最大节点值的节点个数
        var size = new int[n];
        Arrays.fill(size, 1);
        var id = IntStream.range(0, n).boxed().toArray(Integer[]::new);
        Arrays.sort(id, Comparator.comparingInt(i -> vals[i]));

        var ans = n;
        for (var x : id) {
            int vx = vals[x], fx = find(x);
            for (var y : g[x]) {
                y = find(y);
                if (y == fx || vals[y] > vx) continue; // 只考虑最大节点值比 vx 小的连通块
                if (vals[y] == vx) { // 可以构成好路径
                    ans += size[fx] * size[y]; // 乘法原理
                    size[fx] += size[y]; // 统计连通块内节点值等于 vx 的节点个数
                }
                fa[y] = fx; // 把小的节点值合并到大的节点值上
            }
        }
        return ans;
    }

    int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }





}
