package com.example.demo.codeforces.CF1799;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class D {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        RealFastReader sc = new RealFastReader(System.in);
        int t = sc.ni();
        while (t-->0){
            int n = sc.ni();
            int k = sc.ni();
            int [] arr = new int[n+1];
            int[] cold = new int[k+1];
            int[] hot = new int[k+1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.ni();
            }
            for (int i = 1; i <= k; i++) {
                cold[i] = sc.ni();
            }

            for (int i = 1; i <= k; i++) {
                hot[i] = sc.ni();
            }


            long [][] dp = new long [n + 1][n + 1];
            dp[1][0] = cold[arr[1]];

            for (int i = 2; i <=n; ++i) {
                int prev = i-1 ;
                long val;
                Arrays.fill(dp[i], Long.MAX_VALUE);

                for (int j = i - 2; j >= 0; --j ) {
                    val = dp[prev][j] + (arr[i] == arr[j] ? hot[arr[i]] : cold[arr[i]]);
                    dp[i][prev] = Math.min(dp[i][prev], val);

                    val = dp[prev][j] + (arr[i] == arr[prev] ? hot[arr[i]] : cold[arr[i]]);
                    dp[i][j] = Math.min(dp[i][j], val);
                }
            }

            long result = Long.MAX_VALUE;

            for (int i = 0; i < n; ++i) {
                result = Math.min(result, dp[n][i]);
            }

            out.println(result);

        }
        out.close();
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
