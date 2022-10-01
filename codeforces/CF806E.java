package com.example.demo.codeforces;

import java.util.Scanner;

public class CF806E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[][] g = new int[n][n];
            int start = 0;
            while(start<n){
                String str = sc.next();
                for(int i = 0; i<n; i++){
                    g[start][i] = str.charAt(i)-'0';
                }
                start++;
            }
            int ans = 0;
            for(int i =0; i<n;i++){
                for(int j=0; j<n; j++){
                    int a = 0;
                    a += g[i][j];
                    a += g[j][n-1-i];
                    a += g[n-1-j][i];
                    a += g[n-1-i][n-1-j];
                    if(a==2){
                        ans +=2 ;
                    }
                    if(a==3 || a==1){
                        ans ++;
                    }
                }
            }
            System.out.println(ans/4);
        }
    }
}
