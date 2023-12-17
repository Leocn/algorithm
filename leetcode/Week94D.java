package com.example.demo.leetcode;

import java.math.BigInteger;
import java.util.*;

public class Week94D {
    public static void main(String[] args) {

    }
    public int captureForts(int[] forts) {
        int ans = 0;
        int n = forts.length;
        for (int i = 0; i < forts.length; i++) {
            if(forts[i]!=-1) continue;
            int l = i-1;
            while (l>=0 && forts[l]==0) {
                l--;
            }
            if(l>=0 && forts[l]==1){
                ans = Math.max(ans, i-l-1);
            }
            int r = i+1;
            while (r<n && forts[r]==0) {
                r++;
            }
            if(r<n && forts[r]==1){
                ans = Math.max(ans, r-i-1);
            }
        }
        return ans;
    }

    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> setP = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> setN = new HashSet<>(Arrays.asList(negative_feedback));

        int n = report.length;
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String[] str = report[i].split(" ");
            int point = 0;
            for(String s: str){
                if(setP.contains(s)){
                    point +=3;
                }
                if(setN.contains(s)){
                    point --;
                }
            }
            arr[i] = new int[]{i, point,student_id[i]};
        }
        Arrays.sort(arr, (a,b)->{
            if(a[1]==b[1]){
                return  a[2] - b[2];
            }
            return b[1] - a[1];
        });
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <k ; i++) {
           ans.add(arr[i][2]);
        }
        return ans;
    }

    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        long lcm =divisor1 /gcd(divisor1, divisor2) * divisor2 ;
        long left = 0, right = (long)1e10+1;
        while(left < right){
            long mid = left+right>>1;
            long a = mid - mid/divisor1, b = mid- mid/divisor2, c = mid- mid/divisor1 -mid/divisor2 + mid/lcm;
            boolean flag = true;
            if(a<uniqueCnt1) flag = false;
            if(b<uniqueCnt2) flag = false;
            if(a+b-c <uniqueCnt1+uniqueCnt2) flag = false;
            if(flag){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return (int)left;
    }


    public static long gcd(long x, long y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }



    int MOD = (int)1E9+7;
    public int countAnagrams(String s) {
        String[] arr = s.split(" ");
        long ans = 1;
        for(String str : arr){
            int[] cnt = new int[26];
            int sum = 0;
            long res = 1;
            for(char c: str.toCharArray()){
                cnt[c-'a']++;
                sum++;
            }
            for (int i = 0; i < 26; i++) {
                if(cnt[i]!=0){
                    for(int j =0; j<cnt[i];j++){
                        res = res*(sum-j)%MOD;
                        res = res* (new BigInteger((j+1)+"").modInverse(new BigInteger(MOD+"")).intValue())%MOD;
                        //res = res*FermatInv(j+1,MOD)%MOD;
                    }
                    sum -= cnt[i];
                }
            }
            ans = ans* res%MOD;
        }
        return (int)ans;
    }

    static long PowMod(long a, long n, long mod)
    {
        long ret = 1;
        while(n>0)
        {
            if((n & 1)>0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }
    //求a对mod的逆元
    static long FermatInv(long a, long mod)
    {
        return PowMod(a, mod - 2, mod);
    }

}
