package com.example.demo.codeforces;

import java.util.Scanner;

public class CF808A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] r = new int[n];
            for(int i =0; i<n; i++){
                r[i] = sc.nextInt();
            }
            boolean flag = true;
            for(int i=1; i<n; i++){
                if((r[i]-r[i-1])% r[0]!=0){
                    System.out.println("NO");
                    flag =false;
                    break;
                }
            }
            if(flag) System.out.println("YES");
        }
    }
}
