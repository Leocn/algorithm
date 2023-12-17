package com.example.demo.nowcode.N68346;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }


    static long[][][] mem;
    static int x;
    public static void solve() {
        int n = sc.ni();
        x = sc.ni();
        int[] a = sc.na(n);
        int[] b = sc.na(n);

//        mem = new long[n+1][x+1][2];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <=x; j++) {
//                Arrays.fill(mem[i][j], Long.MIN_VALUE/10);
//            }
//        }
//        long ans = dfs(0, 1,  a, b, 0);
//        out.println(ans);




        long[][] dp = new long[x+1][2];
        for (int j = 0; j <=x; j++) {
            Arrays.fill(dp[j], Long.MIN_VALUE/10);
        }
        dp[x][0] = 0;
        for (int i = 0; i < n; i++) {
            long[][] tem = new long[x+1][2];
            for (int j = 0; j <=x; j++) {
                Arrays.fill(tem[j], Long.MIN_VALUE/10);
            }
            for (int j = 0; j <=x; j++) {
                if(j>=a[i]){
                    tem[j-a[i]][1] = Math.max(tem[j-a[i]][1], Math.max(dp[j][0] , dp[j][1]) + b[i]);
                }
                if(j>=a[i]/2){
                    tem[j-a[i]/2][0] = Math.max(tem[j-a[i]/2][0], dp[j][1] + b[i]);
                }
                tem[j][0] = Math.max(tem[j][0], Math.max(dp[j][0], dp[j][1]));
            }
            dp = tem;
        }
        long ans = 0;
        for (int i = 0; i <=x ; i++) {
            ans = Math.max(ans , Math.max(dp[i][0], dp[i][1]));
        }
        out.println(ans);

    }

    static private long dfs(int cur, int before, int[] a, int[] b, int sum){
        long res = 0;
        if(sum == x){
            return 0;
        }
        if(sum>x){
            return Long.MIN_VALUE/10;
        }
        if(cur == a.length){
            return 0;
        }
        if(mem[cur][sum][before]>= 0){
            return mem[cur][sum][before];
        }
        if(before ==0){
            res = Math.max(res, dfs(cur +1, 1, a,b,sum + a[cur]/2) + b[cur]);
        }
        res = Math.max(res, dfs(cur +1, 0, a,b,sum + a[cur]) + b[cur]);
        res = Math.max(res, dfs(cur +1, 1, a,b,sum));
        mem[cur][sum][before] = res;
        return res;
    }

    public static class RealFastReader {
        InputStream is;

        public RealFastReader(final InputStream is) {
            this.is = is;
        }

        private byte[] inbuf = new byte[8192];
        public int lenbuf = 0, ptrbuf = 0;

        public int readByte() {
            if (lenbuf == -1) {
                throw new InputMismatchException();
            }
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) {
                    return -1;
                }
            }
            return inbuf[ptrbuf++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
                ;
            return b;
        }

        public double nd() {
            return Double.parseDouble(ns());
        }

        public char nc() {
            return (char) skip();
        }

        public String ns() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] ns(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nal(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public char[][] nm(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = ns(m);
            }
            return map;
        }

        public int[][] nmi(int n, int m) {
            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                map[i] = na(m);
            }
            return map;
        }

        public int ni() {
            int num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nl() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
                ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}
