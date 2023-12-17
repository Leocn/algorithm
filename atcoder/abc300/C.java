package com.example.demo.atcoder.abc300;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w= sc.nextInt();
        char[][] cs = new char[h][w];
        for (int i = 0; i < h; i++) {
            cs[i] = sc.next().toCharArray();
        }
        int[] ans = new int[Math.min(h,w)];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int d = 1;
                if(cs[i][j]!='#'){
                    continue;
                }

                while (i-d>=0 && j-d>=0 && i+d<h && j+d<w
                        && cs[i-d][j-d]=='#'
                        && cs[i-d][j+d]=='#'
                        && cs[i+d][j+d]=='#'
                        && cs[i+d][j-d]=='#'){
                    d++;
                }
                if(d>=2){
                   ans[d-2]++;

                }


            }
        }
        StringBuilder sb = new StringBuilder();
        for (int an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);







    }
}
