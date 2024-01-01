package com.example.demo.codeforces.CF1722;

import java.util.Scanner;

public class G {
    /**
     * 相等异或为0
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int xor = 0;
            int[] ans = new int[n];
            ans[n-2] = (1<<30);
            ans[n-3] = (1<<29);
            xor^=ans[n-2];
            xor^=ans[n-3];
            for (int i = 0; i < n-3; i++) {
                ans[i] = i;
                xor^=ans[i];
            }
            ans[n-1] = xor;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);


        }

    }
}
