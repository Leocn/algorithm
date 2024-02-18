package com.example.demo.leetcode;

import java.util.*;

public class Week124D {
    public static void main(String[] args) {

    }

    static int ans ;
    static Map<Integer, Set<Long>> map ;
    public int maxOperations(int[] nums) {
        int n = nums.length;
        if(n<=1) return 0;
        ans = 1;
        map = new HashMap<>();
        dfs(nums, 1, n-2, nums[0] + nums[n-1]);
        dfs(nums, 0, n-3, nums[n-1] + nums[n-2]);
        dfs(nums, 2, n-1, nums[0] + nums[1]);
        return ans;
    }

    private static void dfs(int[] nums, int l, int r, int a){
        Set<Long> set = map.getOrDefault(a, new HashSet<>());
        long d = 200000L *l+r;
        if(set.contains(d)){
            return;
        }
        set.add(d);
        map.put(a, set);
        ans = Math.max((nums.length - (r-l+1))/2, ans);
        if(r-l<=0){
            return;
        }
        if(nums[l] + nums[r] == a){
            dfs(nums, l+1, r-1, a);
        }
        if(nums[l] + nums[l+1] == a){
            dfs(nums, l+2, r, a);
        }
        if(nums[r-1] + nums[r] == a){
            dfs(nums, l, r-2, a);
        }

    }

    public String lastNonEmptyString(String s) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        for(char c: cs){
            cnt[c-'a']++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            max = Math.max(max, cnt[i]);
        }
        int[] tar = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c: cs){
            tar[c-'a']++;
            if(tar[c-'a'] == max){
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int num:nums){
            int a = num+1;
            int cN = map.getOrDefault(num, 0)+1;
            int cA = map.getOrDefault(a,0)+1;
            map.put(num+1, cN);
            map.put(a+1, cA);
            ans = Math.max(cA, ans);
            ans = Math.max(cN, ans);
        }
        return ans;
    }
}
