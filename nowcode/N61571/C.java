package com.example.demo.nowcode.N61571;

import java.util.Arrays;
import java.util.Scanner;

public class C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mod = (int)1e9+7;
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr  = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        Arrays.sort(arr);
        int loc = -1;
        long left = 0,right = 0;
        long sum = 0;
        while (k-->0){
            int t = sc.nextInt();
            long x = sc.nextLong();
            if(t==1){
                left += x;
                right += x;

            }else {
                if(left<= x){
                    left =0;
                }
                while (loc<n-1&&arr[loc+1] + right<= x){
                    loc++;
                }
                right -= x;
            }
        }

        sum += (loc +1)*left %mod;
        sum += ((n-loc-1) * right%mod + mod)%mod;
        for (int i = loc+1; i <n ; i++) {
            sum =  (sum+arr[i])%mod;
        }
        System.out.println(sum);




    }
}
