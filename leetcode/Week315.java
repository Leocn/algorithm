package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Week315 {
    public static void main(String[] args) {

    }

    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                continue;
            }
                if(set.contains(-nums[i])){
                    ans = Math.max(ans, Math.abs(nums[i]));
                }

            set.add(nums[i]);
        }
        return ans;
    }


    public int countDistinctIntegers(int[] nums) {
        Set<Integer> ans = new HashSet<>();
        for(int num: nums){
            ans.add(num);
            int d = 0;
            int rev = 0;
            while (num != 0) {
                //判断是否超出规定范围
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    return 0;
                }
                //取余
                int digit = num % 10;
                num /= 10;
                rev = rev * 10 + digit;
            }
            ans.add(rev);
        }
        return  ans.size();
    }


    public boolean sumOfNumberAndReverse(int num) {
        if(num==0){
            return true;
        }
        for(int i=1; i<num; i++){
            int rev = 0;
            int x = i;
            //while 循环取余
            while (x != 0) {

                //判断是否超出规定范围
                if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                    break;
                }
                //取余
                int digit = x % 10;
                x /= 10;
                rev = rev * 10 + digit;
            }
            if(rev+i==num){
                return true;
            }

        }
        return false;

    }


    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int loc = -1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]>maxK || nums[i]< minK){
                continue;
            }else {
                loc = i;
                List<Integer> a = new ArrayList<>();
                List<Integer> b = new ArrayList<>();
                while (i<n && nums[i]<= maxK && nums[i]>=minK){
                    if(nums[i]== maxK){
                        a.add(i);
                    }
                    if(nums[i]== minK){
                        b.add(i);
                    }
                    if(a.size()>0 && b.size()>0){
                        ans += Math.min(a.get(a.size()-1), b.get(b.size()-1))-loc +1;
                    }

                    i++;

                }
            }
        }
        return ans;
    }
}
