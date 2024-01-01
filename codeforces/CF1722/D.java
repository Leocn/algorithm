package com.example.demo.codeforces.CF1722;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] str = sc.next().toCharArray();
            Integer[] sum = new Integer[n];
            long all = 0;
            for (int i = 0; i < n; i++) {
                if(str[i]=='L'){
                    sum[i] = i;
                }else{
                    sum[i] = n-1-i;
                }
                all += sum[i];
            }
            Arrays.sort(sum);
            long[] ans = new long[n];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(sum[i]<=(n-1)/2){
                    all += Math.max(n-1-2*sum[i], 0);
                }
                ans[i] = all;
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        }

    }
}
