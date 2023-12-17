package com.example.demo.codeforces.CF1822;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

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
    static List<Integer>[] arr;
    static int[] d1, d2;
    static long ans;
    static long k;
    static long c;
    public static void solve(){
        int n = sc.ni();
        ans = 0;
        k = sc.ni();
        c = sc.ni();
        arr = new List[n+1];
        d1 = new int[n+1];
        d2 = new int[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int x = sc.ni(), y = sc.ni();
            arr[x].add(y);
            arr[y].add(x);
        }
        dfs1(1, -1,0);
        dfs2(1,-1,0);
        out.println(ans);
    }

    private static void dfs1(int now , int p, int step){
        step++;
        for(int d: arr[now]){
            if(d==p){
                continue;
            }
            d2[d] = step;
            dfs1(d, now, step);
            d1[now] = Math.max(d1[d]+1, d1[now]);
        }

    }
    private static void dfs2(int now, int p, int cnt){
        int max1 = 0, max2 = 0;
        for(int d: arr[now]){
            if(d==p){
                continue;
            }
            if(d1[d]+1>max1){
                max2 = max1;
                max1 = d1[d]+1;
            }else if(d1[d]+1>max2){
                max2 = d1[d]+1;
            }
        }
        int m = 0;
        for(int d: arr[now]){
            if(d==p){
                continue;
            }
            if(d1[d]+1 == max1){
                m = max2;
            }else {
                m = max1;
            }
            m = Math.max(m, cnt);

            dfs2(d, now, m+1);


        }
        ans = Math.max(k*Math.max(max1, cnt)-  c *d2[now], ans);


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
