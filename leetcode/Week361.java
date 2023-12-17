package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Week361 {
    public static void main(String[] args) {

    }

    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high ; i++) {
            if(check(i)){
                ans++;
            }
        }
        return ans;
    }
    private boolean check(int a){
        if((a+"").length()%2==1){
            return false;
        }
        int n = (a+"").length()/2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a%10;
            a /=10;
        }
        for (int i = 0; i < n; i++) {
            sum -= a%10;
            a/=10;
        }
        return sum==0;
    }


    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int c = 0;
        for (int num : nums) {
            if (num % modulo == k) c++;
            int m = (c - k) % modulo;
            ans += map.getOrDefault(m, 0);
            map.merge(c % modulo, 1, Integer::sum);

        }
        return ans;
    }
}
