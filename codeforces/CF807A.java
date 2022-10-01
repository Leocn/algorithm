package com.example.demo.codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CF807A {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();

        while(t-->0){
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] s = new int[2*n];
            for(int i=0; i<2*n; i++){
                s[i] = sc.nextInt();
            }
            Arrays.sort(s);
            boolean flag = true;
            for(int i=0; i<n; i++){
                if(s[i+n]-s[i]<x){
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }
        }
    }
}
