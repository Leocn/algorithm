package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 天堂硅谷专场
 * */
public class TTGG {
    public static void main(String[] args) {

    }

    public int lastMaterial(int[] material) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for(int n : material){
            queue.add(n);
        }
        while (queue.size()>=2){
            int p = queue.poll();
            int q = queue.poll();
            if(p==q){
                continue;
            }
            queue.add(Math.abs(q-p));
        }
        return queue.size()==0?0:queue.poll();
    }


    public int longestESR(int[] sales) {
        int ans = 0;
        int n = sales.length;
        if(n==1){
            return sales[0]>8?1:0;
        }
        int sum = 0;
        int right =0;
        for (int i = 0; i <n; i++) {
            while ((i == right) || right<n&& sum>0){
                sum += (sales[right]>8?1:-1);
                right++;
            }
            if(right-i!=1){
                ans = Math.max(ans, right-i-1);
            }
            sum -= (sales[i]>8?1:-1);
        }

        sum = 0;
        right =0;
        for(int i = 0; i<=n/2;i++){
            int t = sales[i];
            sales[i] = sales[n-i-1];
            sales[n-i-1] = t;
        }
        for (int i = 0; i <n; i++) {
            while ((i == right) || (right<n&& sum>0)){
                sum += (sales[right]>8?1:-1);
                right++;
            }
            if(right-i!=1){
                ans = Math.max(ans, right-i-1);
            }
            sum -= (sales[i]>8?1:-1);
        }


        return  ans;

    }

}
