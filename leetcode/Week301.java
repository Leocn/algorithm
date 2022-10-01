package com.example.demo.leetcode;

import java.util.*;

public class Week301 {
    public static void main(String[] args) {

    }
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int ans = amount[1];
        int count = amount[2]-amount[1];
        if(count>amount[0]){
            ans += count;
        }else{
            ans += amount[0];
        }
        return ans;
    }



    public boolean canChange(String start, String target) {
        int n = start.length();
        List<Integer> listA = new ArrayList<>();
        List<Integer> listA2 = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        List<Integer> listB2 = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(start.charAt(i)=='L'){
                listA.add(i);
            }
            if(target.charAt(i)=='L'){
                listA2.add(i);
            }
            if(start.charAt(i)=='R'){
                listB.add(i);
            }
            if(target.charAt(i)=='R'){
                listB2.add(i);
            }

        }

        if(listA.size()!=listA2.size() || listB.size()!=listB2.size()){
            return false;
        }

        for(int i =0; i<listA.size(); i++){
            if(listA.get(i)<listA2.get(i)){
                return false;
            }
        }
        for(int i=0; i<listB.size(); i++){
            if(listB.get(i)>listB2.get(i)){
                return false;
            }
        }

        int countA =0, countA1=0, countB=0, countB1 = 0;
        for(int i=0; i<n; i++){
            if(start.charAt(i)=='L'){
                countA++;
            }
            if(target.charAt(i)=='L'){
                countA1++;
            }
            if(start.charAt(i)=='R'){
                countB ++ ;
            }
            if(target.charAt(i)=='R'){
                countB1++;
            }
            if((countA>countA1 && countB<= countB1) || (countA<countA1 && countB>= countB1)){
                return false;
            }

        }
        return true;


    }

    public int idealArrays(int n, int maxValue) {
        int ans = 0;
        if(n==1){
            return  maxValue;
        }
        for(int i=1;i<= maxValue; i++){
            if(maxValue%i ==0){
                ans += idealArrays(n-1, maxValue/i);
            }
        }
        return ans;
    }

}
