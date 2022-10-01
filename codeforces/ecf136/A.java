package com.example.demo.codeforces.ecf136;

import java.util.Scanner;

public class A {
    static int[][] dirs = new int[][]{{2,-1},{2,1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean flag = true;
            out:for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int count = 0;
                    for(int[] dir : dirs){
                        int x = dir[0]+ i;
                        int y = dir[1] + j;
                        if(x<0|| x>=n || y<0 || y>=m){
                            count++;
                        }
                        if(count==8){
                            System.out.println((i+1) + " " + (j+1));
                            flag = false;
                            break out;
                        }
                    }
                }
            }
            if(flag){
                System.out.println(n + " " + m);
            }


        }
    }
}
