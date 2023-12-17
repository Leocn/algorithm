package com.example.demo.codeforces.CF1207;

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

    static int mod = 998244353;
    public static void solve() {
        int n = sc.ni();
        int[] cnt1 = new int[n+1];
        int[] cnt2 = new int[n+1];
        long[] mul = new long[n+1];
        mul[0] = 1;
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int a = sc.ni(), b = sc.ni();
            cnt1[a]++;
            cnt2[b]++;
            list.add(new int[]{a, b});
            mul[i] = mul[i-1] *(i)%mod;
        }
        long ans2 = 1;
        long ans3 = 1;
        for (int i = 1; i<=n; i++) {
            if(cnt1[i]>0){
                ans2 = ans2*mul[cnt1[i]]%mod;
            }
            if(cnt2[i]>0){
                ans3 = ans3 * mul[cnt2[i]]%mod;
            }
        }
        list.sort((x, y) -> {
            if (x[0] - y[0] == 0) {
                return x[1] - y[1];
            }
            return x[0] - y[0];
        });
        int p = 1;
        long ans4 = 1;
        for (int i = 1; i <n ; i++) {
            int[] pre = list.get(i-1);
            int[] cur = list.get(i);
            if(cur[1]<pre[1]){
                ans4 = 0;
                break;
            }
            if(cur[1]==pre[1]&&cur[0]==pre[0]){
                p++;
            }else {
                ans4 = (ans4*mul[p])%mod;
                p = 1;
            }
        }
        ans4 = (ans4*mul[p])%mod;
        long ans = ((mul[n] - ans2 - ans3 + ans4)%mod + mod)%mod;
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
