package com.example.demo.codeforces.ecf139;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            char[][] cs = new char[2][n];
            cs[0] = scanner.next().toCharArray();
            cs[1] = scanner.next().toCharArray();
            int  cnt = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    if(cs[i][j]=='B'){
                        cnt++;
                    }
                }
            }
            Deque<int[]> deque = new ArrayDeque<>();
            int ans = 0;
            boolean[][] vis = new boolean[2][n];
            if(cs[0][0]=='B'){
                deque.add(new int[]{0,0});
                vis[0][0] = true;
            }

            while (deque.size()>0){
                int[] p = deque.poll();
                vis[p[0]][p[1]] = true;
                ans++;
                if(p[0]==0){
                    if(cs[1][p[1]]=='B' && !vis[1][p[1]]){
                        deque.add(new int[]{1, p[1]});
                    }else if(p[1]+1<n && cs[0][p[1]+1] == 'B'){
                        deque.add(new int[]{0, p[1]+1});
                    }

                }else{
                    if(cs[0][p[1]]=='B' && !vis[0][p[1]]){
                        deque.add(new int[]{0, p[1]});
                    }else if(p[1]+1<n && cs[1][p[1]+1] == 'B'){
                        deque.add(new int[]{1, p[1]+1});
                    }
                }
            }
            if(ans == cnt){
                System.out.println("YES");
                continue;
            }

            ans = 0;
             vis = new boolean[2][n];
            if(cs[1][0]=='B'){
                deque.add(new int[]{1,0});
                vis[1][0] = true;
            }
            while (deque.size()>0){
                int[] p = deque.poll();
                vis[p[0]][p[1]] = true;
                ans++;
                if(p[0]==0){
                    if(cs[1][p[1]]=='B' && !vis[1][p[1]]){
                        deque.add(new int[]{1, p[1]});
                    }else if(p[1]+1<n && cs[0][p[1]+1] == 'B'){
                        deque.add(new int[]{0, p[1]+1});
                    }

                }else{
                    if(cs[0][p[1]]=='B' && !vis[0][p[1]]){
                        deque.add(new int[]{0, p[1]});
                    }else if(p[1]+1<n && cs[1][p[1]+1] == 'B'){
                        deque.add(new int[]{1, p[1]+1});
                    }
                }
            }
            if(ans == cnt){
                System.out.println("YES");

            }else {
                System.out.println("NO");
            }
        }
    }

}
