package com.example.demo.leetcode;

import java.util.*;

public class Week368 {
    public static void main(String[] args) {
        System.out.println( maxDistance(new int[]{1,8,3,8,3}));
        System.out.println(wateringPlants(new int[]{5,6,2,7,8,4,4,1,6,4}, 10));
        System.out.println(kMirror(4,30));
    }
//[5,6,2,7,8,4,4,1,6,4]
//        10
    /**
     * 5930. 两栋颜色不同且距离最远的房子
     * */
    public static int maxDistance(int[] colors) {
        int r = colors.length-1;
        int l = 0;
        int lMax = 0;
        while (r>l){
            if(colors[r]!=colors[l]){
                lMax = r-l;
                break;
            };
            l++;
        }

         r = colors.length-1;
         l = 0;
        int rMax = 0;
        while (r>l){
            if(colors[r]!=colors[l]){
                rMax = r-l;
                break;
            };
            r--;
        }
        return Math.max(lMax,rMax);

    }

    /**
     * 5201. 给植物浇水
     * */
    public static int wateringPlants(int[] plants, int capacity) {
        int res = 0;
        int still = capacity;
        for (int i = 0; i < plants.length; i++) {
            int need = plants[i];
            still = still -need;
            if(i+1 <= plants.length-1 && still<plants[i+1]){
                still = capacity;
                res += 2*(i+1)+1;
            }else {
                res += 1;
            }

        }
        return res;
    }

    /**
     * 5186. 区间内查询数字的频率
     * */
    private class RangeFreqQuery {

        int[] arr;
        Map<Integer, List<Integer>> map;
        public RangeFreqQuery(int[] arr) {
            map = new HashMap<>();
            this.arr = arr;
            for (int i = 0; i < arr.length; i++) {
                if(map.containsKey(arr[i])){
                    List<Integer> q = map.get(arr[i]);
                    q.add(i);
                }else {
                    List<Integer> q = new ArrayList<>();
                    q.add(i);
                    map.put(arr[i], q);
                }
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> list = map.get(value);
            if (list == null) return 0;
            int l = binarySearch(list,left-1);
            int r = binarySearch(list,right);
            return Math.abs(r-l);
        }

        public int binarySearch(List<Integer> list, int target){
            int l = 0;
            int r = list.size()-1;
            int mid =0 ;

            while (l<=r){
                mid = (l+r)/2;
                int m = list.get(mid);
                if(m==target){
                    return mid;
                }else if(m<target){
                    l = mid+1;
                }else {
                    r = mid-1;
                }

            }

            return r;
        }

    }

    /**
     * 5933. k 镜像数字的和
     * */
    public static long kMirror(int k, int n) {
        long sum = 0;
        for (int i = 1; i < 10; i++) {
            if (kMirror(Long.toString(i, k))) {
                sum += i;
                if (--n == 0) {
                    return sum;
                }
            }
        }
        for (int i = 0;; i++) {
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                if (kMirror(Long.toString(Long.parseLong("" + j + new StringBuilder("" + j).reverse()), k))) {
                    sum += Long.parseLong("" + j + new StringBuilder("" + j).reverse());
                    if (--n == 0) {
                        return sum;
                    }
                }
            }
            for (int j = (int) Math.pow(10, i); j < (int) Math.pow(10, i + 1); j++) {
                for (int l = 0; l < 10; l++) {
                    if (kMirror(Long.toString(Long.parseLong("" + j + l + new StringBuilder("" + j).reverse()), k))) {
                        sum += Long.parseLong("" + j + l + new StringBuilder("" + j).reverse());
                        if (--n == 0) {
                            return sum;
                        }
                    }
                }
            }
        }
    }

    public static boolean kMirror(String s) {
        if(s.length()==0) return false;
        int left = 0;
        int right = s.length()-1;
        while(left<right ){
            char le = s.charAt(left);
            char ri = s.charAt(right);
            if( le!=ri){
                return false;
            }
            left++;
            right--;

        }
        return true;
    }


}
