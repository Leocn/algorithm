package com.example.demo.nowcode.N80742;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        int q = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int[][] pre = new int[n+1][3];
        for (int i = 0; i < n; i++) {
            System.arraycopy(pre[i], 0, pre[i + 1], 0, 3);
            if(cs[i] == 'r'){
                pre[i+1][0]++;
            }else if(cs[i] == 'e'){
                pre[i+1][1]++;
            }else if(cs[i] == 'd'){
                pre[i+1][2]++;
            }
        }
        while (q-->0){
            int l = sc.ni()-1;
            int r = sc.ni()-1;
            if(r-l<=1){
                out.println(0);
                continue;
            }
            int sum = r - l + 1;
            int left = sum%3;
            int k = sum/3;

            int ans = 0;
            if(left == 0){
                ans = pre[l+k][0]- pre[l][0] + pre[l+2*k][1] - pre[l+k][1] + pre[l+3*k][2] - pre[l+2*k][2];
            }else if(left==1){
                ans = Math.max(pre[l+k+1][0]- pre[l][0] + pre[l+2*k+1][1] - pre[l+k+1][1] + pre[l+3*k+1][2] - pre[l+2*k+1][2], ans);
                ans = Math.max(pre[l+k][0]- pre[l][0] + pre[l+2*k+1][1] - pre[l+k][1] + pre[l+3*k+1][2] - pre[l+2*k+1][2], ans);
                ans = Math.max(pre[l+k][0]- pre[l][0] + pre[l+2*k][1] - pre[l+k][1] + pre[l+3*k+1][2] - pre[l+2*k][2], ans);
            }else {
                ans = Math.max(pre[l+k+1][0]- pre[l][0] + pre[l+2*k+2][1] - pre[l+k+1][1] + pre[l+3*k+2][2] - pre[l+2*k+2][2], ans);
                ans = Math.max(pre[l+k+1][0]- pre[l][0] + pre[l+2*k+1][1] - pre[l+k+1][1] + pre[l+3*k+2][2] - pre[l+2*k+1][2], ans);
                ans = Math.max(pre[l+k][0]- pre[l][0] + pre[l+2*k+1][1] - pre[l+k][1] + pre[l+3*k+2][2] - pre[l+2*k+1][2], ans);
            }
            out.println(sum - ans);


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
