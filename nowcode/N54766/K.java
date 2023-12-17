package com.example.demo.nowcode.N54766;

import java.util.Scanner;

public class K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arrA = new int[3][4];
        int[][] arrB = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arrA[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                arrB[i][j] = sc.nextInt();
            }
        }
        boolean a = false, b = false;
        if((arrA[0][0]!=0 && arrA[0][1]!=0) || (arrA[2][2]!=0 && arrA[2][3]!=0)){
            a = true;
        }
        if((arrB[0][0]!=0 && arrB[0][1]!=0) || (arrB[2][2]!=0 && arrB[2][3]!=0)){
            b = true;
        }
        int cntA[] = new int[7];

        if(a){
            int x = 0, y = 0, tar = 0;
            for (int i = 0; i < 4; i++) {
                if(arrA[1][i]!=0 && arrA[1][i+2]!=0){
                    cntA[arrA[1][i]] = arrA[1][i+2];
                    cntA[arrA[1][i+2]] = arrA[1][i];
                    x = i;
                    y = i+2;
                    tar = i+1;
                    break;
                }

            }
            int aa =0 , bb =0, cc = 0;
            for (int j = 0; j < 4; j++) {
                if(arrA[0][j] !=0){
                    if(Math.abs(j-tar)!=1){
                        cntA[arrA[0][j]] = arrA[1][tar];
                        cntA[arrA[1][tar]] = arrA[0][j];
                    }else if(Math.abs(j-tar)==1){
                        aa  = arrA[0][j];
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                if(arrA[2][j] !=0){
                    if(Math.abs(j-tar)!=1){
                        cntA[arrA[2][j]] = arrA[1][tar];
                        cntA[arrA[1][tar]] = arrA[2][j];
                    }else if(Math.abs(j-tar)==1){
                        bb  = arrA[2][j];
                    }
                }
            }

            cntA[aa] = bb;
            cntA[bb] = aa;



        }else {
            cntA[arrA[1][0]] = arrA[1][2];
            cntA[arrA[1][2]] = arrA[1][0];
            cntA[arrA[1][1]] = arrA[1][3];
            cntA[arrA[1][3]] = arrA[1][1];
            int f = 0, to = 0;
            for (int i = 0; i < 4; i++) {
                if(arrA[0][i]!=0){
                    f= arrA[0][i];
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                if(arrA[2][i]!=0){
                    to= arrA[2][i];
                    break;
                }
            }
            cntA[f] = to;
            cntA[to] = f;

        }

        int cntB[] = new int[7];
        if(b){
            int x = 0, y = 0, tar = 0;
            for (int i = 0; i < 4; i++) {
                if(arrB[1][i]!=0 && arrB[1][i+2]!=0){
                    cntB[arrB[1][i]] = arrB[1][i+2];
                    cntB[arrB[1][i+2]] = arrB[1][i];
                    x = i;
                    y = i+2;
                    tar = i+1;
                    break;
                }

            }
            int aa =0 , bb =0, cc = 0;
            for (int j = 0; j < 4; j++) {
                if(arrB[0][j] !=0){
                    if(Math.abs(j-tar)!=1){
                        cntB[arrB[0][j]] = arrB[1][tar];
                        cntB[arrB[1][tar]] = arrB[0][j];
                    }else if(Math.abs(j-tar)==1){
                        aa  = arrB[0][j];
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                if(arrB[2][j] !=0){
                    if(Math.abs(j-tar)!=1){
                        cntB[arrB[2][j]] = arrB[1][tar];
                        cntB[arrB[1][tar]] = arrB[2][j];
                    }else if(Math.abs(j-tar)==1){
                        bb  = arrB[2][j];
                    }
                }
            }

            cntB[aa] = bb;
            cntB[bb] = aa;
        }else {
            cntB[arrB[1][0]] = arrB[1][2];
            cntB[arrB[1][2]] = arrB[1][0];
            cntB[arrB[1][1]] = arrB[1][3];
            cntB[arrB[1][3]] = arrB[1][1];
            int f = 0, to = 0;
            for (int i = 0; i < 4; i++) {
                if(arrB[0][i]!=0){
                    f= arrB[0][i];
                    break;
                }
            }
            for (int i = 0; i < 4; i++) {
                if(arrB[2][i]!=0){
                    to= arrB[2][i];
                    break;
                }
            }
            cntB[f] = to;
            cntB[to] = f;
        }

        for (int i = 1; i < 7; i++) {
            if(cntA[i]!=cntB[i]){
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");


    }
}
