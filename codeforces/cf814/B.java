package com.example.demo.codeforces.cf814;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(k%4==0){
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            if(k%2==1){
                StringBuilder sb = new StringBuilder();
                for(int i=1; i<=n;i++){
                    sb.append(i).append(" ");
                }
                System.out.println(sb);
                continue;
            }
            if(k%2==0){
                StringBuilder sb = new StringBuilder();
                for(int i=1;i<=n/2;i++){
                    if(i%2==1){
                        sb.append(2*i).append(" ").append(2*i-1).append(" ");
                    }else {
                        sb.append(2*i-1).append(" ").append(2*i).append(" ");
                    }
                }
                System.out.println(sb);
            }

        }
    }
}
