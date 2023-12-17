package com.example.demo.leetcode;


import java.util.*;

public class Week93D {
    public static void main(String[] args) {

    }

    public int maximumValue(String[] strs) {
        int n = strs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            boolean flag = false;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(Character.isLowerCase(c)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                ans = Math.max(ans, str.length());
            }else{
                ans = Math.max(ans, Integer.parseInt(str));
            }
        }
        return ans;
    }


    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        boolean[] vis = new boolean[n];
        for (int[] e: edges){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j <n ; j++) {
            if(vis[j]) continue;
            dq.add(j);
            vis[j] = true;

            while (dq.size()>0){
                int p = dq.poll();
                List<Integer> list = arr[p];
                List<Integer> res = new ArrayList<>();

                for(int t: list){
                    res.add(vals[t]);
                    if(!vis[t]){
                        dq.add(t);
                        vis[t] = true;
                    }
                }
                res.sort((a, b) -> Integer.compare(b, a));
                int sum = vals[p];
                for (int i = 0; i < Math.min(k, res.size()); i++) {
                    if(res.get(i)<=0){
                        break;
                    }
                    sum += res.get(i);
                }
                ans = Math.max(sum,ans);
            }
        }

        return ans;
    }

    public int maxJump(int[] stones) {
        int ans = Integer.MIN_VALUE;
        int n = stones.length;
        for (int i = 0; i <n ; i++) {
            if(i+2<n){
                ans = Math.max(stones[i+2]-stones[i],ans);
            }

        }
        ans = Math.max(ans, stones[1]-stones[0]);
        ans = Math.max(ans, stones[n-1]-stones[n-2]);

        return ans;
    }

    /**
     * 左侧最
     * */
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        long map[] = new long[nums1.length + 1], count = 0, max = 0, sum = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == nums2[i]) {
                count++;
                max = ++map[nums1[i]] > map[(int) max] ? nums1[i] : max;
                sum += i;
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            sum += nums1[i] != nums2[i] && nums1[i] != max && nums2[i] != max && count++ < 2 * map[(int) max] ? i : 0;
        }
        return count < 2 * map[(int) max] ? -1 : sum;
    }
}
