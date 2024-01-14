package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Week380 {
    public static void main(String[] args) {

    }

    public int maxFrequencyElements(int[] nums) {
        int ans = 0;
        int[] cnt = new int[101];
        int max = 0;
        for(int num: nums){
            cnt[num]++;
            max = Math.max(cnt[num], max);
        }
        for(int c: cnt){
            if(c == max){
                ans += c;
            }
        }
        return ans;
    }
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> listA = new ArrayList<>();

        TreeSet<Integer> treeSet = new TreeSet<>();
        listA = KMP(s, a);
        treeSet = new TreeSet<>(KMP(s, b));
        for(int num: listA){
            Integer h = treeSet.ceiling(num-k);
            if(h!=null && Math.abs(h-num)<=k){
                ans.add(num);
            }
        }
        return ans;

    }


    /**
     * KMP
     * */
    public static int[] getNext(String p) {
        int[] next = new int[p.length()];
        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static List<Integer> KMP(String s, String p) {
        int[] next = getNext(p);
        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == p.length()) {
                res.add(i - p.length() + 1);
                j = next[j - 1];
            }
        }
        return res;
    }





    public long findMaximumNumber(long k, int x) {
        long l = 0, r  = (long) 1e16;
        while (l<r){
            long mid =  (r - l)/2 + l;
            long sum = get(mid, x);
            if(sum>k){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
    private long get(long mid, int x){
        if(mid == 1) return  1%x==0?1:0;
        if(mid == 0) return 0;
        String s = Long.toBinaryString(mid);
        s = new StringBuilder(s).reverse().toString();
        char[] cs = s.toCharArray();
        int n = cs.length;
        long res = 0;
        for (int i = 1; i <= n-1; i++) {
            if(i%x==0){
                res += (1L<<(n-2));
            }
        }
        if(n%x == 0){
            res += mid - (1L<<(n-1)) + 1;
        }
        res += get(mid - (1L<<(n-1)), x);
        return res;
    }
}
