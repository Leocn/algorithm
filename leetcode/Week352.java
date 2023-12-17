package com.example.demo.leetcode;


import java.util.*;

public class Week352 {
    public static void main(String[] args) {
        System.out.println(sumImbalanceNumbers(new int[]{2,3,1}));
    }
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]%2==0 &&nums[i]<=threshold){
                int next = i+1;
                while (next<n && nums[next]%2!= nums[next-1]%2 && nums[next]<=threshold ){
                    next++;
                }
                ans = Math.max(ans, next-i);

            }
        }
        return ans;
    }

    public List<List<Integer>> findPrimePairs(int n) {
        Set<Integer> set = new HashSet<>();
        set.addAll(PRIMES);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < PRIMES.size(); i++) {
            if(2*PRIMES.get(i)>n){
                break;
            }else {
                if(set.contains(n-PRIMES.get(i))){
                    List<Integer> res = new ArrayList<>();
                    res.add(PRIMES.get(i));
                    res.add(n-PRIMES.get(i));
                    ans.add(res);
                }
            }
        }
        return ans;
    }
    static final List<Integer> PRIMES = getPrimesLe(10000001);

    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }

    public long continuousSubarrays(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int left  = 0;
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            treeMap.put(nums[i], treeMap.getOrDefault(nums[i],0)+1);
            while (left< i && treeMap.size()>0 && Math.abs( treeMap.firstKey()-treeMap.lastKey())>2){
                int cnt = treeMap.getOrDefault(nums[left],0);
                if(cnt==1){
                    treeMap.remove(nums[left]);
                }else {
                    treeMap.put(nums[left], cnt-1);
                }
                left++;
            }
            ans += (long)i-left+1;
        }
        return ans;
    }
    public static int sumImbalanceNumbers(int[] nums) {
        int n = nums.length;
        int[][]dp = new int[n][n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            TreeSet<Integer> set = new TreeSet<>();
            set.add(nums[i]);
            for (int j = i-1; j >=0; j--) {
                Integer ceil = set.ceiling(nums[j]);
                Integer floor = set.floor(nums[j]);

                if(ceil!=null && floor!=null){
                    if(ceil-floor>1){
                        if(nums[j]-floor<=1 && ceil-nums[j]<=1){
                            cnt--;
                        }else if(nums[j]-floor>1 && ceil-nums[j]>1){
                            cnt++;
                        }
                    }
                }else if(ceil!=null){
                    if(ceil-nums[j]>1){
                        cnt++;
                    }
                }else if(floor!=null){
                    if(nums[j]-floor>1){
                        cnt++;
                    }
                }
                set.add(nums[j]);
                ans+= cnt;
                dp[j][i] = cnt;
            }
        }

        return ans;
    }

}
