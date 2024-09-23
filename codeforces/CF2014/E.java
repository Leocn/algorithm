package com.example.demo.codeforces.CF2014;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

/**
 * @Description 2014E
 * @Author Leon
 * @Date
 */
public class E {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = sc.ni();
        while (t-->0){
            solve();
        }
        out.close();
    }

    static ArrayList<int[]>[] g;
    static int n;
    static boolean[] horse;
    private static void solve() {
        n = sc.ni();
        int m = sc.ni(), h = sc.ni();
        horse = new boolean[n];
        for (int i = 0; i < h; i++) {
            int a = sc.ni() - 1;
            horse[a] = true;
        }
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.ni() - 1;
            int b = sc.ni() - 1;
            int w = sc.ni();
            g[a].add(new int[]{b, w});
            g[b].add(new int[]{a, w});
        }
        long[][] pre = minD(0);
        long[][] suf = minD(n-1);
        long ans = Long.MAX_VALUE/10;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, Math.max(Math.min(pre[i][0],pre[i][1]), Math.min(suf[i][0], suf[i][1])));
        }
        out.println(ans == Long.MAX_VALUE/10?-1: ans);
    }


    private static long[][] minD(int st){
        long[][] dis = new long[n][2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dis[i],Long.MAX_VALUE/10);
        }
        int type = 0;
        if(horse[st]){
            type = 1;
        }
        dis[st][type] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.add(new long[]{0, st, type});
        while (pq.size()>0){
            long[] p = pq.poll();
            int c = (int)p[1];
            int ty = (int)p[2];
            long d = p[0];
            if(dis[c][ty]<d){
                continue;
            }
            for(int[] w: g[c]){
                long ne = d + (ty == 1? w[1]/2: w[1]);
                if(dis[w[0]][ty]<=ne){
                    continue;
                }
                dis[w[0]][ty] = ne;
                int nextType = ty;
                if(nextType == 0 && horse[w[0]]){
                    nextType = 1;
                }
                pq.add(new long[]{dis[w[0]][ty], w[0], nextType});
            }
        }

        return dis;
    }


    public static long quickPowerMod(long a, long b, long c) {
        long result = 1;
        a = a % c; // 确保a是在模c的范围内
        while (b > 0) {
            if ((b & 1) == 1) { // 判断b的二进制表示的最后一位是不是1
                result = (result * a) % c;
            }
            b >>= 1; // 将b右移一位，相当于除以2
            a = (a * a) % c; // 将a平方，同时保持a是在模c的范围内
        }
        return result;
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