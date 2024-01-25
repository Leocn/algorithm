package com.example.demo.codeforces.CF1920;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    /***
     * DP 关注最后一位数
     */
    public static void solve() {
        int n = sc.ni();
        int q = sc.ni();
        long[] dp = new long[n+1];
        int[] lastAdd = new int[n+1];
        long max = (long)2e18;

        for (int i = 1; i <= n; i++) {
            int a = sc.ni();
            int v = sc.ni();
            if(a == 1){
                lastAdd[i] = v;
                dp[i] = dp[i-1] + 1;
            }else {
                lastAdd[i] = lastAdd[i-1];
                dp[i] = (v+1)>max/dp[i-1]?max:dp[i-1]*(v+1);
            }

        }

        StringBuilder sb = new StringBuilder();
        while (q-->0){
            long k = sc.nl();
            int ans = 0;
            while (true){
                int pos = lowerBound(dp, k) ;
                if(dp[pos] == k){
                    ans = lastAdd[pos];
                    break;
                }
                if(k% dp[pos-1] == 0){
                    ans = lastAdd[pos-1];
                    break;
                }
                k%=dp[pos-1];
            }
            sb.append(ans).append(" ");

        }
        out.println(sb);
    }

    /**
     * dp[i]>=k 的最小i
     * */
    public static int lowerBound(long[] dp, long k) {
        int pos = Arrays.binarySearch(dp, k);
        if (pos < 0) {
            pos = -(pos + 1);
        }
        return pos;
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
