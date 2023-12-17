package com.example.demo.codeforces.CF590;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class C {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }
    static char[][] cs;
    static int[][][] dis;
    static int[][] dirs = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    static int INF = 0x3f3f3f3f;
    static int n, m;
    public static void solve() {
        n = sc.ni();
        m = sc.ni();
        cs = new char[n][m];
        dis = new int[3][n][m];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dis[i][j], INF);
            }
        }
        for (int i = 0; i < n; i++) {
            cs[i] = sc.ns(m);
        }
        for (int i = 0; i < 3; i++) {
            bfs(i);
        }
        int ans = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dis[0][i][j] == INF || dis[1][i][j] == INF || dis[2][i][j] == INF){
                    continue;
                }
                int s = 0;
                for (int k = 0; k < 3; k++) {
                   s += dis[k][i][j];
                }
                if(cs[i][j] == '.'){
                    s-=2;
                }
                ans = Math.min(ans, s);
            }
        }
        ans =  ans == INF?-1:ans;
        out.println(ans);
    }
    public static void bfs(int id){
        PriorityQueue<int[]> dq = new PriorityQueue<>((a,b)->dis[id][a[0]][a[1]] - dis[id][b[0]][b[1]] );
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                if(cs[i][j] - '1' == id){
                    dis[id][i][j] = 0;
                    dq.add(new int[]{i,j});
                }

            }
        }
        while (dq.size()>0){
            int[] p = dq.poll();
            for(int[] d: dirs){
                int x = d[0] + p[0], y = d[1] + p[1];
                if(x<0 || x>=n || y<0 || y>=m){
                    continue;
                }
                if(cs[x][y] == '#'){
                    continue;
                }
                int w = cs[x][y] == '.'?1:0;
                if(dis[id][x][y] > dis[id][p[0]][p[1]] + w){
                    dis[id][x][y] = dis[id][p[0]][p[1]] + w;
                    dq.add(new int[]{x,y});
                }
            }
        }
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
