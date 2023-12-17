package com.example.demo.leetcode;

import java.util.*;

public class Week373 {
    public static void main(String[] args) {

    }
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length, m = mat[0].length;
        k%=m;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if((i&1)==1){
                    if(mat[i][j] != mat[i][(j+k)%k]){
                        return false;
                    }
                }else {
                    if(mat[i][j] != mat[i][((j-k)%k + k)%k]){
                        return false;
                    }
                }

            }
        }
        return true;
    }


    public long beautifulSubstrings(String s, int k) {
        long ans = 0;
        char[] cs = s.toCharArray();
        int n = s.length();
        int c = 0, b = 0;
        if(k==1){
            Map<Integer,Long> map = new HashMap<>();

            map.put(0, 1L);
            for (int i = 0; i < n; i++) {
                if(cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u' ){
                    c++;
                }else {
                    b++;
                }

               ans += map.getOrDefault(c-b,0L);



                map.merge(c-b, 1L, Long::sum);
            }
        }else {
            List<Integer> list = getPrimeFactors(k);
            int res = 1;
            for(int l: list){
                int sum = 0;
                while (k%l == 0){
                    sum++;
                    k/=l;
                }
                res *= (int)Math.pow(l, (sum+1)/2);
            }

            Map<Integer,Map<Integer, Long>> map = new HashMap<>();
            Map<Integer,Long> map1 = new HashMap<>();
            map1.put(0,1L);
            map.put(0, map1);
            for (int i = 0; i < n; i++) {
                if(cs[i] == 'a' || cs[i] == 'e' || cs[i] == 'i' || cs[i] == 'o' || cs[i] == 'u' ){
                    c++;
                }else {
                    b++;
                }
                Map<Integer, Long> map2 = map.getOrDefault(b-c, new HashMap<>());
                int d = c %res;
                ans += map2.getOrDefault(d,0L);

                map2.merge(d,1L, Long::sum);

                map.put(b-c, map2);
            }
        }
        return ans;

    }
    static final List<Integer> PRIMES = getPrimesLe(31623);
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


    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] g = new int[n][2];
        for (int i = 0; i < n; i++) {
            g[i][0] = nums[i];
            g[i][1] = i;
        }
        Arrays.sort(g,(a,b)->(a[0] - b[0]));
        for (int i = 0; i < n; i++) {
            int j = i+1;
            List<Integer> list = new ArrayList<Integer>();
            list.add(g[i][1]);
            while (j<n && g[j][0] - g[j-1][0]<=limit){
                list.add(g[j][1]);
                j++;
            }
            list.sort((a,b)->a-b);
            for (int k = i; k < j; k++) {
                nums[list.get(k-i)] = g[k][0];
            }
            i = j-1;
        }
        return nums;
    }



}
