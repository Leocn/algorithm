package com.example.demo.leetcode;

import java.util.*;

public class Week366 {
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("poazaeuioauoiioaouuouaui"));
        System.out.println(countVowels("noosabasboosa"));
        System.out.println(minimizedMaximum(1,new int[]{1}));
        System.out.println(maximalPathQuality(new int[]{0,32,10,43} , new int[][]{{0,1,10},{1,2,15},{0,3,10}},49));

    }


    /**
     * 5918. 统计字符串中的元音子字符串
     * */
    public static int countVowelSubstrings(String word) {
        char[] chars = word.toCharArray();
        int le = chars.length;
        int res = 0; int lef = 0;
        for(int i = 0; i < le; i++){
            if(chars[i]=='a' || chars[i]=='e'||chars[i]=='i'||chars[i]=='o'||chars[i]=='u'){
                String str = word.substring(lef,i+1);
                if(str.contains("a") && str.contains("e") &&str.contains("i")&&str.contains("o")&&str.contains("u")) {
                    System.out.println(str);

                    res++;
                }
            }else {
                if(lef<=i-5){
                    res += countVowelSubstrings(word.substring(lef+1,i));
                }
                lef = i+1 ;
            }


        }
        if(lef<=le-5){
            res += countVowelSubstrings(word.substring(lef+1,le));

        }
        return res;

    }

    /**
     * 5919. 所有子字符串中的元音
     * */
    public static long countVowels(String word) {
        char[] chars = word.toCharArray();
        int le = chars.length;
        long res = 0;
        for (int i = 0; i < le; i++) {
            if(chars[i] == 'a' || chars[i] == 'e' ||chars[i] == 'i' ||chars[i] == 'o' ||chars[i] == 'u'){
                res += le + (long) (le - 1 - i) *(i);
            }
        }
        return res;
    }

    /**
     * 5920. 分配给商店的最多商品的最小值
     * 二分法，满足每个商店分k个商品，需要多少个商店
     * 满足最大商店数量为n的最大k为多少
     * */
    public static int minimizedMaximum(int n, int[] quantities) {
        int l = 1;
        int r = Arrays.stream(quantities).max().orElse(100001);
        while (l<=r){
            int count = 0;
            int mid = (l+r) >>1;
            for(int qu : quantities){
                count += (qu-1)/mid + 1;
            }
            if(count>n){
                l = mid+1;

            }else {
                r = mid-1;

            }
        }
        return l;
    }

    /**
     * 5921. 最大化一张图中的路径价值
     * */
    static int maxValue = 0;
    static int maxT = 0;
    static int[] valuesA = null;
    static int[][] nodeValue = null;
    public static int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n =values.length;
        List[] ed = new List[n];
        for (int i = 0;  i< n; i++) {
            ed[i] = new ArrayList<>();
        }
        maxT =maxTime;
        valuesA = values;
        nodeValue = new int[n][maxTime+1];


        for (int[] edge : edges) {
            int[] s1 = new int[]{edge[1], edge[2]};
            ed[edge[0]].add(s1);
            int[] s2 = new int[]{edge[0], edge[2]};
            ed[edge[1]].add(s2);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, ed, 0,valuesA[0],visited);
        return maxValue;
    }

    private static void dfs( int curTime, List[] edm , int nowNode, int curValue,boolean[] visited){
        System.out.println(curTime + "---"+ curValue);
        if(curTime>maxT){
            return;
        }
        if(nowNode !=0 &&nodeValue[nowNode][curTime] >= curValue){
            return;
        }
        nodeValue[nowNode][curTime] = curValue;

        if(nowNode == 0 && curValue > maxValue){
            maxValue = curValue;
        }
        for (int i = 0; i <edm[nowNode].size() ; i++) {
            int[] array = (int[]) edm[nowNode].get(i);

            boolean b = visited[array[0]];
            if(!b){
                visited[array[0]]=true;
                curValue += valuesA[array[0]];
            }
            dfs(curTime + array[1], edm, array[0], curValue, visited );
            if(!b){
                visited[array[0]]=false;
                curValue -= valuesA[array[0]];
            }
        }

    }

}
