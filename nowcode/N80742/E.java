package com.example.demo.nowcode.N80742;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

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

    static int[] ans;
    static List<Integer>[] g;
    static char[] cs;
    static int l;
    static int r;
    static int res;
    public static void solve() {
        int n = sc.ni();
        l = sc.ni();
        r = sc.ni();
        cs = sc.ns().toCharArray();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        ans = new int[n];
        for (int i = 0; i < n-1; i++) {
            int a = sc.ni() - 1;
            int b = sc.ni() - 1;
            g[a].add(b);
            g[b].add(a);
        }
        if(Math.abs(l)>=Math.abs(r)){
            res = l;
        }else {
            res = r;
        }
        dfs(0,-1);
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " " );
        }
    }
    public static List<Integer> dfs(int c, int p){
        List<Integer> list = new ArrayList<>();
        list.add(c);
        for(int w: g[c]){
            if(w == p){
                continue;
            }
            list.addAll(dfs(w, c));
        }
        if(cs[c]=='R'){
            int p1 = -1, p2 = -1;
            long sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if(sum>0){
                    sum += l;
                    ans[list.get(i)] = l;
                    p1 = list.get(i);
                }else {
                    sum += r;
                    ans[list.get(i)] = r;
                    p2 = list.get(i);
                }
            }
            if(sum>0){
                ans[p2] -= sum;
            }else if(sum<0){
                ans[p1] -= sum;
            }
            list = new ArrayList<>();

        }else if(c==0){
            int s = list.size();
            int res = 0;

            for (int i = 0; i < s; i++) {
                ans[list.get(i)] = res;
            }
        }
        return list;

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

