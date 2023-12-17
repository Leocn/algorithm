package com.example.demo.leetcode;

import java.util.*;

public class Week80D {

    /*
    * 它有至少 8 个字符。
至少包含 一个小写英文 字母。
至少包含 一个大写英文 字母。
至少包含 一个数字 。
至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。
    * */
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8 ){
            return  false;
        }
        boolean a=false, b=false, d=false, f =false;
        int n = password.length();
        char[] cs= password.toCharArray();
        for(int i=0; i<n; i++){
            char c = cs[i];
            if(c>='a' && c<='z'){
                a = true;
            }
            if(c>='A' && c<='Z'){
                b = true;
            }
            if(c>='0' && c<='9'){
                f = true;
            }
            if(c=='!' || c=='@' || c=='#' || c=='$' || c=='%' || c=='^' || c=='&' || c=='*' || c=='(' || c==')' || c== '-' || c=='+'){
                d = true;
            }
            if(i>0 && cs[i]== cs[i-1]){
                return  false;
            }

        }
        return  a&b&f&d;

    }


    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;

        int[][] s = new int[n][2];
        for(int i = 0; i<n; i++){
            s[i][0] = spells[i];
            s[i][1] = i;
        }
        Arrays.sort(s, (a,b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(potions);

        int[] res = new int[n];
        int fir = m-1;
        for(int i =0 ;i<n; i++ ){
            while (fir >=0 && (long) s[i][0] * potions[fir] >= success){
                fir--;
            }
            res[s[i][1] ] = m-1 - fir;
        }
        return res;
    }


    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        int[][] record = new int[200][200];
        for(char[] m : mappings){
            record[m[1]-'0'][m[0]-'0'] = 1;
        }
        int n = s.length();
        int d = sub.length();
        for(int i=0; i<n-d+1; i++){
            int cnt = 0;
            for(int j=0; j<d; j++){
                cnt++;
                char c = s.charAt(i+j);
                if(sub.charAt(j) != c && record[c-'0'][sub.charAt(j)-'0']==0){
                    cnt--;
                }
            }
            if(cnt == d){
                return true;
            }
        }
        return  false;
    }


    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long[] sum  = new long[n+1];
        for(int i =0; i<n; i++){
            sum[i+1] = sum[i] + nums[i];
        }

        long ans = 0;
        for(int i=0; i<n;i++){
            int end = n;
            int left = i;
            while (left< end){
                int mid = left+end>>1;
                long res = (sum[mid+1]- sum[i]) *(mid-i+1);
                if( res>=k ){
                    end = mid;
                }else{
                    left = mid+1;
                }
            };
            ans += end-i;
        }
        return ans;



    }


}
