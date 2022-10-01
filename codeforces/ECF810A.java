package com.example.demo.codeforces;

import java.util.Scanner;

public class ECF810A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int x = sc.nextInt();
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            int[] vis = new int[]{a, b, c};
            while(x!=0){
                int tem = x;
                x = vis[x-1];
                vis[tem-1] =0;
            }
            boolean flag = true;
            for(int s: vis){
                if(s!=0){
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
