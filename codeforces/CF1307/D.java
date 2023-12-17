package com.example.demo.codeforces.CF1307;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = 1;
        while (t-->0){
            solve();
        }
        out.close();
    }
    public static void solve(){
        int n = sc.ni();
        int m = sc.ni();
        int k = sc.ni();
        int[] points = sc.na(k);
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.ni(), b = sc.ni();
            g[a].add(b);
            g[b].add(a);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        int[] fromOne = new int[n+1];
        Arrays.fill(fromOne, -1);
        fromOne[1] = 0;
        while (dq.size()>0){
            int p = dq.poll();
            for(int nx : g[p]){
                if(fromOne[nx]>=0){
                    continue;
                }
                fromOne[nx] = fromOne[p]+1;
                dq.add(nx);
            }
        }
        int[] fromN = new int[n+1];
        Arrays.fill(fromN, -1);
        fromN[n] = 0;
        dq.add(n);
        while (dq.size()>0){
            int p = dq.poll();
            for(int nx : g[p]){
                if(fromN[nx]>=0){
                    continue;
                }
                fromN[nx] = fromN[p]+1;
                dq.add(nx);
            }
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            int a = fromOne[points[i]] , b = fromN[points[i]];
            list.add(new int[]{a-b, points[i]});
        }
        list.sort((a, b) -> a[0] - b[0]);
        int best = 0, max = Integer.MIN_VALUE;
        for(int[] p: list){
            int a=p[1];
            best=Math.max(best,max+fromN[a]);
            max=Math.max(max,fromOne[a]);
        }
        int ans = Math.min(fromOne[n], best+1);
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
