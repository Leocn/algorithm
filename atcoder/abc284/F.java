package com.example.demo.atcoder.abc284;

import java.util.Scanner;
/**
 * TODO
 * */
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String t = sc.next();
        char[] cs = t.toCharArray();
        int[] sum = new int[26];
        for (int i = 0; i <2*n ; i++) {
            sum[cs[i]-'a']++;
        }
        for(int s: sum){
            if(s%2!=0){
                System.out.println(-1);
                return;
            }
        }
        int[] cnt = new int[26];
        out:for (int i = 0; i < 2*n; i++) {
            cnt[cs[i]-'a']++;
            if(i>=n){
                cnt[cs[i-n]-'a']--;
            }
            for(int j =0 ;j<26; j++){
                if(2*cnt[j]!=sum[j]){
                    continue out;
                }
            }
            String sub = t.substring(i-n+1, i+1);
            String rev = t.substring(0,i-n+1) + t.substring(i+1, 2*n);
            if(check(sub,  rev)){
                System.out.println( rev);
                System.out.println( i-n+1);
                return;
            }
        }

        System.out.println(-1);

    }
    private static boolean check(String a , String b){
        int n = a.length();
        int loc = 0;
        while (loc<n&& a.charAt(loc) == b.charAt(n-loc-1)){
            loc++;
        }
        return loc == n;
    }

}

