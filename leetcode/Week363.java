package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Week363 {
    public static void main(String[] args) {
        System.out.println(2 | 5 );
        System.out.println(2 | 5 ^ 5);

        System.out.println(areNumbersAscending("4 5 11 26"));
        System.out.println(countMaxOrSubsets(new int[]{3,2,1,5}));
    }

    public static boolean areNumbersAscending(String s) {

        int before =0 ;
        for (int i = 0; i < s.length(); i++) {
            int endIndex;
            if(s.charAt(i)>=49 && s.charAt(i)<=57){
                endIndex = i+1;
                while (endIndex<s.length() &&s.charAt(endIndex)>=48 && s.charAt(endIndex)<=57 ){
                    endIndex++;
                }
                int newBefore = Integer.parseInt(s.substring(i,endIndex));
                System.out.println(newBefore);
                if(newBefore>before){
                    before = newBefore;
                    i=endIndex-1;

                } else {
                    return false;
                }

            }
        }

        return true;
    }


    public static int countMaxOrSubsets(int[] nums) {

        TreeMap<Integer,Integer> treeMap= new TreeMap<>();

        backtracking(treeMap , 0,nums, 0);

        return treeMap.get(treeMap.lastKey());

    }
    private static void backtracking(TreeMap<Integer,Integer> treeMap, int sum,
                                     int[] nums, int index ){
        if(treeMap.get(sum)!=null){
            treeMap.put(sum,treeMap.get(sum)+1);
        }else {
            treeMap.put(sum,1);
        }

        for (int i = index; i < nums.length; i++) {
            int tem = sum;
            sum = sum | nums[i];

            backtracking(treeMap, sum, nums, i+1);
            sum =tem;
        }

    }
//    public static List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(nums.length == 0 ) return res;
//        LinkedList<Integer> list = new LinkedList<>();
//        backtracking(list, res, nums,0);
//        return res;
//    }
//
//    private static void backtracking(LinkedList<Integer> list, List<List<Integer>> res,
//                                     int[] nums, int index){
//        res.add(new ArrayList<>(list));
//
//        for (int i = index; i < nums.length; i++) {
//            list.add(nums[i]);
//            backtracking(list, res, nums, i+1);
//            list.removeLast();
//        }
}
