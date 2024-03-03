package com.example.demo.leetcode;

import java.util.*;

public class Week387 {
    public static void main(String[] args) {

    }


    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        long[][] result = new long[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {//第0个，最左上角
                    result[i][j] = grid[i][j];
                } else if (i == 0) {//第一行，最顶部一行
                    result[i][j] = result[i][j - 1] + grid[i][j];
                } else if (j == 0) {//第一列，最左边一列
                    result[i][j] = result[i - 1][j] + grid[i][j];
                } else {//其他
                    result[i][j] = result[i - 1][j] + result[i][j - 1] + grid[i][j] - result[i - 1][j - 1];
                }
                if(result[i][j]<=k){
                    ans++;
                }
            }
        }
        return ans;
    }


    public int minimumOperationsToWriteY(int[][] grid) {
        int n = grid.length;
        int[] cnt = new int[3];
        for (int i = 0; i < n/2; i++) {
            cnt[grid[i][i]]++;
        }
        for (int i = n/2; i <n ; i++) {
            cnt[grid[n-i-1][i]]++;
        }
        for (int i = n/2+1; i < n; i++) {
            cnt[grid[i][n/2]] ++;
        }

        int[] sum = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[grid[i][j]]++;
            }
        }
        for (int i = 0; i < 3; i++) {
            sum[i] -= cnt[i];
        }
        int ans = n*n;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(i == j){
                    continue;
                }
                ans = Math.min((cnt[0] + cnt[1] + cnt[2] - cnt[i])+(sum[0] + sum[1] + sum[2] - sum[j]), ans);
            }
        }
        return ans;
    }

    public int[] resultArray(int[] nums) {
        int n = nums.length;
        Fenwick tree1 = new Fenwick(n);
        Fenwick tree2 = new Fenwick(n);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int[] sorted = new int[n];
        System.arraycopy(nums,0, sorted, 0, n);
        Arrays.sort(sorted);

        list1.add(nums[0]);
        list2.add(nums[1]);
        tree1.add(Arrays.binarySearch(sorted, nums[0]) + 1);
        tree2.add(Arrays.binarySearch(sorted, nums[1]) + 1);
        for (int i = 2; i < n; i++) {
            int c1 = tree1.pre(Arrays.binarySearch(sorted, nums[i]-1) + 1);
            int c2 = tree2.pre(Arrays.binarySearch(sorted, nums[i]-1) + 1);
            if(c1>c2){
                list1.add(nums[i]);
                tree1.add(nums[i]);
            }else if(c1<c2) {
                list2.add(nums[i]);
                tree2.add(nums[i]);
            }else {
                if(list1.size()<=list2.size()){
                    list1.add(nums[i]);
                    tree1.add(nums[i]);
                }else {
                    list2.add(nums[i]);
                    tree2.add(nums[i] );
                }
            }
        }
        int loc = 0;
        for(int l: list1){
            nums[loc++]  = l;
        }
        for(int l: list2){
            nums[loc++]  = l;
        }
        return nums;
    }
    class Fenwick {
        private final int[] tree;

        public Fenwick(int n) {
            tree = new int[n];
        }

        // 把下标为 i 的元素增加 1
        public void add(int i) {
            while (i < tree.length) {
                tree[i] += 1;
                i += i & -i;
            }
        }

        // 返回下标在 [1,i] 的元素之和
        public int pre(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i &= i - 1;
            }
            return res;
        }
    }

}
