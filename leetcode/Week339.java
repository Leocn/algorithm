package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Week339 {
    public static void main(String[] args) {

    }
    public int findTheLongestBalancedSubstring(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        int ans = 0;
        out: for (int i = 0; i < n; i++) {
            int cnt0 = 0, cnt1 = 0;

            if(cs[i] == '1'){
                continue;
            }
            cnt0++;

            for (int j = i+1; j <n ; j++) {
                if(cs[j]=='0'){
                    if(cnt1>0){
                        continue out;
                    }else {
                        cnt0++;
                    }
                }else {
                    cnt1++;
                }
                if(cnt1 == cnt0){
                    ans = Math.max(ans, cnt1+cnt0);
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        int[] cnt = new int[201];
        for(int n: nums){
            cnt[n]++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (true){
            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=200; i++){
                if(cnt[i]>0){
                    list.add(i);
                    cnt[i]--;
                }
            }
            if(list.size()==0) break;
            ans.add(list);
        }
        return  ans;

    }

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[][] arr  = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = reward1[i];
            arr[i][1] = reward2[i];
        }
        Arrays.sort(arr, (a,b)-> b[0] - b[1] - (a[0]-a[1]));
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i][0];
        }
        for (int i = k; i <n ; i++) {
            sum += arr[i][1];
        }
        return sum;
    }
}
