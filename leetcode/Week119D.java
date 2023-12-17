package com.example.demo.leetcode;

import java.util.*;

public class Week119D {
    public static void main(String[] args) {
        System.out.println(numberOfSets(3,12,new int[][]{{1,0,11}, {1,0,16},{0,2,13}}));
    }

    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] ans = new int[2];
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<>();
        for(int a : nums1){
            set1.add(a);
        }
        for(int b : nums2){
            set2.add(b);
        }
        for(int a:nums1){
            if(set2.contains(a)){
                ans[0]++;
            }
        }
        for(int b : nums2){
            if(set1.contains(b)){
                ans[1]++;
            }
        }
        return ans;
    }
    public int removeAlmostEqualCharacters(String word) {
        int ans = 0;
        char[] cs = word.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; i++) {
            if(i<n-1 &&(cs[i] == cs[i+1] || Math.abs(cs[i]-cs[i+1])==1)){
                ans++;
                i++;
            }
        }
        return ans;
    }

    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int loc = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < n; i++) {
            map.merge(nums[i],1, Integer::sum);
            max = Math.max(map.get(nums[i]), max);
            if(max>k){
                while (map.get(nums[i])>k){
                    map.put(nums[loc], map.get(nums[loc]) -1);
                    loc++;
                }
                max = k;
            }
            ans = Math.max(i-loc+1, ans);
        }
        return ans;
    }

    public static int numberOfSets(int n, int maxDistance, int[][] roads) {
        int max = (1<<n)-1;
        int ans = 0;
        int m = Integer.MAX_VALUE/10;
        out:for (int i = 0; i <=max; i++) {
            int[][] f = new int[n][n];
            for(int[] h: f){
                Arrays.fill(h,m);
            }
            for (int j = 0; j < n; j++) {
                f[j][j] = 0;
            }
            Set<Integer> set = new HashSet<>();
            int loc = 0;
            while (loc<=n){
                if(((1<<loc)& i) ==(1<<loc)){
                    set.add(loc);
                }
                loc++;
            }

            for(int[] r: roads){
                if(set.contains(r[0]) || set.contains(r[1])){
                    continue;
                }
                f[r[0]][r[1]] = Math.min(f[r[0]][r[1]], r[2]);
                f[r[1]][r[0]] = Math.min(f[r[1]][r[0]], r[2]);
            }
            for (int k = 0; k < n; k++) {
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < n; y++) {
                        if(set.contains(x) || set.contains(y) || set.contains(k)){
                            continue;
                        }
                        f[x][y] = Math.min(f[x][y], f[x][k] + f[k][y]);
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(set.contains(j) || set.contains(k)){
                        continue;
                    }
                    if(f[j][k]>maxDistance){
                        continue out;
                    }
                }
            }
            ans++;
        }
        return ans;
    }

}
