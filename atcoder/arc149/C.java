package com.example.demo.atcoder.arc149;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 将奇数偶数分到两侧， 只要处理分割线部分奇偶数和是合数。
 * */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.nextInt();
        int[][] ans = new int[n][n];
        if(n==3){
            out.println("5 9 1");
            out.println("3 7 8");
            out.println("6 2 4");
        }else if(n==4){
            out.println("15 5 11 13");
            out.println("3 7 9 1");
            out.println("6 2 12 8");
            out.println("4 10 14 16");
        }else if(n==5){
            out.println("5 7 11 13 17");
            out.println("19 23 25 21 1");
            out.println("3 9 15 24 8");
            out.println("6 12 18 2 4");
            out.println("22 10 14 16 20");

        }else {
            boolean[] vis = new boolean[n*n+1];
            int start = 3;
            if(n%2==0){

                for (int j = 0; j < n; j++) {
                    ans[n/2-1][j] = start;
                    vis[start] = true;
                    start+=6;
                }
                start =1;
                for (int i = 0; i < n/2-1; i++) {
                    for (int j = 0; j < n; j++) {
                        while (vis[start]){
                            start+=2;
                        }
                        ans[i][j] = start;
                        vis[start] = true;
                    }
                }
                start =6;
                for (int j = 0; j < n; j++) {
                    ans[n/2][j] = start;
                    vis[start] = true;
                    start+=6;
                }
                start =2;
                for (int i = n/2+1; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        while (vis[start]){
                            start+=2;
                        }
                        ans[i][j] = start;
                        vis[start] = true;
                    }
                }


            }else {

                for (int j = 0; j <= n/2; j++) {
                    ans[n/2][j] = start;
                    vis[start] = true;
                    start+=6;
                }

                for (int j = n/2+1; j <n; j++) {
                    ans[n/2-1][j] = start;
                    vis[start] = true;
                    start+=6;
                }

                start =1;
                for (int j = 0; j <=n/2; j++) {
                    while (vis[start]){
                        start+=2;
                    }
                    ans[n/2-1][j] = start;
                    vis[start] = true;
                }

                for (int i = 0; i < n/2-1; i++) {
                    for (int j = 0; j < n; j++) {
                        while (vis[start]){
                            start+=2;
                        }
                        ans[i][j] = start;
                        vis[start] = true;
                    }
                }
                start =6;
                for (int j = 0; j <= n/2; j++) {
                    ans[n/2+1][j] = start;
                    vis[start] = true;
                    start+=6;
                }

                for (int j = n/2+1; j <n; j++) {
                    ans[n/2][j] = start;
                    vis[start] = true;
                    start+=6;
                }

                start =2;
                for (int j = n/2+1; j <n; j++) {
                    while (vis[start]){
                        start+=2;
                    }
                    ans[n/2+1][j] = start;
                    vis[start] = true;
                }
                for (int i = n/2+2; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        while (vis[start]){
                            start+=2;
                        }
                        ans[i][j] = start;
                        vis[start] = true;
                    }
                }
            }
            for(int i = 0;i < n;i++){
                for(int j = 0;j < n;j++){
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }



        out.close();
    }

}
