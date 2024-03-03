package com.example.demo.nowcode.N76133;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class F {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }
    static int mod = (int)1e9+7;
    static long[] fac = fac(100005, mod);
    static long[] facR = facR(100005, mod);
    static long[] pw = pow(2, 100005, mod);
    private static long[] pow(long p, long w, int mod) {
        long[] res = new long[(int)w];
        long r = 1;
        for (int i = 0; i < w; i++) {
            res[i] = r;
            r = r*p%mod;
        }
        return res;
    }


    private static long comb(int a, int b) {
        if (a < b) return 0;
        return combine(a, b, mod);
    }
    //递推求阶乘
    static long[] fac(int n, long p) {
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] * i % p;
        }
        return f;
    }

    //facR
    static long[] facR(int n, long p) {
        long[] fr = new long[n + 1];
        fr[n] = pow(fac[n], p - 2, p) ;
        for (int i = n-1; i>=0 ; i--) {
            fr[i] = fr[i + 1] * (i+1) % p;
        }
        return fr;
    }

    //快速幂 x^k mod p
    static long pow(long x, long k, long p) {
        long res = 1;
        while (k != 0) {
            if ((k & 1) != 0) res = res * x % p;
            x = x * x % p;
            k >>= 1;
        }
        return res;
    }


    //公式法求组合数 O(NlogP)  结合逆元  求  C(a,b) mod p      a!/(b! (a-b)!)   1≤b≤a≤10^5
    static long combine(int a, int b, int p) {
        //先预处理出阶乘   然后 每次 常数时间求解
        return (fac[a] * facR[b] % p) * facR[a - b] % p;
    }
    public static void solve() {
        int n = sc.ni();
        int[] g = sc.na(n);
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            cnt[g[i]]++;
        }
        long ans = 0;

        long c2 = 0, c2Plus = 0, f2= 0;
        long[] dp2 = new long[100001];
        long[] dp2Plus = new long[100001];
        for (int i = 1; i <= cnt[2]; i++) {
            long fp2 = comb(cnt[2],i)%mod;
            dp2[i] = fp2 * i %mod;
            dp2Plus[i] = fp2*(i+1)%mod;
            c2 = (c2+dp2[i])%mod;
            c2Plus = (c2Plus+dp2Plus[i])%mod;
            f2 = (f2 + fp2)%mod;
        }
        ans = (pw[n]-1)%mod + pw[cnt[1]] *(c2)%mod;


        long c3 = 0;
        long[] fp3 = new long[100001];
        for (int i = 1; i <= cnt[3]; i++) {
            fp3[i] = comb(cnt[3],i)%mod;
            c3 = (c3+ fp3[i] * i )%mod;
        }

         ans =( ans + (pw[cnt[1]] *(c3))%mod  )%mod;

        for (int i = 1; i <= cnt[3]; i++) {
            ans = (ans + (c2Plus *(i+1)%mod - f2)%mod *fp3[i]%mod*pw[cnt[1]]%mod + mod)%mod;


        }
        out.println(ans%mod);

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
