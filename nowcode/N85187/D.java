package com.example.demo.nowcode.N85187;

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

    public static void solve() {
        int n = sc.ni();
        int[] a = sc.na(n);
        long[][] dp = new long[n][9];
        dp[0][1] = Long.MAX_VALUE/10;
        dp[0][2] = Long.MAX_VALUE/10;
        dp[0][3] = Long.MAX_VALUE/10;

        for (int i = 1; i < n; i++) {
            int t = Math.abs(a[i - 1] - a[i]);
            dp[i][0] = dp[i - 1][0] + t;
            dp[i][1] = Math.min(dp[i - 1][1] + t, dp[i - 1][4] + Math.abs(a[i - 1] * 2 - a[i]));
            dp[i][2] = Math.min(dp[i - 1][2] + t, dp[i - 1][6] + Math.abs(a[i - 1] / 2 - a[i]));
            dp[i][3] = Math.min(dp[i - 1][3] + t, dp[i - 1][8] + Math.abs(a[i] - a[i - 1] / 2 * 2));
            dp[i][3] = Math.min(Math.min( dp[i][3], dp[i - 1][5] + Math.abs(a[i - 1] * 2 - a[i])), dp[i - 1][7] + Math.abs(a[i - 1] / 2 - a[i]));

            dp[i][4] = dp[i - 1][0] + Math.abs(a[i - 1] - a[i] * 2);
            dp[i][5] = Math.min(dp[i - 1][2] + Math.abs(a[i - 1] - a[i] * 2), dp[i - 1][6] + Math.abs(a[i - 1] / 2 - a[i] * 2));

            dp[i][6] = dp[i - 1][0] + Math.abs(a[i - 1] - a[i] / 2);
            dp[i][7] = Math.min(dp[i - 1][1] + Math.abs(a[i - 1] - a[i] / 2), dp[i - 1][4] + Math.abs(a[i - 1] * 2 - a[i] / 2));
            dp[i][8] = dp[i - 1][0] + Math.abs(a[i - 1] - a[i] / 2 * 2);
        }
        out.println(Math.min(Math.min(Math.min(dp[n-1][3], dp[n-1][5]), dp[n-1][7]), dp[n-1][8]));

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
