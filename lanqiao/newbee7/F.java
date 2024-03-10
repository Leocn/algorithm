package com.example.demo.lanqiao.newbee7;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class F {
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
        int n = sc.ni(), m = sc.ni(), n1 = sc.ni(), m1 = sc.ni();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.ni();
            }
        }

        int[][] ma_grid = new int[n][m - m1 + 1];
        int[][] mi_grid = new int[n][m - m1 + 1];
        long[][] ad_grid = new long[n][m - m1 + 1];

        int[] q1 = new int[Math.max(n, m) + 1];
        int[] q2 = new int[Math.max(n, m) + 1];
        for (int i = 0; i < n; i++) {
            int l1 = 0, r1 = 0;
            int l2 = 0, r2 = 0;

            long[] acc = new long[m + 1];
            for (int j = 1; j <= m; j++) {
                acc[j] = acc[j - 1] + grid[i][j - 1];
            }

            for (int j = 0; j < m; j++) {
                if (q1[l1] == j - m1) l1++;
                while (l1 < r1 && grid[i][q1[r1 - 1]] <= grid[i][j]) {
                    r1--;
                }
                q1[r1++] = j;

                if (q2[l2] == j - m1) l2++;
                while (l2 < r2 && grid[i][q2[r2 - 1]] >= grid[i][j]) {
                    r2--;
                }
                q2[r2++] = j;

                if (j >= m1 - 1) {
                    ma_grid[i][j - m1 + 1] = grid[i][q1[l1]];
                    mi_grid[i][j - m1 + 1] = grid[i][q2[l2]];
                    ad_grid[i][j - m1 + 1] = acc[j + 1] - acc[j - m1 + 1];
                }
            }
        }

        long ans = 0;
        for (int j = 0; j < m - m1 + 1; j++) {
            int l1 = 0, r1 = 0;
            int l2 = 0, r2 = 0;

            long[] acc = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                acc[i] = acc[i - 1] + ad_grid[i - 1][j];
            }

            for (int i = 0; i < n; i++) {
                if (q1[l1] == i - n1) l1++;
                while (l1 < r1 && ma_grid[q1[r1 - 1]][j] <= ma_grid[i][j]) {
                    r1--;
                }
                q1[r1++] = i;

                if (q2[l2] == i - n1) l2++;
                while (l2 < r2 && mi_grid[q2[r2 - 1]][j] >= mi_grid[i][j]) {
                    r2--;
                }
                q2[r2++] = i;

                if (i >= n1 - 1) {
                    ans = Math.max(ans, (long)(ma_grid[q1[l1]][j] - mi_grid[q2[l2]][j]) * (acc[i + 1] - acc[i - n1 + 1]));
                }
            }
        }
        out.println(ans);

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
