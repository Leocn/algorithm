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
        for (int i = 2; i <= 1+dist ; i++) {
            if(i-2<k-2){
                s = leftAdd(pqBig, nums[i], s);
            }else {
                if(nums[i]<pqBig.firstKey()){
                    s = leftToRight(pqBig,pqSmall,nums[i],s);
                }else {
                    addElement(pqSmall, nums[i]);
                }
            }
        }
        long ans = s + nums[0] + nums[1];
        for (int i = 2; i < n-1-(k-2)+1; i++) {
            if(i+dist<n){
                if(nums[i+dist]<pqBig.firstKey()){
                    s = leftToRight(pqBig,pqSmall,nums[i+dist],s);
                }else {
                    addElement(pqSmall, nums[i+dist]);
                }
            }
            if(pqBig.containsKey(nums[i])){
                rightToLeft(pqBig, pqSmall, nums[i], s);
            }else {
                delElement(pqSmall, nums[i]);
            }

            ans = Math.min(s + nums[0] + nums[i], ans);
        }
        return ans;

    }

    private long leftToRight(TreeMap<Integer,Integer> pqBig,TreeMap<Integer,Integer> pqSmall, int x, long s){
        int key = pqBig.firstKey();
        delElement(pqBig, key);
        s -= key;
        s += x;
        addElement(pqBig, x);
        addElement(pqSmall, key);
        return s;
    }

    private long rightToLeft(TreeMap<Integer,Integer> pqBig,TreeMap<Integer,Integer> pqSmall, int x, long s){
        s-= x;
        delElement(pqBig, x);
        int key = pqSmall.firstKey();
        delElement(pqSmall, key);
        s+= key;
        addElement(pqBig, key);
        return s;
    }

    private long leftAdd(TreeMap<Integer,Integer> pqBig, int x, long s){
        addElement(pqBig, x);
        s += x;
        return s;
    }
    private void delElement(TreeMap<Integer,Integer> map, int key){
        int v = map.get(key);
        if(v == 1){
            map.remove(key);
        }else {
            map.put(key,v-1);
        }
    }

    private void addElement(TreeMap<Integer,Integer> map, int v){
        map.merge(v, 1, Integer::sum);
    }
}
