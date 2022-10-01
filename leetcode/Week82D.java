package com.example.demo.leetcode;

import java.util.*;

/**
 * 82场双周赛
 * */
public class Week82D {
    public static void main(String[] args) {

        System.out.println(latestTimeCatchTheBus(
                new int[]{681,8843,5710,7128,1333,1604,7132,4318,3566,6784,2635,4996,2002,8109,5716,9131,5859,9650,8402,9580,976,7515,5422,5844,9704,3616,2442,6688,4227,2081,4071,5008,7575,773,5528,6847,2188,556,1981,9574,7704,2548,7904,6985,2903,172,2087,7878,1871,4235,7770,3696,152,3357,101,3945,5678,7372,5183,1984,9113,5992,7530,562,5090,7172,7085,2956,9935,7496,1606,3790,4191,3396,2702,2277,3569,9558,8499,3505,9723,1227,5269,2657,7176,5436,5275,6766,8236,723,3833,4354,9118,8634,4047,8261,9104,1869,4043,776},
                new int[]{1156,7190,185,740,2824,3297,2104,6567,7946,2909,1163,5130,1933,2891,3924,6385,8209,2745,1743,6464,3152,5021,3926,5395,625,1538,4384,8653,2364,5641,4700,4946,56,2463,1330,7228,6902,6281,4148,8338,3602,1401,1788,8287,7144,5716,1901,6028,8751,1339,9003,1010,7397,3717,3662,5509,7786,3938,4115,4017,5957,1843,9727,9865,5456,2200,833,6042,2753,3418,7176,5734,7410,8829,8173,5805,534,4259,9619,6650,8046,5698,1180,9409,4036,1618,2192,7272,9194,8163,860,3844,1651,9512,2687,935,3015,3402,6195,8757,27681,16093,26234,12585,14068,11592,20330,28810},
                1
        ));
        System.out.println(minSumSquareDiff(
                new int[]{11,12,13,14,15},
                new int[]{13,16,16,12,14},
                3,
                6

        ));
        System.out.println(validSubarraySize(
                new int[]{1,3,4,3,1},
                6
        ));

    }

    public boolean evaluateTree(TreeNode root) {
        if(root.val==0 ){
            return false;
        }
        if(root.val==1){
            return true;
        }
        if(root.val==2){
            return evaluateTree(root.left) || evaluateTree(root.right);
        }
        if(root.val==3){
            return evaluateTree(root.left) && evaluateTree(root.right);
        }
        return true;
    }


    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0;
        Deque<Integer> list = new ArrayDeque<>();
        int end = 0;
        int c = 0;
        for(int b: buses){
            c = capacity;

            while (list.size()>0 && c>0){
                end = list.poll();
                c--;
            }
            while(index<passengers.length && passengers[index]<=b && c>0){

                end = passengers[index];
                c--;
                index++;

            }
            while(index<passengers.length &&passengers[index]<=b){
                list.add(passengers[index]);
                index++;
            }
        }
        if(c>0 && end!=buses[buses.length-1]){
            return buses[buses.length-1];
        }
        for(int i =0; i<passengers.length; i++){
            if(passengers[i]==end){
                while(i>0 && passengers[i] - passengers[i-1] ==1){
                    i--;
                }
                return passengers[i]-1;
            }
        }
        return 0;

    }


    public static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] minus = new int[n+1];
        for(int i=1; i<=n; i++){
            minus[i] = Math.abs(nums1[i-1]-nums2[i-1]);
        }
        Arrays.sort(minus);
        int sum = k1+k2;
        int count =1;
        for(int i= n; i>0; i--){
            if(sum>=(minus[i]-minus[i-1])* count){

                sum -= (minus[i]-minus[i-1])* count;
                count++;
                minus[i] = minus[i-1];
            }else{
                int x = sum/(n-i+1);
                int left = sum%(n-i+1);

                int tem =  minus[i];
                for(int j = i;j<=n;j++){
                    minus[j] = tem- x;
                }
                tem =  minus[i];
                for(int j = i;j<i+left;j++){
                    minus[j] = tem- 1;
                }
                break;
            }
        }

        if(sum>=0 && count ==n+1 ){
            return 0;
        }
        long ans = 0;
        for(int i=0; i<minus.length;i++){
            ans += (long )minus[i]*minus[i];
        }
        return ans;

    }


    /**
     单调栈，求每个位置左，右侧最靠近的比他小的数的位置
     */
    public static int validSubarraySize(int[] nums, int threshold) {
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] left = new int[n];
        //遍历左侧
        for(int i=0; i<n; i++){
            while(queue.size()!=0 && nums[queue.peek()]>= nums[i] ) {
                queue.pop();
            }
            left[i] = queue.size()==0? -1:queue.peek();
            queue.push(i);
        }
        queue = new ArrayDeque<>();
        int[] right = new int[n];
        //遍历右侧
        for(int i=n-1; i>=0; i--){
            while(queue.size()!=0 && nums[queue.peek()]>= nums[i] ) {
                queue.pop();
            }
            right[i] = queue.size()==0? n:queue.peek();
            queue.push(i);
        }

        for(int i=0; i<n; i++){
            int dis = right[i]-left[i]-1;
            if(nums[i]>threshold/dis){
                return dis;
            }
        }
        return -1;
    }

}
