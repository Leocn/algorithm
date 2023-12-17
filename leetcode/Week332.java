package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week332 {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            String str = nums[i] + ""+nums[n-i-1];
            Long s = Long.parseLong(str);
            ans +=s;
        }
        if(n%2!=0){
            ans+= nums[n/2];
        }
        return ans;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        long ans = 0;
        Arrays.sort(nums);
        int n = nums.length;
        if(n==1) {
            return 0;
        }

        for (int i = 0; i < n-1; i++) {
            long cnt1 = binarySearch1(nums, lower-nums[i],i+1, n);
            long cnt2 = binarySearch2(nums, upper-nums[i],i+1, n);
            System.out.println(cnt1);
            System.out.println(cnt2);
            ans += cnt2-cnt1+1;

        }
        return  ans;
    }
    private long binarySearch1(int[] nums, int cnt , int left, int right){
        while (left<right){
            int mid = left+right>>1;
            if(nums[mid]<cnt){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }


    private long binarySearch2(int[] nums, int cnt , int left, int right){
        while (left<right){
            int mid = left+right>>1;
            if(nums[mid]>cnt){
                right = mid;

            }else{
                left = mid+1;
            }
        }
        return left-1;
    }


    public int[][] substringXorQueries(String s, int[][] queries) {

        int sN = s.length();
        Map<String, int[]> map = new HashMap<>();
        Map<Long, String> map2 = new HashMap<>();

        for (int right = 1; right <=sN ; right++) {
            int lef = Math.max(0, right-32);
            for (int i = lef; i < right; i++) {
                if(s.charAt(i)=='0'){
                    if (!map2.containsKey(0L)) {
                        map2.put(0L, "0");
                        map.put("0", new int[]{i, i});
                    }
                    continue;
                }
                String sub = s.substring(i, right);
                Long cn = Long.parseLong(sub,2);
                if(map2.containsKey(cn)){
                    continue;
                }
                map2.put(cn,sub);
                map.put(sub, new int[]{i, i+sub.length()-1});
            }
        }
        int q = queries.length;
        int[][] ans = new int[q][];

        for (int i = 0; i < q; i++) {
            long cn = queries[i][0]^queries[i][1];

            if(map2.containsKey(cn)){
                ans[i] = map.get(map2.get(cn));
            }else{
                ans[i] = new int[]{-1,-1};
            }

        }
        return ans;
    }


    public int minimumScore(String s, String t) {
        char[] cs = s.toCharArray(), ct =t.toCharArray();
        int n = s.length(), m = t.length();
        int[] suf = new int[n+1];
        suf[n] = m;
        int j = m-1;
        for (int i = n-1; i >=0 ; i--) {
            if(j>=0&&cs[i] == ct[j]){
                j--;
            }
            suf[i] = j+1;
        }
        j = 0;
        int ans = suf[0];
        for (int i = 0; i < n && j<m; i++) {
            if(cs[i]==cs[j]){
                if(suf[i+1]>=j){
                    ans = Math.min(ans, suf[j+1]);
                }
                j++;
            }
        }
        return ans;

    }
}
