package com.example.demo.codeforces.cfp;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] cs = sc.next().toCharArray();
            int[] ans = new int[n-1];
            char left  = cs[0];
            ans[0] = 1;
            int cnt = 1;
            for (int i = 3; i <=n; i++) {
                if(cs[i-2] == cs[i-3]){
                    cnt++;
                }else {
                    cnt = 1;
                }
                ans[i-2] = i- cnt;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n-1; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
