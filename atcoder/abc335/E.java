package com.example.demo.atcoder.abc335;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class E {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void solve(){
        int n = sc.ni();
        int m = sc.ni();

        int[] num = sc.na(n);
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.ni()- 1, b = sc.ni() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        DJSet ds = new DJSet(n);

        for (int i = 0; i < n; i++) {
            for(int w: g[i]){
                if(num[i] == num[w]){
                    ds.unite(i, w);
                }
            }
        }
        int[][] ai = new int[n][2];
        for (int i = 0; i < n; i++) {
            ai[i][0] = num[i];
            ai[i][1] = i;
        }
        Arrays.sort(ai, (a,b)->a[0]-b[0]);
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE/3);

        for (int i = 0; i < n; i++) {
            int t = ai[i][1];
            int tr = ds.root(t);
            dp[tr] = Math.max(dp[tr], t == 0 ? 1 : Integer.MIN_VALUE / 3);
            for(int e : g[t]){
                if(num[t] > num[e]){
                    dp[tr] = Math.max(dp[tr], dp[ds.root(e)]+1);
                }
            }
        }
        out.println(Math.max(dp[ds.root(n - 1)], 0));
        

    }

    /**
     * 并查集
     * */
    public static class DJSet {
        public int[] upper;

        public DJSet(int n) {
            upper = new int[n];
            Arrays.fill(upper, -1);
        }

        public int root(int x) {
            return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
        }

        public boolean equiv(int x, int y) {
            return root(x) == root(y);
        }

        public boolean unite(int x, int y) {
            x = root(x);
            y = root(y);
            if (x != y) {
                if (upper[y] < upper[x]) {
                    int d = x;
                    x = y;
                    y = d;
                }
                upper[x] += upper[y];
                upper[y] = x;
            }
            return x == y;
        }

        public int count() {
            int ct = 0;
            for (int u : upper) if (u < 0) ct++;
            return ct;
        }

        public int[][] toBucket() {
            int n = upper.length;
            int[][] ret = new int[n][];
            int[] rp = new int[n];
            for (int i = 0; i < n; i++) if (upper[i] < 0) ret[i] = new int[-upper[i]];
            for (int i = 0; i < n; i++) {
                int r = root(i);
                ret[r][rp[r]++] = i;
            }
            return ret;
        }
    }
    /**
     * 最短路 超时
     * */
//    public static void solve() {
//        int n = sc.ni();
//        int m = sc.ni();
//        int[] num = sc.na(n);
//        ArrayList<Integer>[] g = new ArrayList[n];
//        for (int i = 0; i < n; i++) {
//            g[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < m; i++) {
//            int a = sc.ni() - 1;
//            int b = sc.ni() - 1;
//            if(num[a] == num[b]){
//                g[a].add(b);
//                g[b].add(a);
//            }else if(num[a]>num[b]){
//                g[b].add(a);
//            }else {
//                g[a].add(b);
//            }
//        }
//        // boolean[] vis = new boolean[n];
//
//        int[] dp = new int[n];
//        Deque<int[]> dq = new ArrayDeque<>();
//        dq.add(new int[]{0,1});
//        while (dq.size()>0){
//            int[] poll = dq.poll();
//            int p = poll[0];
//            if(poll[1]<= dp[p]){
//                continue;
//            }
//            dp[p] = poll[1];
//            for(int w: g[p]){
//                if(num[w]<num[p]){
//                    continue;
//                }
//                if(num[w] == num[p]){
//                    if(dp[w] == dp[p]){
//                        continue;
//                    }
//                    //dp[w] = dp[p];
//                    dq.add(new int[]{w, dp[p]});
//                }
//                if(num[w] > num[p]){
//                    if(dp[w]>= dp[p] + 1){
//                        continue;
//                    }
//                    //dp[w] = dp[p] + 1;
//                    dq.add(new int[]{w, dp[p] + 1});
//                }
//
//            }
//        }
//        out.println(dp[n-1]);
//
//    }

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
