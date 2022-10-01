package com.example.demo.codeforces.cf818;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int r = sc.nextInt()-1;
            int c = sc.nextInt()-1;
            char[][] ans = new char[2*n][2*n];
            for(char[] chars: ans){
                Arrays.fill(chars, '.');
            }
            ans[r][c] = 'X';
            Deque<int[]> deque = new ArrayDeque<>();
            deque.add(new int[]{r,c});
            int[][] dirs = new int[][]{{1,-1}, {-1,1},{-k,0},{k,0},{0,k},{0,-k}};
            while (deque.size()>0){
                int[] poll = deque.poll();

                for(int[] dir: dirs){
                    int x = poll[0] + dir[0], y = poll[1]+dir[1];
                    if(x<0 || x>=2*n || y>=2*n || y<0){
                        continue;
                    }
                    if(ans[x][y] == 'X'){
                        continue;
                    }
                    deque.add(new int[]{x,y});
                    ans[x][y] = 'X';

                }
            }
            for (int i = 0; i <n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    sb.append(ans[i][j]);
                }
                System.out.println(sb);
            }


        }
    }

}
