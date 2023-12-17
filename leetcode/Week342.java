package com.example.demo.leetcode;

public class Week342 {
    public static void main(String[] args) {

    }
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int ans = (arrivalTime + delayedTime)%24;
        return ans;
        }
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <=n ; i++) {
            if((i%3)==0 || (i%5)==0 || (i%7)==0){
                ans += i;
            }
        }
        return ans;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        int[] cnt = new int[101];
        for (int i = 0; i < k; i++) {
            cnt[nums[i]+50]++;
        }
        int rem = x;
        for (int i = 0; i <50; i++) {

            if(cnt[i]>0){
                if(cnt[i]>=rem){
                    ans[0] = i-50;
                    break;
                }else {
                    rem-= cnt[i];
                }
            }
        }
        rem = x;
        for (int i = k; i <n ; i++) {
            cnt[nums[i]+50]++;
            cnt[nums[i-k]+50]--;
            for (int j = 0; j <50; i++) {

                if(cnt[j]>0){
                    if(cnt[j]>=rem){
                        ans[0] = j-50;
                        break;
                    }else {
                        rem-= cnt[j];
                    }
                }
            }
            rem = x;
        }
        return ans;
    }


    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==1){
                cnt++;
            }
        }
        if(cnt>0){
            return n-cnt;
        }
        int g = nums[0];
        for (int i = 1; i < n; i++) {
            g= gcd(g,nums[i]);
        }
        if(g>1){
            return -1;
        }
        int min = n;
        for (int i = 0; i < n; i++) {
            int s = nums[i];
            for (int j = i+1; j <n ; j++) {
                s= gcd(s, nums[j]);
                if(s==1){
                    min = Math.min(min, j-i);
                }
            }
        }
        return n + min -1;
    }
    private static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

}
