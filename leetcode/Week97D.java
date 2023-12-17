package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Week97D {
    public static void main(String[] args) {

    }

    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> in = new ArrayList<>();
            while (num>=10){
                in.add(num%10);
                num/=10;
            }
            if(num!=0){
                in.add(num);
            }
            Collections.reverse(in);
            ans.addAll(in);
        }
        int[] res =new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int s = 1;
        int ans = 0;
        int sum =0;
        int loc = 0;
        while (sum<maxSum&& s<=n){
            while (loc<banned.length &&banned[loc] == s){
                s++;
                loc++;
            }
            if(sum +s <=maxSum){
                ans++;
                sum+=s;
                s++;

            }else {
                break;
            }
        }
        return ans;
    }

//    public int maximizeWin(int[] prizePositions, int k) {
//        int n = prizePositions.length;
//        int[] loc = new int[n];
//        int[] max = new int[n];
//        loc[n-1] = n-1;
//
//        int st = n-1;
//        int end = n-1;
//        int m = 0;
//        while (st>=0){
//            while (st>=0 &&  prizePositions[end] - prizePositions[st] <= k){
//                loc[st] = end;
//                m =
//                st--;
//            }
//            end--;
//        }
//        int ans = 0;
//
//
//    }
}
