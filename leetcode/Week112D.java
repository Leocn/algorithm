package com.example.demo.leetcode;

import com.example.demo.codeforces.CF429.B;

import java.math.BigInteger;
import java.util.*;

public class Week112D {
    public static void main(String[] args) {

    }

    public boolean canBeEqual(String s1, String s2) {
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i <a.length ; i++) {
            if(i%2==0){
                a1[a[i]-'a']++;
                a1[b[i]-'a']--;
            }else {
                a2[a[i]-'a']++;
                a2[b[i]-'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if(a1[i]!=0) return false;
            if(a2[i]!=0) return false;
        }
        return true;
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long ans = Long.MIN_VALUE;
        long now = 0;
        int n = nums.size();
        int st = 0;
        for (int i = 0; i < n; i++) {

             int key = nums.get(i);
            map.put(key,map.getOrDefault(key,0)+1);
            now += key;
            if(i-st+1==k){
                if(map.size()>=m){
                    ans = Math.max(ans, now);
                }
                int d = nums.get(st);
                if(map.get(d)==1){
                    map.remove(d);
                }else {
                    map.put(d, map.get(d)-1);
                }

                now -= d;
                st++;

            }
        }
        return ans;
    }
    public int countKSubsequencesWithMaxBeauty(String s, int k) {
        long ans = 1;
        int[] cnt = new int[26];
        int MOD = (int)1e9+7;
        int sum = 0;
        for(char c: s.toCharArray()){
            int a = c-'a';
            if(cnt[a]==0) sum++;
            cnt[a]++;
        }
        if(k>sum){
            return 0;
        }

        Arrays.sort(cnt);
        List<Integer> list = new ArrayList<>();
        list.add(cnt[25]);
        List<Integer> list2 = new ArrayList<>();
        int c = 1;
        for (int i = 24; i >=0; i--) {
            if(c==k){
                while (i>0 && cnt[i+1]==cnt[i]){
                    list.add(cnt[i]);
                    i--;
                }
                break;
            }
            if (cnt[i] != cnt[i + 1]) {
                list2.addAll(list);
                list = new ArrayList<>();
            }
            list.add(cnt[i]);
            c++;
        }
        for (int i = 0; i < list2.size(); i++) {
            ans = ans* list2.get(i)%MOD;
            k--;
        }

        int f = list.size();
        BigInteger b = new BigInteger("1");
        BigInteger h = new BigInteger("1");
        for (int i = 1; i <=k ; i++) {
            b = b.multiply(new BigInteger(i+""));
            h = h.multiply(new BigInteger((f-i+1)+""));
            ans = ans*list.get(0)%MOD;
        }
        h = h.divide(b).mod(new BigInteger(MOD+""));
        ans = ans * h.intValue()%MOD;

        return (int) ans;




    }

}
