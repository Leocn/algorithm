package com.example.demo.atcoder.abc265;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] arr = new char[h][w];
        for (int i = 0; i < h; i++) {
            arr[i] = sc.next().toCharArray();
        }
        boolean flag = false;
        int  curX = 0, curY = 0;
        int tot = h *w +1;
        while (tot-->0){
            char c = arr[curX][curY];
            if(c=='U'){
                if(curX==0){
                    flag = true;
                    break;
                }
                curX --;

            }
            if(c=='D'){
                if(curX==h-1){
                    flag = true;
                    break;
                }
                curX ++;
            }
            if(c=='L'){
                if(curY==0){
                    flag = true;
                    break;
                }
                curY --;
            }

            if(c=='R'){
                if(curY==w-1){
                    flag = true;
                    break;
                }
                curY ++;
            }
        }

        if(flag){
            curX ++;
            curY++;
            System.out.println(curX+ " "+ curY);
        }else {
            System.out.println(-1);
        }


    }
}
