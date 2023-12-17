package com.example.demo.nowcode.N65051;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x= sc.nextInt(), y = sc.nextInt();
        long z = sc.nextInt();
        long s = 3*x+y;
        long ans =  (z/s)*3;
        long left = z%s;
        if(left==0){
            System.out.println(ans);
            return;
        }
        if(left<=x+y){
            ans++;
        }else if(left<=2*x+y){
            ans+=2;
        }else {
            ans+=3;
        }
        System.out.println(ans);
    }
}
