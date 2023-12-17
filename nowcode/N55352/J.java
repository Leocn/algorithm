package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray(), b= sc.next().toCharArray();
        int cntA = 0, sA = 0;
        for (int i = 0; i < 5; i++) {
            if(a[i] == '?'){
                break;
            }
            if(a[i]=='1'){
                cntA++;
            }
            sA = i+1;
        }
        int cntB = 0, sB = 0;
        for (int i = 0; i < 5; i++) {
            if(b[i] == '?'){
                break;
            }
            if(b[i]=='1'){
                cntB++;
            }
            sB = i+1;
        }
        if(sA == sB){
            if(sA==5){
                if(cntA == cntB){
                    System.out.println(2);
                }else {
                    System.out.println(0);
                }
            }
            if(sA==4){
                if(cntA==cntB){
                    System.out.println(2);
                }else if(cntA==cntB+1){
                    System.out.println(1);
                }else if(cntA>cntB+1){
                    System.out.println(0);
                }else if(cntB ==cntA+1){
                    System.out.println(1);
                }else if(cntB>cntA+1){
                    System.out.println(0);
                }
            }else if(sA==3){
                if(cntA==cntB){
                    System.out.println(3);
                }else if(cntA==cntB+1){
                    System.out.println(2);
                }else if(cntA==cntB+2){
                    System.out.println(1);
                }else if(cntA==cntB+3){
                    System.out.println(0);
                }else if(cntB ==cntA+1){
                    System.out.println(2);
                }else if(cntB==cntA+2){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }else if(sA==2){
                if(cntA ==cntB){
                    System.out.println(4);
                }else if(cntA==cntB+1){
                    System.out.println(3);
                }else if(cntA == cntB+2){
                    System.out.println(2);
                }else if(cntB==cntA+1){
                    System.out.println(3);
                }else {
                    System.out.println(2);
                }
            }else if(sA == 1){
                if(cntA ==cntB){
                    System.out.println(5);
                }else {
                    System.out.println(4);
                }
            }else if(sA==0){
                System.out.println(6);
            }

        }else {
            if(sA==5){
                if(cntA == cntB){
                    System.out.println(1);
                }else if(cntA == cntB+1){
                    System.out.println(1);
                }else if(cntA > cntB+1){
                    System.out.println(0);
                }else if(cntB >= cntA+1){
                    System.out.println(0);
                }
            }
            if(sA==4){
                if(cntA==cntB){
                    System.out.println(2);
                }else if(cntA==cntB+1){
                    System.out.println(2);
                }else if(cntA==cntB+2){
                    System.out.println(1);
                }else if(cntA>cntB+2){
                    System.out.println(0);
                }

                else if(cntB ==cntA+1){
                    System.out.println(1);
                }else if(cntB>cntA+1){
                    System.out.println(0);
                }
            }else if(sA==3){
                if(cntA==cntB){
                    System.out.println(3);
                }else if(cntA==cntB+1){
                    System.out.println(3);
                }else if(cntA==cntB+2){
                    System.out.println(2);
                }else if(cntA==cntB+3){
                    System.out.println(1);
                }else if(cntB ==cntA+1){
                    System.out.println(2);
                }else if(cntB==cntA+2){
                    System.out.println(1);
                }
            }else if(sA==2){
                if(cntA ==cntB){
                    System.out.println(4);
                }else if(cntA==cntB+1){
                    System.out.println(4);
                }else if(cntA == cntB+2){
                    System.out.println(3);
                }else if(cntB==cntA+1){
                    System.out.println(3);
                }
            }else if(sA == 1){
                System.out.println(5);
            }
        }

    }
}
