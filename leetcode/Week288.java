package com.example.demo.leetcode;

import java.util.*;

public class Week288 {

    public int largestInteger(int num) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        int tem = num;
        while (num>0){
            int t= num%10;
            if(t%2==0){
                list.add(t);
            }else {
                list1.add(t);
            }
            num /= 10;
        }
        Collections.sort(list);
        Collections.sort(list1);
        int ans = 0;
        int d = 1;
        int loc = 0, loc1 = 0;
        while (tem>0){
            int t= tem%10;
            if(t%2==0){
                ans += list.get(loc++) *d;
            }else{
                ans += list1.get(loc1++)*d;
            }
            d*=10;
            tem /= 10;
        }
        return ans;
    }


    public String minimizeResult(String expression) {
        int n = expression.length();
        int loc = 0;
        int ans = 0;
        String s = "("+ expression+")";
        for (int i = 0; i < n; i++) {
            if(expression.charAt(i)=='+'){
                loc = i;
                int t = Integer.parseInt(expression.substring(0, loc))+  Integer.parseInt(expression.substring(loc+1));
                ans = t;

            }
        }
        for (int i = 0; i < loc; i++) {
            for (int j = loc+2; j <=n ; j++) {
                int pre =1;
                if(expression.substring(0, i).length()!=0){
                    pre = Integer.parseInt(expression.substring(0, i));
                }
                int nx = 1;
                if(expression.substring(j).length()!=0){
                    nx = Integer.parseInt(expression.substring(j));
                }

                int res = pre *
                        ( Integer.parseInt(expression.substring(i,loc)) +Integer.parseInt(expression.substring(loc+1,j)))
                        *nx;
                if(res<ans){
                    StringBuilder sb = new StringBuilder(expression);
                    sb.insert(i,"(");
                    sb.insert(j+1,")");
                    s = sb.toString();
                    ans = res;
                }
            }
        }
        return s;
    }

    public int maximumProduct(int[] nums, int k) {
        int MOD = (int)1e9+7;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add((long)nums[i]);
        }
        while (k>0){
            long p = pq.poll();
            long t = 1;

            if(pq.size()!=0){
                if(pq.peek() != p){
                    t = Math.min(pq.peek() - p, k);
                }
            }else{
                t = k;
            }
            k-=t;
            p+=t;
            System.out.println(p);
            pq.add(p);
        }
        long ans =1;
        while (pq.size()>0){
            ans = ans*pq.poll()%MOD;
        }
        return (int) ans;
    }


    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;
        long[] sum = new long[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + flowers[i];
        }
        int loc = n-1;
        long cnt = 0;
        while (loc>=0 && flowers[loc]>=target){
            loc--;
            cnt ++;
        }
        long ans = (long) flowers[0] *partial + cnt*full;
        if(cnt==n){
            ans = cnt*full;
            return ans;
        }
        for (int i = loc; i >= 0; i--) {
            int left = 0, right = i+1;
            while(left<right){
                int mid = left+right>>1;
                long needFlower =  (long)mid * (flowers[mid]) - sum[mid];
                if(needFlower>newFlowers){
                    right = mid;
                }else {
                    left = mid+1;
                }

            }


            if(left==0){
                return ans;
            }
            long c = (sum[left] + newFlowers)/left;
            c= Math.min(target-1, c);
            ans = Math.max(ans, c*partial + cnt*full);

            if(newFlowers>=target - flowers[i]){
                newFlowers -= (target - flowers[i]);
                cnt++;
                if(cnt==n){
                    ans = Math.max(ans, cnt*full);
                }else{
                    ans = Math.max(ans, (long) flowers[0] *partial + cnt*full);
                }

            }else{
                return ans;
            }
        }
        return ans;
    }
}
