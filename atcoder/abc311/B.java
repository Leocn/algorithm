package com.example.demo.atcoder.abc311;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        char[][] cs = new char[n][d];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.next().toCharArray();
        }
        int[] cnt = new int[d];
        out:for (int i = 0; i < d; i++) {
            for (int j = 0; j < n; j++) {
                if(cs[j][i]!='o'){
                    continue out;
                }
            }
            cnt[i] = 1;
        }
        int ans = 0;
        for (int i = 0; i < d; i++) {
            if(cnt[i]==1){
                int r = i;
                while (r<d && cnt[r]==1){
                    r++;
                }
                ans = Math.max(ans, r-i);
            }

        }
        System.out.println(ans);
    }
}

