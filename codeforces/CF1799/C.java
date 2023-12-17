package com.example.demo.codeforces.CF1799;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-->0){
            String str = sc.next();
            char[] cs = str.toCharArray();
            int n = cs.length;
            int[] arr  = new int[26];
            for (int i = 0; i < n; i++) {
                arr[cs[i]-'a']++;
            }
            StringBuilder sb = dfs(arr);
            out.println(sb);

        }
        out.close();


    }
    private static StringBuilder dfs(int[] arr){
        int cnt = 0;
        StringBuilder sbL = new StringBuilder();
        StringBuilder sbR = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if(arr[i]>0){
                cnt++;
            }
        }
        if(cnt==1){
            for (int i = 0; i < 26; i++) {
                if(arr[i]>0){
                    return  new StringBuilder(String.valueOf((char) (i + 'a')).repeat( arr[i]));
                }
            }
        }
        if(cnt==2){
            for (int i = 0; i < 26; i++) {
                while (arr[i]>1){
                    sbL.append((char)(i+'a'));
                    sbR.append((char)(i+'a'));
                    arr[i]-=2;
                }
            }
            for (int i = 25; i >=0; i--) {
                while (arr[i]>0){
                    sbL.append((char)(i+'a'));
                    arr[i]-=1;
                }
            }
            sbR.reverse();
            sbL.append(sbR);
            return sbL;
        }

        if(cnt>2){
            //int first = 0;
            int loc = 0;
            for (int i = 0; i < 26; i++) {
                if(arr[i]>0){
                    loc = i;
                    break;
                    //first = arr[i];
                }
            }
            if(arr[loc]==1){
                sbL.append((char)(loc+'a'));
                arr[loc]--;
                for (int i = 0; i < 26; i++) {
                    sbR.append(String.valueOf((char) (i + 'a')).repeat(Math.max(0, arr[i])));
                }
                sbL.reverse();
                sbR.append(sbL);
                return sbR;
            }
            while (arr[loc]>1){
                sbL.append((char)(loc+'a'));
                sbR.append((char)(loc+'a'));
                arr[loc]-=2;
            }
            sbL.append(dfs(arr)).append(sbR);
        }
        return sbL;


    }
}
