package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Week264 {
    public static void main(String[] args) {
        System.out.println(countValidWords(" 62   nvtk0wr4f  8 qt3r! w1ph 1l ,e0d 0n 2v 7c.  n06huu2n9 s9   ui4 nsr!d7olr  q-, vqdo!btpmtmui.bb83lf g .!v9-lg 2fyoykex uy5a 8v whvu8 .y sc5 -0n4 zo pfgju 5u 4 3x,3!wl  fv4   s  aig cf j1 a i  8m5o1  !u n!.1tz87d3 .9    n a3  .xb1p9f  b1i a j8s2 cugf l494cx1! hisceovf3 8d93 sg 4r.f1z9w   4- cb r97jo hln3s h2 o .  8dx08as7l!mcmc isa49afk i1 fk,s e !1 ln rt2vhu 4ks4zq c w  o- 6  5!.n8ten0 6mk 2k2y3e335,yj  h p3 5 -0  5g1c  tr49, ,qp9 -v p  7p4v110926wwr h x wklq u zo 16. !8  u63n0c l3 yckifu 1cgz t.i   lh w xa l,jt   hpi ng-gvtk8 9 j u9qfcd!2  kyu42v dmv.cst6i5fo rxhw4wvp2 1 okc8!  z aribcam0  cp-zp,!e x  agj-gb3 !om3934 k vnuo056h g7 t-6j! 8w8fncebuj-lq    inzqhw v39,  f e 9. 50 , ru3r  mbuab  6  wz dw79.av2xp . gbmy gc s6pi pra4fo9fwq k   j-ppy -3vpf   o k4hy3 -!..5s ,2 k5 j p38dtd   !i   b!fgj,nx qgif "));
    }
    /**
     * 句子中的有效单词数
     * */
    public static int countValidWords(String sentence) {
        String[] array = sentence.split(" ");
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(isValidWords(array[i])){
                count++;
            }
        }
        return count;
    }
    private static boolean isValidWords(String str){
        if(str.length()==0) return false;
        char[] chars = str.toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if( (chars[i] >=97 && chars[i]<=122) || (chars[i] == 45 && count<1 && i!=0 && i!=chars.length-1 )  ||
                    ((chars[i] ==44 || chars[i] == 33 || chars[i] == 46) &&i == chars.length-1 && (i-1<0 ||chars[i-1]!=45)  ) ){
                if(chars[i] == 45){
                    count++;
                }
            }else {return false;}
        }
        return true;

    }

    /**
     * 下一个更大的数值平衡数
     * */
//    public static int nextBeautifulNumber(int n) {
//
//    }


    /**
     * 5909. 并行课程 III
     * */
    public static int minimumTime(int n, int[][] relations, int[] time) {
        int[] inDegree = new int[n];
        HashSet<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }

        for (int[] p : relations) {
            inDegree[p[0]-1]++;
            adj[p[1]-1].add(p[0]-1);
        }

        Queue<Integer> queue = new LinkedList<>();

        //每门课程的结束的最早时间
        int[] res = new int[n];
        Arrays.fill(res, Integer.MIN_VALUE);
        // 首先加入入度为 0 的结点
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                res[i] = time[i];
                queue.add(i);
            }
        }

        // 记录每个课程的最大值

        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            // 遍历当前出队结点的所有后继结点
            for (int successor : adj[top]) {
                res[successor] = Math.min(time[successor] + res[top],res[successor]) ;
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.add(successor);
                }
            }
        }
        return Arrays.stream(res).max().orElse(0);
    }
}
