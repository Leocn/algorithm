package com.example.demo.leetcode;

import java.util.*;

public class LC2022 {

    public static void main(String[] args) {

    }
//    public int minNumBooths(String[] demand) {
//    }


    public TreeNode expandBinaryTree(TreeNode root) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            TreeNode left = root.left;
            TreeNode next = new TreeNode(-1);
            root.left = next;
            next.left = expandBinaryTree(left);

        }
        if(root.right!=null){
            TreeNode right = root.right;
            TreeNode next = new TreeNode(-1);
            root.right = next;
            next.right = expandBinaryTree(right);

        }
        return root;

    }

//    public int beautifulBouquet(int[] flowers, int cnt) {
////        int n = 0;
////        for(int f: flowers){
////            n = Math.max(n, f);
////        }
////        int[] loc = new int[n+1];
////        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->{
////            return a.intValue() - b.intValue();
////        });
////        map.remove()
//    }

//    public int Leetcode(String[] words) {
//        int ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        char[] cs = "helloleetcode".toCharArray();
//        for(char c: cs){
//            map.put(c, map.getOrDefault(c, 0)+1);
//        }
//        int n  = words.length;
//        int[][] record = new int[n][2];
//
//
//        for(int i =0; i<n; i++){
//            String str = words[i];
//            cs = str.toCharArray();
//            int min = 0;
//            for(int j =0; j<cs.length;j++){
////                if()
//            }
//        }
//    }

//    public int[][] sandyLandManagement(int size) {
//        if
//    }


}
