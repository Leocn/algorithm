package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Week274 {

    public boolean checkString(String s) {
        char[] chars = s.toCharArray();
        int count =0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] =='b'){
                count ++;
            }
            if(chars[i] =='a' && count>0){
                return  false;
            }
        }
        return  true;
    }


    public int numberOfBeams(String[] bank) {
        //int n = bank.length;
        //int m = bank[0].length();
        int res = 0;
        int countB = 0;
        for (String s : bank) {
            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1') {
                    count++;
                }
            }
            System.out.println(count);

            res += count * countB;

            countB = count>0?count: countB;

        }
        return res;
    }


    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long all = mass;
        for(int a: asteroids){
            if(a<=all){
                all += a;
            }else {
                return false;
            }

        }
        return true;
    }


    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        Queue<Integer> queue = new LinkedList<>();
        //入度大小
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[favorite[i]]++;
        }
        int[] maxLen = new int[n];
        for (int i = 0; i < n; i++) {
            if(count[i]==0){
                queue.add(i);
            }
        }
        //剪枝，剩余count[i]>0的都是成环的
        while (!queue.isEmpty()){
            int po = queue.poll();
            maxLen[po]++;
            int w = favorite[po];
            //记录枝条上的最大长度，方便计算基环大小为2时最大的值 sumChainSize
            maxLen[w] = Math.max(maxLen[po], maxLen[w]);
            if(--count[w]==0){
                queue.add(w);
            }
        }

        int maxRingSize = 0, sumChainSize = 0;
        for (int i = 0; i < n; i++) {
            if(count[i] ==0){
                continue;
            }
            count[i]=0;
            int ringSize = 1;
            int next = favorite[i];
            //计算环的大小
            while (next !=i){
                count[next]=0;
                ringSize++;
                next = favorite[next];
            }
            //环大小为2
            if(ringSize==2){
                //+= 是因为可能有多个大小为2的环组成一个大桌
                sumChainSize += maxLen[i]+ maxLen[favorite[i]] +2;
            }else {
                // 只能存在一个大环
                maxRingSize = Math.max(maxRingSize, ringSize);
            }
            
        }

        return Math.max(sumChainSize, maxRingSize);

    }

}
