package com.example.demo.lanqiao.newbee7;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class B {
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
        char[] cs = sc.ns().toCharArray();
        char[] ts = sc.ns().toCharArray();
        int[][] merge = new int[10][7];
        merge[0][0] = 1;
        merge[0][1] = 1;
        merge[0][2] = 1;
        merge[0][4] = 1;
        merge[0][5] = 1;
        merge[0][6] = 1;

        merge[1][2] = 1;
        merge[1][6] = 1;


        merge[2][1] = 1;
        merge[2][2] = 1;
        merge[2][3] = 1;
        merge[2][4] = 1;
        merge[2][5] = 1;



        merge[3][1] = 1;
        merge[3][2] = 1;
        merge[3][3] = 1;
        merge[3][5] = 1;
        merge[3][6] = 1;



        merge[4][0] = 1;
        merge[4][2] = 1;
        merge[4][3] = 1;
        merge[4][6] = 1;

        merge[5][0] = 1;
        merge[5][1] = 1;
        merge[5][3] = 1;
        merge[5][5] = 1;
        merge[5][6] = 1;


        merge[6][0] = 1;
        merge[6][1] = 1;
        merge[6][3] = 1;
        merge[6][4] = 1;
        merge[6][5] = 1;
        merge[6][6] = 1;

        merge[7][1] = 1;
        merge[7][2] = 1;
        merge[7][6] = 1;


        merge[8][0] = 1;
        merge[8][1] = 1;
        merge[8][2] = 1;
        merge[8][3] = 1;
        merge[8][4] = 1;
        merge[8][5] = 1;
        merge[8][6] = 1;


        merge[9][0] = 1;
        merge[9][1] = 1;
        merge[9][2] = 1;
        merge[9][3] = 1;
        merge[9][5] = 1;
        merge[9][6] = 1;


        int n= cs.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 7; j++) {
                if(merge[cs[i]-'0'][j]!= merge[ts[i]-'0'][j]){
                    ans++;
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
