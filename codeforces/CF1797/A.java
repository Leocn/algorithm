package com.example.demo.codeforces.CF1797;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class A {
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
      long n = sc.ni(), m = sc.ni();
      long x1 = sc.ni(), y1 = sc.ni(), x2 = sc.ni(), y2 = sc.ni();
      long ans = Math.min(Math.abs(x1) + Math.abs(y1), Math.abs(n-x1+1) + Math.abs(m-y1+1));
        ans = Math.min(Math.abs(x2) + Math.abs(y2) ,ans);
        ans = Math.min(Math.abs(n-x2+1) + Math.abs(m-y2+1) ,ans);
        ans = Math.min(Math.abs(x1) + Math.abs(m-y1+1), ans);
        ans = Math.min(Math.abs(n-x1+1) + Math.abs(y1), ans);
        ans = Math.min(Math.abs(x2) + Math.abs(m-y2+1), ans);
        ans = Math.min(Math.abs(n-x2+1) + Math.abs(y2), ans);
        ans = Math.min(x1+ x1 + 1, ans);
        ans = Math.min(y1+ y1 + 1, ans);
        ans = Math.min(x2+ x2 + 1, ans);
        ans = Math.min(y2+ y2 + 1, ans);

        ans = Math.min(n-x1+ n-x1 + 3, ans);
        ans = Math.min(m- y1+ m- y1 + 3, ans);
        ans = Math.min(n-x2+ n-x2 + 3, ans);
        ans = Math.min(m-y2+ m-y2 + 3, ans);
        if(x1!=x2){
            ans = Math.min(n, ans);
        }
        if(y1!=y2){
            ans = Math.min(m, ans);
        }
        ans = Math.min(ans,4);
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
