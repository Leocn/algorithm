package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CF806F {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int[] s = new int[n];
            int[] count = new int[n+1];
            Arrays.fill(count, -1);
            for(int i=0; i<n;i++){
                int v = sc.nextInt();
                s[i] = v;
                if(v<i+1){
                    count[i+1] =v;
                }
            }
            long ans = 0;
            int[] sum = new int[n+1];
            for(int i =1; i<=n; i++){
                if(count[i]>=0){
                    sum[i] = sum[i-1] +1;
                }else{
                    sum[i] = sum[i-1];
                }
                ans += count[i]-1 <=0? 0: sum[count[i]-1];
            }

            System.out.println(ans);

        }
    }
}
