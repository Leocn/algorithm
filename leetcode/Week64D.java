package com.example.demo.leetcode;

import java.util.*;

public class Week64D {


    public static void main(String[] args) {
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"},2));
        System.out.println(maxTwoEvents(new int[][]{{1,5,3},{1,5,1},{6,6,5}}));
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2, 5}, {5, 9}})));
    }

    public static String kthDistinct(String[] arr, int k) {
        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (String s: arr) {
            if(!set.contains(s)){
                set.add(s);
                list.add(s);
            }else {
                list.remove(s);
            }

        }
        if(list.size()<k){
            return "";
        }else {
            return list.get(k-1);
        }
    }

    public static int maxTwoEvents(int[][] events) {
        int max = 0;
        for (int i = 0; i < events.length; i++) {
            max = Math.max(max,events[i][2]);
            int sMax= 0;
            for (int j = i+1; j < events.length; j++) {
                if( events[j][2] >sMax && (events[i][0]>events[j][1] || events[j][0]>events[i][1])){
                    sMax = events[j][2] ;
                }
            }
            max = Math.max(sMax + events[i][2], max);
        }
        return max;
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        char[] sA = s.toCharArray();
        //0,i离i最近的|的位置
        int[] a1 = new int[n+1];
        //i,n-1离i最近的|的位置
        int[] a2 = new int[n+1];
        //0,i 区间内 | 的数量
        int[] a3 = new int[n+1];

        for (int i = 1; i <= n; i++) {
            if(sA[i-1]=='|'){
                a3[i] = a3[i-1]+1;
            }else {
                a3[i] = a3[i-1];
            }
        }

        int lastIndex = 0;
        for (int i = 1; i <= n; i++) {
            if(sA[i-1]=='|'){
                a1[i] = i;
                lastIndex = i;
            }else {
                a1[i] = lastIndex;
            }
        }

        int nextIndex = Integer.MAX_VALUE;
        for (int i = n; i >=1; i--) {
            if(sA[i-1]=='|'){
                a2[i] = i;
                nextIndex = i;
            }else {
                a2[i] = nextIndex;
            }
        }

        int[]  res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if(a1[queries[i][1]+1] == 0 ||  a2[queries[i][0]+1] == Integer.MAX_VALUE || a1[queries[i][1]+1] - a2[queries[i][0]+1]-1   <=0){
                res[i] = 0;
            }else {
                res[i] = a1[queries[i][1]+1] - a2[queries[i][0]+1] - 1 - (a3[a1[queries[i][1]+1]-1] - a3[a2[queries[i][0]+1]] );
            }
        }
        return res;

    }

    public static int brokenCalc(int startValue, int target) {
        if(startValue>target){
            return  startValue - target;
        }


        if(target%2==1){
            return brokenCalc(startValue, (target+1)/2)+2;
        }
        return  brokenCalc(startValue, target/2);
    }

//    /**
//     * 42. 接雨水
//     * */
//    public static int trap(int[] height) {
//        for (int i = 0; i < ; i++) {
//
//        }
//    }

}
