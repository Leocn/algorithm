package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week384 {
    public static void main(String[] args) {

    }
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            int max = -1;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            for (int j = 0; j < n; j++) {
                if(matrix[j][i]==-1){
                    matrix[j][i] = max;
                }
            }
        }
        return matrix;
    }

    public int maxPalindromesAfterOperations(String[] words) {
        int[] cnt = new int[26];
        int len = 0;
        for(String w: words){
            for(char c: w.toCharArray()){
                cnt[c-'a']++;
            }
            if(w.length()%2==1){
                len++;
            }
        }
        int cc =0;
        for (int i = 0; i < 26; i++) {
            if(cnt[i]%2==1){
                cc++;
            }
        }
        cc = Math.max(0, cc- len);
        int ans = words.length;
        Arrays.sort(words, (a,b)->b.length()-a.length());
        for(String w: words){
            if(cc>0 && w.length()>1){
                ans--;
                cc = Math.max(0, cc- w.length()/2*2);
            }
        }
        return ans;
    }


    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        int[] s = new int[n-1];
        int loc = 0;
        for (int i = 0; i < n-1; i++) {
            int a = 0;
            if(nums[i+1] > nums[i]){
                a = 1;
            }else if(nums[i+1]<nums[i]){
                a = -1;
            }
            s[loc++] = a;
        }
        int ans = KMP(s, pattern).size();
        return ans;
    }


    public static int[] getNext(int[] p) {
        int[] next = new int[p.length];
        int j = 0;
        for (int i = 1; i < p.length; i++) {
            while (j > 0 && p[i] != p[j]) {
                j = next[j - 1];
            }
            if (p[i] == p[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static List<Integer> KMP(int[] s, int[] p) {
        int[] next = getNext(p);
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            while (j > 0 && s[i] != p[j]) {
                j = next[j - 1];
            }
            if (s[i] == p[j]) {
                j++;
            }
            if (j == p.length) {
                res.add(i - p.length + 1);
                j = next[j - 1];
            }
        }
        return res;
    }

}
