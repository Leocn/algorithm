package com.example.demo.codeforces;

import java.util.Scanner;

public class CF807B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] s = new int[n];
            for(int i=0; i<n; i++){
                s[i] = sc.nextInt();
            }
            long sum = 0;
            for(int i=0; i<n-1; i++){
                if(s[i]==0 && sum>0){
                    sum++;
                }
                sum += s[i];
            }
            System.out.println(sum);
        }
    }
}
