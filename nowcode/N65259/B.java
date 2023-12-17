package com.example.demo.nowcode.N65259;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q =sc.nextInt();
        while (q-->0){
            long n = sc.nextInt();
            long k = sc.nextInt();
            if(n==1 || n==2 || n==3 || n==4){
                if(k!=n+1){
                    System.out.println(-1);
                }else {
                    System.out.println(0);
                }
                continue;
            }
            long sum = n+1;
            if(k<sum){
                System.out.println(-1);
                continue;
            }

            long d = (n-1)/4 * 4;
            if(k>d+sum){
                System.out.println(-1);
                continue;
            }
            k-=sum;
            if(k%2==1){
                System.out.println(-1);
                continue;
            }
            System.out.println(k/4 *4 + (k%4==0?0:3));


        }
    }
}
