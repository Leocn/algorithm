package com.example.demo.codeforces.cf815;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            long x = (long) a *d;
            long y = (long) b *c;
            int ans = 0;
            if(x==y){
                ans =0;
            }else if((y!= 0&&x%y==0) || (x!=0 && y%x==0)){
                ans =1;
            }else {
                ans =2;
            }
            System.out.println(ans);
        }
    }
}
