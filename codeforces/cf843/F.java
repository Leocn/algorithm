package com.example.demo.codeforces.cf843;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class F {
    static int N = (int)4e5 + 50;
    static int[][][] f = new int[5][1500][1500];
    static int M, a;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int q = sc.nextInt();
        int type = sc.nextInt();
        if(type==2){
            M = sc.nextInt();
            preCalc();
        }
        while (q-->0){
            int n = sc.nextInt();
            int p = getP(n);
            if (type == 1) {
                int _n=0, _m=0;
                for (int x = 1; x <= p; x++) {
                    int y = p - x;
                    if (x + y == p && x * y >= n) {
                        _n = x; _m = y;
                        break;
                    }
                }
                char[][] ans = new char[_n][_m];
                for(char[] a: ans){
                    Arrays.fill(a, '#');
                }
                out.println(_n + " " + _m);
                for (int i = 0; i < _n * _m - n; i++) {
                    ans[i][0] = '.';
                }
                for (int i = 0; i < _n; i++) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < _m; j++) {
                        sb.append( ans[i][j]);
                    }
                    out.println(sb);
                }

                continue;
            }

            int ans = 0;
            for (int x = 1; x <= p; x++) {
                int y = p - x;
                if (x + y == p && x * y >= n) {
                    ans = (ans +  f[4][x * y - n][a]) % M;
                }
            }
            out.println(p * 2 + " " + ans);
        }
        out.close();
    }
    private static int getP(int n){
        int a = (int)Math.sqrt(n);
        if (a * a < n && a * a + a >= n) {
            return 2 * a + 1;
        }
        if (a * a + a < n && n <= (a + 1) * (a + 1)) {
            return 2 * (a + 1);
        }
        return 2 * a;
    }

    private static void preCalc(){
        a = (int)Math.sqrt(N)+5;
        f[0][0][a] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= a; j++) {
                for (int was = a; was >=0 ; was--) {
                    if(was>0 && j+was<=a){
                        f[i][j + was][was] = (f[i][j + was][was] + f[i][j][was]) % M;
                    }
                    if (was>0) {
                        f[i][j][was - 1] = (f[i][j][was - 1] +  f[i][j][was]) % M;
                    }
                }
                f[i + 1][j][a] +=  (f[i + 1][j][a] + f[i][j][0]) % M;

            }
        }
    }


}
