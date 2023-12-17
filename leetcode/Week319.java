package com.example.demo.leetcode;

import java.util.*;

public class Week319 {
    public static void main(String[] args) {
        System.out.println(gcd(6,12));
        System.out.println(countPairs(new int[]{1,3}));
        System.out.println(-6%5);
    }
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius +273.15, celsius *1.80 + 32.00};
    }

    public int subarrayLCM(int[] nums, int k) {
        int ans = 0;
        int n  = nums.length;
        for(int i = 0; i<n; i++){
            int d = nums[i];
            for(int j = i; j<n; j++){
                int g = gcd(d, nums[j]);
                d = d * nums[j] /g;
                if(d == k){
                    ans++;
                }
            }
        }
        return  ans;
    }

    public static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }
    public static int countPairs(int[] deliciousness) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int d: deliciousness){

            for(int i=0,s=1;i<22;i++){
                if(s>d){
                    ans += map.getOrDefault(s-d,0);

                }
                //System.out.println(s-d);
                s*=2;
            }
            map.put(d, map.getOrDefault(d,0)+1);
        }
        return ans;
    }

    public int minimumOperations(TreeNode root) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        int ans = 0;
        dq.add(root);
        while (dq.size()>0){
            int s = dq.size();
            int[] res = new int[s];
            int[] sortArray = new int[s];
            Map<Integer,Integer> map = new HashMap<>();
            int loc = 0;
            while (s-->0){
                TreeNode  p = dq.poll();
                res[loc] = p.val;
                sortArray[loc] = p.val;
                map.put(p.val, loc++);
                if(p.left!=null){
                    dq.add(p.left);
                }
                if(p.right!=null){
                    dq.add(p.right);
                }

            }

            Arrays.sort(sortArray);
            for(int i = 0 ;i<loc; i++){
                if(res[i]!= sortArray[i]){
                    ans++;
                    int tem = map.get(sortArray[i]);
                    int tem2 = map.get(res[i]);
                    map.put(sortArray[i], i);
                    map.put(res[i], tem);
                    swap(res, tem2, tem);
                }
            }


        }
        return ans;
    }

    public static void swap(int[] nums, int i,int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            dp[i][i] = true;
        }
        for(int i=2;i<=n;i++){
            for(int j=i; j<=n; j++){
                boolean b = cs[j - i] == cs[j - 1];
                dp[j-i+1][j] = (i==2)?b : b & dp[j-i+2][j-1];
            }

        }
        int[] ans = new int[n+1];
        for(int i=k; i<=n;i++){
            ans[i] = ans[i-1];
            for(int j =1; j<=i-k+1;j++){
                if(dp[j][i]){
                    ans[i] = Math.max(ans[i],ans[j-1]+1);
                }else{
                    ans[i] = Math.max(ans[i],ans[j-1]);
                }
            }

        }
        return ans[n];
    }


}
