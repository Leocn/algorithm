package com.example.demo.leetcode;

import java.util.*;

public class Week416 {
    public static void main(String[] args) {

    }

    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for(String s: bannedWords){
            set.add(s);
        }
        int cnt = 0;
        for(String s: message){
            if(set.contains(s)){
                cnt++;
            }
        }
        return cnt>=2;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long ans = 0;
        long l = 0, r = (long)1e16;
        int n = workerTimes.length;
        while (l<r){
            long mid = (r - l)/2 + l;
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += d((mid/ workerTimes[i]));
            }
            if(cnt<mountainHeight){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    private long d(long f){
        long a = 0, b = f+1;
        while (a<b){
            long mid = a + b >> 1;
            if(f*2/(mid+1)>=mid){
                a = mid+1;
            }else {
                b = mid;
            }
        }
        return a-1;
    }

    public long validSubstringCount(String word1, String word2) {
        long ans = 0;
        char[] cs = word1.toCharArray();

        int[] cnt = new int[26];
        for(char c: word2.toCharArray()){
            cnt[c-'a']++;
        }
        int loc = 0;
        int n = cs.length;
        int[] now = new int[26];
        for (int i = 0; i < n; i++) {
            now[cs[i]-'a']++;
            while (check(now, cnt)){
                now[cs[loc]-'a']--;
                loc++;
            }
            ans += loc;
        }
        return ans;
    }
    private boolean check(int[] f, int[] t){
        for (int i = 0; i < f.length; i++) {
            if(f[i]<t[i]){
                return false;
            }
        }
        return true;
    }
}
