package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Week122D {
    public static void main(String[] args) {

    }
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int[] g = new int[n-1];
        for (int i = 1; i < n; i++) {
            g[i-1] = nums[i];
        }
        Arrays.sort(g);
        return nums[0] + g[0] + g[1];
    }

    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        int pre = -1;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cnt = Integer.bitCount(num);
            int loc = i;
            int min = num;
            int max = num;
            while (loc< n && Integer.bitCount(nums[loc]) == cnt){
                min = Math.min(min,nums[loc]);
                max = Math.max(max,nums[loc]);
                loc++;
            }
            if(min<pre){
                return false;
            }
            pre = max;
            i = loc-1;

        }
        return true;
    }

    public int minimumArrayLength(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int loc = 0;
        while (loc<n && nums[loc] == nums[0]){
            loc++;
        }
        int ans = loc;
        boolean f = false;
        for (int i = loc; i <n ; i++) {
            if(nums[i]%nums[0]!=0){
                f = true;
                break;
            }
        }
        if(f){
            return 1;
        }
        return (ans+1)/2;
    }

    /**
     * 对顶堆
     * @param nums
     * @param k
     * @param dist
     * @return
     */
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        TreeMap<Integer,Integer> pqBig = new TreeMap<>((a,b)->b-a);
        TreeMap<Integer,Integer> pqSmall = new TreeMap<>();
        long s = 0;
        int sizeL = 0;
        for (int i = 2; i <= 1+dist ; i++) {
            if(sizeL<k-2){
                pqBig.merge(nums[i], 1, Integer::sum);
                s += nums[i];
                sizeL++;
            }else {
                int x = nums[i];
                if(x<pqBig.firstKey()){

                    int p = pqBig.firstKey();
                    int v = pqBig.get(p);
                    if(v == 1){
                        pqBig.remove(p);
                    }else {
                        pqBig.put(p,v-1);
                    }
                    s -= p;
                    s += x;
                    pqBig.merge(x, 1, Integer::sum);
                    pqSmall.merge(p, 1, Integer::sum);
                }else {
                    pqSmall.merge(x, 1, Integer::sum);
                }
            }
        }
        long ans = s + nums[0] + nums[1];
        for (int i = 2; i < n-1-(k-2)+1; i++) {
            if(i+dist<n){
                int x = nums[i+dist];
                if(x<pqBig.firstKey()){

                    int p = pqBig.firstKey();
                    int v = pqBig.get(p);
                    if(v == 1){
                        pqBig.remove(p);
                    }else {
                        pqBig.put(p,v-1);
                    }
                    s -= p;
                    s += x;
                    pqBig.merge(x, 1, Integer::sum);
                    pqSmall.merge(p, 1, Integer::sum);
                }else {
                    pqSmall.merge(x, 1, Integer::sum);
                }
            }
            if(pqBig.containsKey(nums[i])){
                s-= nums[i];
                int v = pqBig.get(nums[i]);
                if(v == 1){
                    pqBig.remove(nums[i]);
                }else {
                    pqBig.put(nums[i],v-1);
                }

                int another = pqSmall.firstKey();
                int av = pqSmall.get(another);
                if(av == 1){
                    pqSmall.remove(another);
                }else {
                    pqSmall.put(another,av-1);
                }
                s+= another;
                pqBig.merge(another, 1, Integer::sum);
            }else {
                int v = pqSmall.get(nums[i]);
                if(v == 1){
                    pqSmall.remove(nums[i]);
                }else {
                    pqSmall.put(nums[i],v-1);
                }
            }

            ans = Math.min(s + nums[0] + nums[i], ans);
        }
        return ans;

    }

}
