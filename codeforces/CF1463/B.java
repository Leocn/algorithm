package com.example.demo.codeforces.CF1463;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int[] ans = new int[n];
            Arrays.fill(ans,1);
            long sum1 =0, sum2 = 0;
            for (int i = 0; i <n ; i++) {
                arr[i] = sc.nextInt();
                if(i%2==0){
                    sum1+= arr[i];
                }else {
                    sum2+= arr[i];
                }
            }
            if(sum1<=(sum1+sum2)/2){
                for (int i = 1; i <n ; i+=2) {
                    ans[i] = arr[i];
                }
            }else {
                for (int i = 0; i < n; i+=2) {
                    ans[i] = arr[i];
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int a:ans){
                sb.append(a).append(" ");
            }
            System.out.println(sb);


        }
    }
}
