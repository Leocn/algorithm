package com.example.demo.codeforces.cf823;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String str = sc.next();
            char[] cs=  str.toCharArray();
            int n = cs.length;
            char m = cs[n-1];
            int[] ans = new int[n];
            for (int i = n-1; i >=0; i--) {
                if(cs[i]<=m){

                    m = cs[i];
                }else{
                    ans[i]=1;
                }
            }
            for (int i = 0; i < n; i++) {
                if(ans[i]== 1 && cs[i]!='9'){
                    cs[i] = (char) (cs[i]+1);
                }
            }
            Arrays.sort(cs);
            System.out.println(new String(cs));

        }
    }
}
