package com.example.demo.codeforces.ecf136;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            ans[0] = arr[0];
            boolean flag=  true;
            for (int i = 1; i < n; i++) {
                if( ans[i-1] - arr[i]>0 && arr[i]+ans[i-1]>0 &&  ans[i-1] - arr[i]!=arr[i]+ans[i-1] ){
                    System.out.println(-1);
                    flag = false;
                    break ;
                }else{
                    ans[i] = ans[i-1]-arr[i]>=0?ans[i-1]-arr[i]: arr[i]+ans[i-1];
                }
            }
            if(flag){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n  ; i++) {
                    sb.append(ans[i]).append(" ");
                }
                System.out.println(sb);
            }
        }
    }
}
