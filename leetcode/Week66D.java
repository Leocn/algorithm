package com.example.demo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Week66D {
    public static void main(String[] args) {
        System.out.println(minimumBuckets(".HH.HH.HH.HH..H"));
        System.out.println(minCost(new int[]{1,0},new int[]{2,3}, new int[]{5,4,3}, new int[]{8,2,6,7}));
    }

    public int countWords(String[] words1, String[] words2) {
        AtomicInteger res = new AtomicInteger();
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < words1.length; i++) {
            map1.put(words1[i], map1.getOrDefault(words1[i],0)+1);
        }

        for (int i = 0; i < words2.length; i++) {
            map2.put(words2[i], map2.getOrDefault(words2[i],0)+1);
        }

        map1.forEach((key,value) ->{
            if(value==1 && map2.getOrDefault(key,0)==1){
                res.getAndIncrement();
            }
        });
        return res.get();

    }

    public static int minimumBuckets(String street) {
//        int res = 0;
//        int countH = 0;
//        Stack<Character> stack = new Stack<>();
//        char[] array = street.toCharArray();
//        for (char c : array){
//            if(c=='H'){
//                countH ++;
//                int count =0;
//                while(!stack.isEmpty()){
//                    char tem = stack.pop();
//                    if(tem=='H'){
//                        res += count;
//                        break;
//                    }else {
//                        count++;
//                    }
//                }
//                stack.push('H');
//            }else {
//                stack.push(c);
//            }
//            System.out.println(res);
//        }
//        return countH ==0? countH: ( res==0? -1: res);
        char[] array = street.toCharArray();
        int res =0;
        int countH = 0;
        boolean[] b = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            //if(b[i]){continue;}

            if(array[i]=='.'){
                if(array[i-1]=='H' && array[i+1] =='H'){
                    res ++;
                }
            }
            if(array[i]=='H'){
                countH ++;

//                if(((i>0&&array[i-1]!='.') || i==0) &&i+1<array.length-1 && array[i+1]=='.'){
//                    res ++;
//                }
//                if(i+1<array.length-1 && array[i+1]=='.'){
//                    res ++;
//                    //b[i+1] = true;
//                }
            }
        }
       return countH ==0? countH: ( res==0? -1: res);
    }


    public static int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ma = Math.min(startPos[0], homePos[0]);
        int mb = Math.max(startPos[0], homePos[0]);

        int na = Math.min(startPos[1], homePos[1]);
        int nb = Math.max(startPos[1], homePos[1]);

        int[][] a = new int[rowCosts.length][colCosts.length];

        for (int i = ma+1; i <= mb; i++) {
            a[i][na]= a[i-1][na] + rowCosts[i];
        }
        for (int i = na+1; i <= nb; i++) {
            a[ma][i]= a[ma][i-1]+ colCosts[i];
        }

        for (int i = ma+1; i <=mb ; i++) {
            for (int j = na+1; j <=nb ; j++) {
                a[i][j] = Math.min(a[i-1][j]+rowCosts[i],a[i][j-1]+colCosts[j]);
            }

        }
        return a[mb][nb];
    }
}
