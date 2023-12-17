package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week374 {
    public static void main(String[] args) {

    }

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> ans = new ArrayList<>();
        int n = mountain.length;
        for (int i = 1; i < n-1; i++) {
            if(mountain[i]>mountain[i-1] && mountain[i]>mountain[i+1]){
                ans.add(i);
            }
        }
        return ans;
    }

    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int s = 0, loc = 0, n = coins.length, ans = 0;
        while (s<=target){
            if(loc < n && coins[loc] <= s+1){
                s += coins[loc++];
            }else {
                ans++;
                s += s+1;
            }
        }
        return ans;
    }
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        char[] cs = word.toCharArray();
        int pre = 0, ans = 0;
        for (int i = 1; i < n; i++) {
            if(Math.abs(cs[i]-cs[i-1])>2){
                ans += cal(word.substring(pre, i), k);
                pre = i;
            }
        }
        ans += cal(word.substring(pre,n), k);
        return ans;
    }
    private int cal(String s, int k){
        int ans = 0, n = s.length();
        char[] cs = s.toCharArray();
        char[][] cnt = new char[n+1][26];
        for (int i = 0; i < n; i++) {
            System.arraycopy(cnt[i], 0, cnt[i + 1], 0, 26);
            cnt[i+1][cs[i]-'a']++;
        }
        for (int i = 0; i < n; i++) {
            out:for (int j = 1; j <=26;j++) {
                int x = i+k*j;
                if(x>n){
                    break;
                }
                for (int l = 0; l < 26; l++) {
                    if(cnt[x][l] - cnt[i][l] != k){
                        continue out;
                    }
                }
                System.out.println(111);
                ans++;
            }
        }
        return ans;
    }

    static int mod = (int)1e9+7;
    static long[] fac = fac(100005, mod);
    static long[] facR = facR(100005, mod);
    public int numberOfSequence(int n, int[] sick) {

        int m = sick.length;
        int k = n - m;
        long ans = comb(k, sick[0]) * comb(k-sick[0],(n-1-sick[m-1])) %mod;
        k -= sick[0] + (n-1-sick[m-1]);
        int sum = 0;
        for (int i = 1; i < m ; i++) {
            int d = sick[i] - sick[i-1] - 1;
            if(d>0){
                ans = ans * comb(k, d)%mod;
                sum += d - 1;
                k -= d;
            }
        }
        ans = ans*pow(2, sum, mod) % mod;

        return  (int)ans;
    }

    private static long comb(int a, int b) {
        if (a < b) return 0;
        return combine(a, b, mod);
    }
    //递推求阶乘
    static long[] fac(int n, long p) {
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * i % p;
        }
        return f;
    }

    //facR
    static long[] facR(int n, long p) {
        long[] fr = new long[n + 1];
        fr[n] = pow(fac[n], p - 2, p) ;
        for (int i = n-1; i>=0 ; i--) {
            fr[i] = fr[i + 1] * (i+1) % p;
        }
        return fr;
    }

    //快速幂 x^k mod p
    static long pow(long x, long k, long p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) != 0) res = res * x % p;
            x = x * x % p;
            k >>= 1;
        }
        return res;
    }


    //公式法求组合数 O(NlogP)  结合逆元  求  C(a,b) mod p      a!/(b! (a-b)!)   1≤b≤a≤10^5
    static long combine(int a, int b, int p) {
        //先预处理出阶乘   然后 每次 常数时间求解
        return (fac[a] * facR[b] % p) * facR[a - b] % p;
    }
}
