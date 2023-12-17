package com.example.demo.leetcode;

import java.util.ArrayList;

public class Week89D {
    public static void main(String[] args) {

    }

    public int countTime(String time) {
        int ans =1;
        char[] cs = time.toCharArray();
        if(cs[0]=='?'){
            if(cs[1]=='?'){
                ans *= 24;
            }else if(cs[1]>='0' && cs[1]<='3'){
                ans*=3;
            }else{
                ans*=2;
            }

        }else if(cs[0]=='0' || cs[0]=='1'){
            if(cs[1]=='?'){
                ans *= 10;
            }
        }else{
            if(cs[1]=='?'){
                ans *= 4;
            }
        }

        if(cs[3]=='?'){
            ans *= 6;
        }
        if(cs[4]=='?'){
            ans *=10;
        }
        return ans;
    }

    int MOD = (int) 1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        int m = Integer.bitCount(n);
        int[] powers = new int[m];
        int start = 0;
        for(int i =0; i<32; i++){
            if(((n>>i) &1) ==1){
                powers[start++] = 1<<i;
            }
        }
        int d = queries.length;
        int[] ans = new int[d];
        for(int j =0; j<d;j++){
            int[] q= queries[j];
            long s = 1;
            for (int i = q[0]; i <=q[1] ; i++) {
                s = s*(powers[i]%MOD)%MOD;
            }
            ans[j] = (int)s;
        }
        return  ans;
    }


    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n;i++){
            sum += nums[i];
            ans = Math.max(ans, (int)(sum/(i+1)) + (sum%(i+1)==0?0:1));
        }
        return ans;
    }


//    public int componentValue(int[] nums, int[][] edges) {
//        for (int i = 0; i < ; i++) {
//
//        }
//    }



    public int componentValue(int[] nums, int[][] edges) {
        ArrayList<Integer>[] list = new ArrayList[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            list[i] = new ArrayList<>();
            sum += nums[i];
        }
        for (int[] edge : edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        for (int i = 1;; i++) {
            if (sum % i == 0 && componentValue(0, -1, i, list, nums) == 0) {
                return sum / i - 1;
            }
        }
    }

    private int componentValue(int i, int from, int sum, ArrayList<Integer>[] list, int[] nums) {
        int result = nums[i], next;
        for (int j : list[i]) {
            if ((next = j == from ? 0 : componentValue(j, i, sum, list, nums)) < 0) {
                return -1;
            }
            result += next;
        }
        return result > sum ? -1 : result % sum;
    }

}
