package com.example.demo.codeforces.cf813;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] re = new int[n];
            for (int i = 0; i < n; i++) {
                re[i] = sc.nextInt();
            }
            Arrays.sort(re);
            for(int i =0;i<k;i++){
                re[i] = 1000000000;
            }
            Arrays.sort(re);
            if(n==2){
                System.out.println(re[0]);
                continue;
            }
            int ans = 0;
            int[] res = new int[n];

            for (int i = 1; i < n-1; i++) {
                res[i] = Math.min(2*re[0], re[i]);
                ans = Math.max(res[i],ans);
            }
            System.out.println(ans);


        }
    }
}
