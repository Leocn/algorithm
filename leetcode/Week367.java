package com.example.demo.leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Week367 {
    public static void main(String[] args) {

    }
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[]{-1,-1};
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i>= indexDifference){
                map.put( nums[i-indexDifference], i- indexDifference);
            }
            Integer l = map.floorKey(nums[i]-valueDifference);
            Integer h = map.ceilingKey(nums[i]+valueDifference);
            System.out.println(l );

            if(l!=null){
                return  new int[]{i, map.get(l)};
            }
            if(h!=null){
                return new int[]{i, map.get(h)};
            }
        }
        return ans;
    }


    public String shortestBeautifulSubstring(String s, int k) {
        List<String> list = new ArrayList<>();
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = i; j <n ; j++) {
                if(cs[j]=='1'){
                    c++;
                }
                if(c==k){
                    list.add(s.substring(i,j+1));
                }
            }
        }
        if(list.size()==0){
            return "";
        }
        Collections.sort(list, (a, b)->{
            if(a.length() == b.length()){
                return  a.compareTo(b);
            }else {
                return a.length()-b.length();
            }
        });
        return list.get(0);
    }


    static {

    }






}
