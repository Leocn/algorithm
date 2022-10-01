package com.example.demo.codeforces.ecf135;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] ans = new int[n];
            StringBuilder sb = new StringBuilder();
            ans[n-1] = n;
            ans[n-2] = n-1;
            ans[n-3] = 1;

            if((n-3)%2==0){
                if((n-3)%3!=0){
                    for (int i = 0; i < n-3 ; i++) {
                        ans[i]= i+2;
                    }
                }else{
                    for (int i = 0; i < 3 ; i++) {
                        ans[i]= i+1;
                    }
                    for(int i=3;i<n-2;i++){
                        ans[i] = n-i+1;
                    }
                }

            }else{
                for (int i =  0; i < n-3 ; i++) {
                    ans[i]= n-2-i;
                }
            }


            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
