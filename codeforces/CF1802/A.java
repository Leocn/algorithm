package com.example.demo.codeforces.CF1802;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int cntA = 0, cntB = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(arr[i]>0){
                    cntA++;
                }else {
                    cntB++;
                }
            }
            StringBuilder sb = new StringBuilder();
            StringBuilder sbS = new StringBuilder();
            int  temA =cntA, temB = cntB;
            int c = 1;
            while (cntA>0){
                sb.append(c++).append(" ");
                cntA--;
            }
            c-=2;
            while (cntB>0){
                sb.append(c--).append(" ");
                cntB--;
            }
            c=1;
            while (temA>0 && temB>0){
                sbS.append(1).append(" ").append( 0).append(" ");
                temA--;
                temB--;
            }
            while (temA>0){
                sbS.append(c++).append(" ");
                temA--;
            }
            System.out.println(sb);
            System.out.println(sbS);

        }
    }
}
