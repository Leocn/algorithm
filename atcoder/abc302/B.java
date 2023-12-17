package com.example.demo.atcoder.abc302;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int[][] dirs = new int[][]{{-1,0},{1, 0}, {0,-1},{0,1},{-1,-1},{1,1},{-1,1},{1,-1}};
        char[] cs = new char[]{'n','u','k','e'};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] =='s'){

                    out : for(int[] dir: dirs){
                        int x = i, y= j ;
                        List<int[]> ans = new ArrayList<>();
                        ans.add(new int[]{x,y});
                        for (int k = 0; k < 4; k++) {
                            x = x+dir[0];
                            y=  y + dir[1];
                            if(x<0 || x>=n || y<0 || y>=m || arr[x][y]!= cs[k]){
                                continue out;
                            }
                            ans.add(new int[]{x,y});
                        }
                        for (int k = 0; k < 5; k++) {
                            System.out.println((ans.get(k)[0]+1) + " " + (ans.get(k)[1]+1));

                        }
                        return;
                    }


                }
            }
        }

    }
}
