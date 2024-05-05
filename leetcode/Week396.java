package com.example.demo.leetcode;

import java.util.*;

public class Week396 {
    public static void main(String[] args) {

    }
    public boolean isValid(String word) {
        char[] cs = word.toLowerCase().toCharArray();
        int n = cs.length;
        if(n<3){
            return false;
        }
        boolean f1 = false;
        boolean f2 = false;
        for(char c: cs){
            if(   ! (c>='a' && c<='z')  && ! (c>='0' && c<='9')){
                return false;
            }
            if((c>='a' && c<='z')){
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u'){
                    f1 = true;
                }
                if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u'){
                    f2 = true;
                }
            }
        }
        return f1&f2;
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int ans = 0;
        int n = word.length();
        int t = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i+=k) {
            String s = word.substring(i,i+k);
            map.merge(s, 1 , Integer::sum);
            t = Math.max(map.get(s), t);
        }
        return n/k - t;
    }
    public int minAnagramLength(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        out:for (int i = 1; i < n/2; i++) {
            if(n%i != 0) continue;
            int[] cnt = new int[26];
            for (int j = 0; j <i; j++) {
                cnt[cs[j]-'a']++;
            }
            
            for (int j = i; j < n; j+=i) {
                int[] tar = new int[26];
                for (int k = j; k < j+i; k++) {
                    tar[cs[k]-'a']++;
                }
                for (int k = 0; k < 26; k++) {
                    if(cnt[k]!=tar[k]){
                        continue out;
                    }
                }

            }
            return i;
        }
        return n;
    }

    public int minCostToEqualizeArray(int[] nums, int c1, int c2) {
        int MOD = (int) 1e9+7;
        int n = nums.length;
        long max = 0;
        long sum = 0;
        long maxDiff = 0;
        long ans = Long.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        for(int num: nums){
            sum += max - num;
            maxDiff = Math.max(maxDiff, max - num);
        }
        if(n<=2 || 2*c1<= c2){
            return (int)(sum%MOD);
        }
        for (long i = max; i <=max+ max ; i++) {
            long total = 0;
            if(maxDiff >sum - maxDiff){
                total = (sum - maxDiff) * c2 + (2*maxDiff - sum)*c1;
            }else {
                total = sum/2 * c2 + sum%2 *c1;
            }
            ans = Math.min(total, ans);
            sum += n;
            maxDiff ++;
        }
        return (int)(ans%MOD);

    }

}
