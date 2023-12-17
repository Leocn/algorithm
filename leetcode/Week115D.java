package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week115D {
    public static void main(String[] args) {

    }
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        int cnt = 0;
        for(String str: words){
            if(str.equals("prev")){
                cnt ++;
                if(cnt>r.size()){
                    ans.add(-1);
                }else {
                    ans.add(r.get(r.size()-cnt));
                }
            }else {
                cnt = 0;
                r.add(Integer.valueOf(str));
            }
        }
        return ans;
    }

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String w = words[i];
            int s =w.length();
            if(map.containsKey(s)){
                map.get(s).add(i);
            }else {
                List<Integer>  l = new ArrayList<>();
                l.add(i);
                map.put(s, l);
            }
        }
        List<String> ans = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            List<Integer> list = e.getValue();
            Map<Integer, List<String>> cnt = new HashMap<>();
            for(int i=0; i<list.size(); i++){
                int c = 0;
                List<String> res = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    int a = list.get(i);
                    int b = list.get(j);
                    char[] arr1 = words[a].toCharArray();
                    char[] arr2 = words[b].toCharArray();
                    if(groups[a] == groups[b]) continue;
                    int dif = 0;
                    for (int k = 0; k < arr1.length; k++) {
                        if(arr1[k]!=arr2[k]){
                            dif++;
                        }
                    }
                    if(dif==1){
                        if(c<cnt.get(j).size()) {
                            res = cnt.get(j);
                            c = res.size();
                        }
                    }

                }
                res.add(words[i]);
                cnt.put(i, res);
                if(res.size()>ans.size()){
                    ans = res;
                }


            }

        }
        return ans;
    }

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        int mod = (int) 1e9+7;
        int[] dp = new int[r+1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            map.merge(num, 1, Integer::sum);
        }
        dp[0] = 1;
        int c0 = map.getOrDefault(0,0);
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int k = e.getKey();
            int c = e.getValue();
            if(k==0) continue;
            for (int i = k; i <=r ; i++) {
                dp[i] += dp[i-k];
                dp[i] %= mod;
            }
            for(int i=r; i>= (c+1)*k; i--){
                dp[i] -= dp[i-(c+1)*k];
                dp[i] %= mod;
            }
        }
        long ans = 0;
        for(int i=l; i<=r; i++){
            ans += dp[i];
            ans%=mod;
        }
        ans = ans* (c0+1)%mod;

        return (int)ans;

    }
}


