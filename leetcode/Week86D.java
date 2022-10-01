package com.example.demo.leetcode;

import java.util.*;

public class Week86D {
    public static void main(String[] args) {

    }
    public boolean findSubarrays(int[] nums) {
        Set<Long> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n-1 ; i++) {
            long sum = nums[i]+ nums[i+1];
            if(set.contains(sum)){
                return true;
            }else {
                set.add(sum);
            }
        }
        return false;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <=n-2 ; i++) {
            List<Integer> list = new ArrayList<>();
            int s = n;
            while (s>0){
                list.add(s%i);
                s = s/i;
            }

            int right =list.size()-1;
            int left =  0 ;
            while(left<right){
                if(list.get(left)!= list.get(right)){
                    return false;
                }
                left++;
                right--;
            }

        }

        return true;
    }


    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 1; i < (1<<(n+1)) ; i++) {
            int[][] cp = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    cp[j][k] = mat[j][k];
                }
            }
            int[] count = new int[n];
            int d = i;
            int sum = Integer.bitCount(d);
//            for (int j = 0; j < n; j++) {
//
//                count[j] = (d>>j)&1;
//                if(count[j]==1){
//                    sum++;
//                }
//            }
            if(sum!=cols){
                continue;
            }
            for (int j = 0; j < n; j++) {
                if(count[j]==1){
                    for (int k = 0; k < m; k++) {
                        cp[k][j]=0;
                    }
                }

            }
            int res = 0;
            for (int j = 0; j < m; j++) {

                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if(cp[j][k]==1){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    res++;
                }

            }
            ans =Math.max(ans,res);

        }
        return ans;

    }


    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int n = chargeTimes.length;
        int ans = 0;
        int left = 0;
        int right =1;
        long sum =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        for ( ; right <=n ; right++) {
            queue.add(chargeTimes[right-1]);
            sum+= runningCosts[right-1];
            while (left<right && (right-left)*sum + queue.peek()>budget ){
                sum-= runningCosts[left];
                queue.remove(chargeTimes[left]);
                left++;

            }
            ans = Math.max(right-left, ans);
        }

        return ans;



    }

}
