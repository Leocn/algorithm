package com.example.demo.atcoder.abc264;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int aL = sc.nextInt();
        int aW = sc.nextInt();
        int[][] A  = new int[aL][aW];
        for (int i = 0; i < aL; i++) {
            for (int j = 0; j <aW ; j++) {
                A[i][j] = sc.nextInt();

            }
        }

        int bL = sc.nextInt();
        int bW = sc.nextInt();
        int[][] B  = new int[bL][bW];
        for (int i = 0; i < bL; i++) {
            for (int j = 0; j <bW ; j++) {
                B[i][j] = sc.nextInt();
            }
        }
        int start = 0;
        for (int i = 0; i < aL; i++) {
            for (int j = 0; j <aW ; j++) {
                if(start <bL*bW && A[i][j]==B[start/bW][start%bW]){
                    start++;
                }

            }
        }
        if(start!=bL*bW){
            System.out.println("No");
            return;
        }
        start =0;
        for (int i = 0; i < aW; i++) {
            for (int j = 0; j < aL ; j++) {
                if(start <bL*bW && A[j][i]==B[start%bL][start/bL]){
                    start++;
                }

            }
        }
        if(start!=bL*bW){
            System.out.println("No");
            return;
        }

        System.out.println("Yes");
    }
}
