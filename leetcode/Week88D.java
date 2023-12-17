package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    //线段树结构
    int[] tree = new int[100001];
    int n =0;
    private int lowBit(int x){
        return x & (-x);
    }
    private void add(int x, int a){
        System.out.println(x);
        while(x<=100001){
            tree[x] += a;
            x += lowBit(x);
        }
    }
    private int query(int x){
        int ans = 0;
        while(x>0){
            ans += tree[x];
            x -= lowBit(x);
        }
        return ans;
    }
    /***
     计算逆序对, 树状数组
     */

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int M = 30001;
        n = nums1.length;
        int[] arr  = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = nums1[i]- nums2[i];
        }
        long ans = 0;
        add(arr[0]+M,1);
        for(int i=1; i<n; i++){
            ans += query(arr[i]+M+diff);
            add(arr[i]+M,1);
        }
        return ans;

    }



}
