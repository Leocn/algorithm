package com.example.demo.codeforces.CF1840;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class F {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = sc.ni();
        while (t-->0){
            solve();
        }
        out.close();
    }
    public static void solve(){
        int n = sc.ni() , m = sc.ni();
        int r = sc.ni();
        BitSet[][] dp = new BitSet[n+1][m+1];
        for (int i = 0; i <=n; i++) {
            for (int j = 0; j <=m; j++) {
                dp[i][j] = new BitSet();

            }
        }
        for (int i = 0; i < r; i++) {
            int time = sc.ni(), d = sc.ni(), loc = sc.ni();
            if(time>=  m+n+103){
                continue;
            }
            if(d==1){
                for (int j = 0; j <=m ; j++) {
                    dp[loc][j].set(time);
                }
            }else {
                for (int j = 0; j <=n; j++) {
                    dp[j][loc].set(time);
                }
            }
        }
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dirs = new int[][]{{1, 0},{0,1},{0,0}};
        dq.add(new int[]{0,0,0});
        while (dq.size()>0){
            int s = dq.size();
            while (s-->0){
                int[] p = dq.poll();
                for(int[] dir:dirs){
                    int x = dir[0]+p[0];
                    int y = dir[1] +p[1];
                    int nt = p[2]+1;

                    if(nt>= m+n+103){
                        continue;
                    }
                    if(x>n || y>m || dp[x][y].get(nt)){
                        continue;
                    }
                    if(x==n&& y == m){
                        out.println(nt);
                        return;
                    }
                    dp[x][y].set(nt);
                    dq.add(new int[]{x,y,nt});


                }
            }

        }
        out.println(-1);

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