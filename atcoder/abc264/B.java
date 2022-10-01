package com.example.demo.atcoder.abc264;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[][] grid = new int[16][16];
        for (int i = 1; i < 16; i++) {
            for (int j = 1; j < 16; j++) {
                if((i==1 || i==15) || (j==1 || j==15) || ((i==3 ||i==13) &&j>=3 && j<=13) ||  ((j==3 || j==13)&&i>=3 && i<=13)
                    || ((i==5 ||i==11) &&j>=5 && j<=11) ||  ((j==5 ||j==11)&&i>=5 && i<=11)
                        || ((i==7 ||i==9)&&j>=7 && j<=9) ||  ((j==7 ||j==9)&&i>=7 && i<=9)
                ){
                    grid[i][j] = 1;
                }
            }
        }
        int x = sc.nextInt();
        int y = sc.nextInt();
        String ans = grid[x][y]==1?"black":"white";
        System.out.println(ans);

    }
}
