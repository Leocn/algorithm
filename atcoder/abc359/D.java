package com.example.demo.atcoder.abc359;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Set;

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
        int k = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int max = (1<<(k-1));
        long[][] dp = new long[n][max];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 1<<k; i++) {
            if(!isPr(i, k)){
                set.add(i);
            }
        }

        out:for (int i = 0; i < max; i++) {
            int c = i;

            for (int j = 0; j <=k-2; j++) {
                if(cs[j] == '?') {
                    c/=2;
                    continue;
                }
                if(cs[j] == 'A' && (c&1)==0) {
                    c/=2;
                    continue;
                }
                if(cs[j] == 'B' && (c&1)==1){
                    c/=2;
                    continue;
                }
                continue out;
            }
            dp[k-2][i] = 1;
        }
        int mod = 998244353;
        for (int i = k-1; i <n; i++) {
            int l = cs[i] == '?'?-1:cs[i]-'A';
            for (int j = 0; j < max; j++) {
                if(l == -1){
                    int f = (0<<(k-1))|j;
                    if(set.contains(f)){
                        dp[i][f>>1] = (dp[i][f>>1] + dp[i-1][j])%mod;
                    }
                    f = (1<<(k-1))|j;
                    if(set.contains(f)){
                        dp[i][f>>1] = (dp[i][f>>1] + dp[i-1][j])%mod;
                    }
                }else {
                    int f = (l<<(k-1))|j;
                    if(set.contains(f)){
                        dp[i][f>>1] = (dp[i][f>>1] + dp[i-1][j])%mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < max; i++) {
            ans =  (ans + dp[n-1][i])%mod;
        }
        out.println(ans);



//        for (int i = 0; i < ; i++) {
//
//        }
    }

    private static boolean isPr(int c, int k){
        int[] cnt = new int[k];
        for (int i = 0; i < k; i++) {
            cnt[i] = c%2;
            c/=2;
        }
        for (int i = 0; i < k; i++) {
            if(cnt[i] != cnt[k-i-1]){
                return false;
            }
        }
        return true;
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
