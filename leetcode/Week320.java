package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Week320 {
    public static void main(String[] args) {

    }
    public int unequalTriplets(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n-2 ; i++) {
            for (int j = i+1; j <n-1 ; j++) {
                for (int k = j+1; k <n ; k++) {
                    if(nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]){
                        ans++;
                    }
                }

            }

        }
        return  ans;
    }
    TreeSet<Integer> set;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
         set = new TreeSet<>();
        set.add(Integer.MIN_VALUE );
        set.add(Integer.MAX_VALUE);
        dfs(root);
        List<List<Integer>> ans = new ArrayList<>();
        for(int q: queries){
            List<Integer> l = new ArrayList<>();
            if(set.contains(q)){
                l.add(q);
                l.add(q);
            }else{
                int max = set.higher(q);
                int min = set.lower(q);
                if(min != Integer.MIN_VALUE ){
                    l.add(min);
                }else {
                    l.add(-1);
                }
                if(max != Integer.MAX_VALUE){
                    l.add(max);
                }else{
                    l.add(-1);
                }

            }
            ans.add(l);
        }
        return ans;
    }
    private void dfs(TreeNode root){
        if(root==null ) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    long ans = 0;
    boolean[] vis;
    int[] out;
    int seats;
    int[] cnt;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        this.seats = seats;
        List[] arr = new ArrayList[n];
        out = new int[n];
        cnt = new int[n];
        for(int i=0; i<n ;i++){
            arr[i] = new ArrayList();
        }
        for(int[] e: roads){
            arr[e[0]].add(e[1]);
            arr[e[1]].add(e[0]);
        }
        vis = new boolean[n];
        vis[0] = true;
        dfs(arr, 0);

//        vis = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            if(arr[i].size()!=1){
//                continue;
//            }
//            if(i==0 ){
//                continue;
//            }
//            dff( out, i, 1, 0);
//
//        }
        return ans;
    }

    private int dfs(List[] arr, int from){
        List<Integer> s = arr[from];
        int tot=0;
        for(int t : s){
            if(vis[t]){
                continue;
            }
            vis[t] = true;
            out[t] = from;
            tot++;
            tot += dfs(arr, t);

        }
        ans += (tot%seats==0? 0:1) + tot/seats;
        return tot;
    }

    private void dff(int[] out, int from, int tot, int ext) {

        int t = out[from];
        ans += ext;
        ans += tot>0?1:0;
        tot++;
        if(tot==seats){
            ext++;
            tot =0;
        }
        if(from==0) return;
        dff(out, t, tot, ext);
    }

    int MOD = (int) 1e9+7;
    public int beautifulPartitions(String s, int k, int minLength) {
        int ans = 0;
        if(minLength==1) return ans;
        char[] cs= s.toCharArray();
        int n = s.length();
        if(!isZ(cs[0]) || isZ(cs[n-1])) return 0;

        boolean[] arr = new  boolean[n];
        for(int i=1;i<n-1;i++){
            if(!isZ(cs[i]) && isZ(cs[i+1])){
                arr[i] = true;
            }
        }
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i < n-1; i++) {
            if(!arr[i]) continue;
            //分割成1到k几种方式
            for (int j = 0; j < n-k; j++) {
                for (int h = 0; h <=k ; h++) {
                    dp[i][h+1] += dp[j][h];
                }
            }
        }
        return  dp[n][k];



    }
    private  boolean isZ(char c){
        if(c=='2' ||  c=='3' || c=='5' || c=='7'){
            return true;
        }
        return false;
    }
}
