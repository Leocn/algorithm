package com.example.demo.leetcode;

import java.util.*;

public class Week326 {

    public int countDigits(int num) {
        List<Integer> list = new ArrayList<>();
        int tem = num;
        while (tem>=10){
            list.add(tem%10);
            tem/=10;
        }
        list.add(tem);
        int ans  =0;
        for (int s: list) {
            if(num%s==0){
                ans++;
            }
        }
        return ans;

    }

//    static final List<Integer> PRIMES = getPrimesLe(2000);
//    public int distinctPrimeFactors(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int n: nums){
//            List<Integer> list = getPrimeFactors(n);
//            set.addAll(list);
//        }
//        return  set.size();
//    }

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

    /**
     ** 获取质数因子
     * */
    public static List<Integer> getPrimeFactors(int k) {
        List<Integer> ans = new ArrayList<>();
        int r = (int) Math.sqrt(k) + 1;
        for (int p : PRIMES) {
            if (p > r) {
                break;
            }
            int exp = 0;
            while (k % p == 0) {
                exp++;
                k /= p;
            }
            if (exp > 0) {
                ans.add(p);
            }
        }
        if (k != 1) {
            ans.add(k);
        }
        return ans;
    }


    static final List<Integer> PRIMES = getPrimesLe(1000010);
    public int[] closestPrimes(int left, int right) {
        int[] ans = new int[]{-1,-1};
        int le = Integer.MIN_VALUE; int diff = Integer.MAX_VALUE;
        for(int t: PRIMES){
            if(t>=left && t<=right){
                if(le!=Integer.MIN_VALUE){
                    if(t-le<diff){
                        ans = new int[]{le, t};
                        diff = t-le;
                    }
                }
                le = t;

            }
        }
        return ans;
    }


    public int minimumPartition(String s, int k) {
        int ans = 0;
        int loc = 0, n = s.length();
        while (loc<n){
            int next = loc+1;
            long res = Long.parseLong(s.substring(loc,next));
            while (res<=k&& next<=n){
                next++;
                res = Long.parseLong(s.substring(loc,next));
            }
            next--;
            if(next==loc){
                return  -1;
            }
            ans ++;
            loc = next;

        }
        return ans;
    }
}
