package com.example.demo.leetcode;

import java.util.*;

public class Week307 {
    public static void main(String[] args) {

    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int e = 0;
        for(int ee: energy){
            e += ee;
        }
        int eTime = e-initialEnergy+1;
        System.out.println(eTime);
        int exp = 0;
        int now = 0;
        for (int i = 0; i < experience.length; i++) {
            if(now>experience[i]){
                now += experience[i];
            }else{
                exp += experience[i] - now+1;
                now = 2*experience[i]+1;
            }
        }
        int expTime = exp- initialExperience;
        return Math.max(eTime,0) +  Math.max(expTime,0);
    }


    public String largestPalindromic(String num) {
        char[] cs = num.toCharArray();
        Arrays.sort(cs);
        int n = cs.length;
        char[] res = new char[n];
        Arrays.fill(res,'a');
        int start = 0;
        int max = -1;
        int count =0;
        for (int i = n-1; i >=0 ; i--) {
            if(cs[i]=='0'){
                count++;
            }

        }
        if(count==n){
            return "0";
        }

        for (int i = n-1; i >0 ; i--) {
            if(cs[i]==cs[i-1]){
                i--;
                res[start] = cs[i];
                res[n-1-start] = cs[i];
                start++;
            }else{
                max = Math.max(max, cs[i]-'0');
            }

        }
        StringBuilder ans = new StringBuilder();
        for(char c: res){
            if(c!='a'){
                if(ans.length()==0 && c=='0'){
                    continue;
                }
                ans.append(c);
            }
        }
        if(max!=-1){
            ans.insert(ans.length()/2, max);
        }
        return ans.toString();

    }





}
