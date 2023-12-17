package com.example.demo.leetcode;

import java.util.*;

public class Week325 {

    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = Integer.MAX_VALUE;
        for (int i = startIndex; i <=2*n+startIndex ; i++) {
            String s = words[(i ) % n];
            if(s.equals(target)){
                ans = Math.min(n - Math.abs(startIndex-(i ) % n), ans);
                ans = Math.min(Math.abs(startIndex-(i ) % n), ans);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }


    public int takeCharacters(String s, int k) {
        int n = s.length();
        int[][] cntPre = new int[n+1][3];
        int[][] cntN = new int[n+1][3];
        char[] cs= s.toCharArray();
        for (int i = 0; i < n; i++) {
            cntPre[i+1] = cntPre[i];
            cntPre[i+1][cs[i]-'a']++;
        }

        for (int i = n-1; i >=0 ; i--) {
            cntN[i] = cntN[i+1];
            cntN[i][cs[i]-'a']++;
        }
        int ans = Integer.MAX_VALUE;
        int right = n-1;
        for (int i = 0; i <=n; i++) {
            if(cntPre[i][0] >=k && cntPre[i][1] >=k &&cntPre[i][2] >=k){
                ans  = i;
                break;
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        int left = ans;
        while (right>= n-k){
            while (left>=0 &&cntN[right][0] + cntPre[left][0]>=k  &&  cntN[right][1] + cntPre[left][1]>=k  &&cntN[right][2] + cntPre[left][2]>=k) {
                System.out.println(left + " " + right );
                ans = Math.min(left+ n-right, ans);
                left--;
            }

            right--;
        }
        return ans +1;


    }



    public int maximumTastiness(int[] a, int m) {
        Arrays.sort(a);
        int n = a.length;
        int left =0, right = (int)1e9+1;
        while (left<right){
            int cnt = 1, k = 0;
            int mid = (left + right + 1) / 2;
            for (int i = 1; i < n; ++i) {
                if (a[i] - a[k] >= mid) {
                    k = i;
                    ++cnt;
                }
            }
            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return right;
    }


}
