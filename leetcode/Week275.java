package com.example.demo.leetcode;

import java.util.*;

public class Week275 {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[]{0,1,0,1,1,0,0}));
        System.out.println(findKthNumber(13,2));
    }

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <n ; i++) {
            boolean[] t = new boolean[n];
            for (int j = 0; j < n; j++) {
                if( t[matrix[i][j]-1]){
                    return false;
                }else {
                    t[matrix[i][j]-1] = true;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            boolean[] t = new boolean[n];
            for (int j = 0; j < n; j++) {
                if( t[matrix[j][i]-1]){
                    return false;
                }else {
                    t[matrix[j][i]-1] = true;
                }
            }
        }

        return true;
    }


    public static int minSwaps(int[] nums) {
        int oneCount = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                total += 1;
            }
        }
        int[] r = new int[2*nums.length];
        for (int i = 0; i < 2*nums.length; i++) {
            if(nums[i%nums.length]==1){
                oneCount += 1;
            }
            r[i] = oneCount;
        }
        int res = Integer.MAX_VALUE;
        for (int i = total; i < 2*nums.length; i++) {
            res = Math.min(res, total - (r[i]- r[i-total]));
        }
        return res;




    }

    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Long> set = new HashSet<>();

        for (String st:startWords){
            char[] chars = st.toCharArray();
            long s = 0L;
            for (char aChar : chars) {
                s |= 1L << (aChar - 'a');
            }
            set.add(s);
        }
        int res =0;
        for (String ed: targetWords){
            char[] chars = ed.toCharArray();
            long s = 0L;
            for (char aChar : chars) {
                s |= 1L << (aChar - 'a');
            }
            for (char aChar : chars) {
                long t  = s ^ 1L << (aChar - 'a');
                if(set.contains(t)){
                    res +=1;
                    break;
                }
            }

        }
        return res;
    }

    static int  findKthNumber(int n, int k) {

        int cur = 1;
        k--;

        while (k > 0)
        {
             long left = cur;
             long right = cur + 1;
            int node_num = 0;

            while (left <= n) // 统计树中每一层的节点个数
            {
                node_num += Math.min(right, (long)(n+1)) - left;
                left *= 10;
                right *= 10;
            }

            if (node_num <= k) // 向后查找
            {
                k -= node_num;
                cur++;
            }
            else // 进入子树查找
            {
                k--;
                cur *= 10;
            }
        }

        return cur;
    }


}
