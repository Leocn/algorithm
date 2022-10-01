package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CF808C {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] ans = new int[n];
            int[] r = new int[n];
            for(int i =0; i<n; i++){
                r[i] = sc.nextInt();
            }
            int now = 0;
            for(int i=n-1; i>=0; i--){

                if(r[i]>now && now<q){
                    now++;
                    ans[i]=1;
                }else if(r[i]<=now){
                    ans[i] =1;
                }

            }

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(ans[i]);
            }
            System.out.println(sb);
        }
    }

}
