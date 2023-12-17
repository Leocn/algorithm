package com.example.demo.codeforces.CF1051;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] cnt = new int[101];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            cnt[arr[i]] ++;
        }
        char[] ans = new char[n];
        Arrays.fill(ans, 'A');
        int c =0, c3 = 0;
        for (int i = 0; i < 101; i++) {
            if(cnt[i]==1){
                c++;
            }
            if(cnt[i]>=3){
                c3++;
            }
        }
        if(c%2==0){
            c/=2;
            for (int i = 0; i < n; i++) {
               if(cnt[arr[i]]==1 && c>0){
                   ans[i] = 'B';
                   c--;
               }
            }
        }else {
            if(c3==0){
                System.out.println("NO");
                return;
            }else {
                c3 = 1;
                c/=2;
                for (int i = 0; i < n; i++) {
                    if(cnt[arr[i]]==1 && c>0){
                        ans[i] = 'B';
                        c--;
                    }
                    if(cnt[arr[i]]>=3 && c3>0){
                        c3--;
                        ans[i] = 'B';
                    }
                }
            }


        }
        System.out.println("YES");
        System.out.println(new String(ans));



    }
}
