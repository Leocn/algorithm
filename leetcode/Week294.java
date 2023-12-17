package com.example.demo.leetcode;

import java.util.*;

public class Week294 {
    public static void main(String[] args) {

    }
    public int percentageLetter(String s, char letter) {
        int ans  = 0;
        char[] cs = s.toCharArray();
        for(char c: cs){
            if(c==letter){
                ans++;
            }
        }
        return ans*100/s.length();
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int ans = 0;
        Arrays.sort(arr, Comparator.comparingInt(a -> (capacity[a] - rocks[a])));
        for(int i=0; i<n;i++){
            int t = arr[i];
            additionalRocks -=(capacity[t] - rocks[t]);
            if(additionalRocks>=0){
                ans ++;
            }else {
                break;
            }

        }
        return ans;
    }

    public int minimumLines(int[][] p) {
        int ans = 1;
        int n = p.length;
        Arrays.sort(p,Comparator.comparingInt(a->a[0]));
        for(int i = 2; i<n; i++){
            long a=p[i-2][0], b = p[i-2][1], c=p[i-1][0], d=p[i-1][1], e=p[i][0], f=p[i][1];
            if((e-c)*(d-b) != (c-a)*(f-d)){
                ans++;
            }

        }
        return ans;
    }

    int MOD = (int)1e9+7;
    public int totalStrength(int[] strength) {
        long ans = 0;
        int n = strength.length;
        long[] preSum = new long[n+1];
        long[] preSumSum = new long[n+2];
        for(int i =0; i<n; i++){
            preSum[i+1]  = (preSum[i] + strength[i])%MOD;
            preSumSum[i+2] = (preSumSum[i+1] + preSum[i+1])%MOD;
        }
        int[] left = new int[n+1];
        int[] right = new int[n+1];
        Arrays.fill(right, n);
        Arrays.fill(left, -1);
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        for(int i=1; i<n; i++){
            while(dq.size()>0 && strength[dq.peekLast()]>strength[i]){
                dq.pollLast();
            }
            if(dq.size()>0){
                left[i] = dq.peekLast();
            }
            dq.add(i);
        }
        dq = new ArrayDeque<>();
        dq.add(n-1);
        for(int i=n-2; i>=0; i--){
            while(dq.size()>0 && strength[dq.peekLast()]>=strength[i]){
                dq.pollLast();
            }
            if(dq.size()>0){
                right[i] = dq.peekLast();
            }
            dq.add(i);
        }
        for(int i=0;i<n; i++){
            int r = right[i], l = left[i];
            long tot =  (( (i-l)*(preSumSum[r+1]- preSumSum[i+1]) -(r-i)*(preSumSum[i+1] - preSumSum[l+1]) )%MOD )* strength[i] %MOD;

            //           int l = left[i] + 1, r = right[i] - 1; // [l,r] 左闭右闭

            // var tot = ((long) (i - l + 1) * (preSumSum[r + 2] - preSumSum[i + 1]) - (long) (r - i + 1) * (preSumSum[i + 1] - preSumSum[l])) % MOD;


            ans = (ans+tot)%MOD;
        }
        return (int)(ans+MOD)%MOD;
    }

}
