package com.example.demo.codeforces.tfr8;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class D {
    static class dsu {
        int N;
        int[] par, size;

        dsu(int n) {
            N = n;
            par = new int[N];
            size = new int[N];
            Arrays.fill(size, 1);
            for (int i = 0; i < N; i++) {
                par[i] = i;
            }
        }

        int find(int u) {
            return par[u] == u ? u : find(par[u]);
        }

        int join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return 0;
            if (size[u] < size[v]) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            par[v] = u;
            size[u] += size[v];
            return 1;
        }
    }

    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        int n = sc.ni(), m = sc.ni();
        int[][] g = new int[n][m];
        for (int i = 0; i < n; i++) {
            g[i] = sc.na(m);
        }
        /*
            just iterate cells in increasing order,
            maintain dsu and check neighbors
        */
        /*
            id of [i,j]: m*i + j
        */
        int[][] have = new int[n * m][2];
        for (int i = 0; i < n * m; i++) {
            Arrays.fill(have[i], -1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] <= n * m)
                    have[g[i][j] - 1] = new int[]{i, j};
            }
        }
        int[][] alive = new int[n][m];
        dsu ds = new dsu(n * m);
        int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
        int ans = 0, tot = 0;
        for (int i = 0; i < n * m; i++) {
            if (have[i][0] == -1) break;
            int r = have[i][0], c = have[i][1];
            int id = r * m + c;
            tot++;
            alive[r][c] = 1;
            for (int d = 0; d < 4; d++) {
                int rr = r + dr[d], cc = c + dc[d];
                if (rr < 0 || cc < 0 || rr > n - 1 || cc > m - 1 || alive[rr][cc] != 1) continue;
                int jd = rr * m + cc;
                tot -= ds.join(id, jd);
            }

            if (tot == 1) ans = i + 1;

        }
        System.out.println(ans);
    }
    static public class RealFastReader {
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