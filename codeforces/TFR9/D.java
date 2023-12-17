package com.example.demo.codeforces.TFR9;

import java.util.Arrays;
import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] arr = new boolean[15][15];
        arr[0][0] = true;
        arr[0][1] = true;
        arr[0][2] = true;
        arr[0][4] = true;
        arr[0][6] = true;
        arr[0][8] = true;
        arr[0][9] = true;
        arr[0][10] = true;

        arr[1][1] = true;
        arr[1][4] = true;
        arr[1][6] = true;
        arr[1][8] = true;

        arr[2][1] = true;
        arr[2][4] = true;
        arr[2][5] = true;
        arr[2][6] = true;
        arr[2][8] = true;
        arr[2][9] = true;
        arr[2][10] = true;


        arr[3][1] = true;
        arr[3][4] = true;
        arr[3][6] = true;
        arr[3][8] = true;

        arr[4][1] = true;
        arr[4][4] = true;
        arr[4][6] = true;
        arr[4][8] = true;
        arr[4][9] = true;
        arr[4][10] = true;

        arr[7][0] = true;
        arr[7][1] = true;
        arr[7][2] = true;
        arr[7][4] = true;
        arr[7][5] = true;
        arr[7][6] = true;
        arr[7][8] = true;
        arr[7][9] = true;
        arr[7][10] = true;
        arr[7][12] = true;

        arr[8][0] = true;
        arr[8][4] = true;
        arr[8][6] = true;
        arr[8][8] = true;
        arr[8][10] = true;
        arr[8][12] = true;

        arr[9][0] = true;
        arr[9][1] = true;
        arr[9][2] = true;
        arr[9][4] = true;
        arr[9][6] = true;
        arr[9][8] = true;
        arr[9][10] = true;
        arr[9][12] = true;

        arr[10][0] = true;
        arr[10][4] = true;
        arr[10][6] = true;
        arr[10][8] = true;
        arr[10][10] = true;
        arr[10][12] = true;

        arr[11][0] = true;
        arr[11][4] = true;
        arr[11][5] = true;
        arr[11][6] = true;
        arr[11][8] = true;
        arr[11][9] = true;
        arr[11][10] = true;
        arr[11][12] = true;
        arr[11][13] = true;
        arr[11][14] = true;
        int x = sc.nextInt(), y = sc.nextInt();
        if(arr[x][y]){
            System.out.println("IN");
        }else {
            System.out.println("OUT");
        }

    }
}
