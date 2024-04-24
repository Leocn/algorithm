package com.example.demo.leetcode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Week393 {
    public static void main(String[] args) {

    }
    public String findLatestTime(String s) {
        char[] cs = s.toCharArray();
        if(cs[0] =='?'){
            if(cs[1]=='?'){
                cs[0] = '1';
                cs[1] = '1';
            }else {
                if(cs[1] == '0' || cs[1] == '1'){
                    cs[0] = '1';
                }else {
                    cs[0] = '0';
                }
            }
        }else {
            if(cs[1]=='?'){
                if(cs[0] == '1'){
                    cs[0] = '1';
                }else {
                    cs[0] = '9';
                }
            }
        }
        if(cs[3]=='?'){
            cs[3] = '5';
        }
        if(cs[4] == '?'){
            cs[4] = '9';
        }
        return  new String(cs);
    }
    public int maximumPrimeDifference(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int loc = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime(nums[i])){
                loc = i;
                break;
            }
        }
        for (int i = n-1; i >=0 ; i--) {
            if(isPrime(nums[i])){
                return i-loc;
            }
        }
        return 0;
    }

    public  boolean isPrime(int n){
        if(n==1){
            return false;
        }
        for (long i = 2; i*i <=n ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public long findKthSmallest(int[] coins, int k) {
        long ans = 0;
        Arrays.sort(coins);
        int n = coins.length;
        long left = 0, right =  (long)coins[0] * k;
        while (left< right){
            long mid = left + right>>1;
            long sum = countMultiples(coins, mid);
            if(sum<k){
                left  = mid +1;
            }else {
                right = mid;
            }
        }
        return left;
    }
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 计算最小公倍数
    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    // 计算多个数的最小公倍数
    private static long lcmOfArray(int[] subset) {
        long result = 1;
        for (int num : subset) {
            result = lcm(result, num);
            if (result == 0) {
                return 0;
            }
        }
        return result;
    }

    // 主方法
    public static long countMultiples(int[] nums, long m) {
        long count = 0;
        int n = nums.length;
        // 使用包含-排除原理
        for (int i = 1; i < (1 << n); i++) {
            int bitCount = Integer.bitCount(i);
            long lcm = 1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    lcm = lcm(lcm, nums[j]);
                    if (lcm > m) {
                        break;
                    }
                }
            }
            if (bitCount % 2 == 1) {
                count += m / lcm;
            } else {
                count -= m / lcm;
            }
        }
        return count;
    }
    int max = (1<<31) - 1;
    int n = 0;
    int m = 0;
    Map<Integer, Map<String, Integer>> mem;
    public int minimumValueSum(int[] nums, int[] andValues) {
        n = nums.length;
        m = andValues.length;
        mem = new HashMap<>();
        int r = dfs(max, 0,0,  nums, andValues);
        if(r>= Integer.MAX_VALUE/15){
            return -1;
        }
        return r;
    }

    private int dfs(int pre, int loc,  int w, int[] nums, int[] andValues){
        if(hasC(pre, loc, w)){
            return mem.get(pre).get(loc+"_" + w);
        }
        if(loc == n){
            if(w == m){
                return 0;
            }else {
                putC(pre,loc, w, Integer.MAX_VALUE/10);
                return Integer.MAX_VALUE/10;
            }
        }
        if(w==m){
            putC(pre,loc, w, Integer.MAX_VALUE/10);
            return Integer.MAX_VALUE/10;
        }
        int res =Integer.MAX_VALUE/10;
        if((pre&nums[loc]) == andValues[w]){
            int r = (pre == max? nums[loc] : nums[loc] - nums[loc-1]) + dfs(max, loc+1, w+1, nums,andValues);
            res = Math.min(res, r);
        }else if((pre&nums[loc]) < andValues[w]){

            putC(pre,loc, w, Integer.MAX_VALUE/10);
            return Integer.MAX_VALUE/10;
        }
        res = Math.min(res, (pre == max? nums[loc] : nums[loc] - nums[loc-1]) + dfs(pre&nums[loc], loc+1,  w, nums, andValues));

        putC(pre,loc, w, res);
        return  res;
    }

    public boolean hasC(int pre , int loc , int w){
        return mem.containsKey(pre) && mem.get(pre).containsKey(loc + "_" + w);
    }

    public void putC(int pre , int loc, int w, int v){
        mem.putIfAbsent(pre, new HashMap<>());
        mem.get(pre).put(loc +"_" + w, v);
    }

}
