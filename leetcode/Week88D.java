package com.example.demo.leetcode;

import cn.hutool.core.lang.tree.Tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class Week88D {
    public static void main(String[] args) {

    }
    public boolean equalFrequency(String word) {
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)-'a']++;
        }
        int max= 0;
        for (int i = 0; i <26 ; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i]==max){
                arr[i]--;
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if(arr[i]!=-1){
                set.add(arr[i]);
            }
        }

        Set<Integer> set2 = new HashSet<>();
        arr = new int[26];
        Arrays.fill(arr,-1);
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)-'a']++;
        }
        boolean flag = true;
        for (int i = 0; i <26 ; i++) {
            if(arr[i]==1){
                System.out.println(i);
                arr[i]--;
                flag = false;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i]!=-1 && arr[i]!=0){
                set2.add(arr[i]);
            }
        }


        return set.size()==1 || (!flag &&set2.size()==1);
    }

    public int xorAllNums(int[] nums1, int[] nums2) {
        if(nums1.length%2==0 && nums2.length%2==0){
            return 0;
        }
        int n = nums1.length;
        int m = nums2.length;
        if(n%2==0){
            int ans = nums1[0];
            for (int i = 1; i <n ; i++) {
                ans = nums1[i]^ans;
            }

        }
        if(m%2==0){
            int ans = nums2[0];
            for (int i = 1; i <m ; i++) {
                ans = nums2[i]^ans;
            }
            return  ans;
        }
        int ans = nums1[0];
        for (int i = 1; i <n ; i++) {
            ans = nums1[i]^ans;
        }
        for (int i = 0; i <m ; i++) {
            ans = nums2[i]^ans;
        }
        return ans;
    }

    int[] sum;
    int n;
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums1[i]-nums2[i];
        }

        sum = new int[n*4];
        Arrays.fill(sum,Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            add(1, 1,n, i+1, arr[i]);
        }

        long ans = 0;
        for (int i = 0; i < n-1; i++) {
           ans += query(1,1,n, i+2,n, arr[i]-diff);
        }
        return ans;
    }
    public void add(int k, int left, int right, int index, int val){
        sum[k] = Math.min(val, sum[k]);
        if(left==right){
            return;
        }
        int m = left+right>>1;
        if(m>=index){
            add(2*k, left, m, index, val);
        }else{
            add(2*k+1, m+1, right, index, val);
        }
    }

    public long query(int k, int left, int right, int L, int R, int val){
        if(val <=sum[k]){
            return R-L+1;
        }
        if(L==R){
            return 0;
        }

        int m = left+right>>1;
        if(m<L){
            return query(2*k+1, m+1, right, L, R,val);
        }else if (m>= R){
            return query(2*k, left, m, L, R,val);
        }else{
            return query(2*k, left, m, L, m,val) + query(2*k+1, m+1, right, m+1, R,val);
        }

    }



}
