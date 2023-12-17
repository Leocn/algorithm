package com.example.demo.codeforces.CF1786;

import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int a = 0;
            int b = 0;
            n--;
            a++;
            int tag = 1;
            int cur = 2;
            while (n>0){
                if(tag ==1){
                    if(n>cur){
                        b+=cur;
                        n-=cur;
                        cur++;
                    }else{
                        b+= n;
                        break;
                    }

                    if(n>cur){
                        b+=cur;
                        n-=cur;
                        cur++;
                    }else{
                        b+= n;
                        break;
                    }
                    tag =0;

                }else{
                    if(n>cur){
                        a+=cur;
                        n-=cur;
                        cur++;
                    }else{
                        a+= n;
                        break;
                    }

                    if(n>cur){
                        a+=cur;
                        n-=cur;
                        cur++;
                    }else{
                        a+= n;
                        break;
                    }




                    tag =1;
                }
            }
            System.out.println(a +" " + b);
        }
    }
}
