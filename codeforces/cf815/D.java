package com.example.demo.codeforces.cf815;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n  = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] dp = new int[n];
            dp[0] = 1;
            int ans = 0;
            for (int i = 1; i <n ; i++) {
                int max = 0;
                for (int j = i-1; j>= Math.max(0, i-300) ; j--) {
                    if((arr[i] ^ j) >(arr[j]^i) ){
                        max = Math.max(max, dp[j]+1);
                    }
                }
                dp[i] = max==0?1:max;
                ans = Math.max(ans, dp[i]);
            }
            System.out.println(ans==1?0:ans);
        }

    }
}
