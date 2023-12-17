package com.example.demo.codeforces.CF1873;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class H {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = sc.ni();
        while (t-->0){
            solve();
        }
        out.close();
    }

    public static void solve(){
        int n = sc.ni(),a= sc.ni(), b = sc.ni();
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 0; i <=n; i++) {
            g[i] = new ArrayList<>();
        }
        int[] cnt = new int[n+1];
        for (int i = 0; i <n ; i++) {
            int f = sc.ni(), t = sc.ni();
            g[f].add(t);
            g[t].add(f);
            cnt[f]++;
            cnt[t]++;
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if(cnt[i]==1){
                dq.add(i);
            }
        }
        while (dq.size()>0){
            int p = dq.poll();
            cnt[p] = 0;
            for(int c: g[p]){
                if(cnt[c]>0){
                    cnt[c]--;
                }
                if(cnt[c]==1){
                    dq.add(c);
                }

            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if(cnt[i]>0){
                set.add(i);
            }
        }
        if(a==b){
            out.println("NO");
            return;
        }
        if(set.contains(b)){
            out.println("YES");
            return;
        }

        dq.add(b);
        int d = 0;
        int ans = 0;
        int tar = 0;
        boolean[] vis = new boolean[n+1];
        out:while (dq.size()>0){
            int s = dq.size();
            d++;
            while (s-->0){
                int p = dq.poll();
                vis[p] = true;
                for(int c: g[p]){
                    if(vis[c]) continue;
                    if(set.contains(c)){
                        ans = d;
                        tar = c;
                        break out;
                    }else {
                        dq.add(c);
                    }
                }
            }
        }

        if(tar==a){
            out.println("NO");
            return;
        }

        dq = new ArrayDeque<>();
        dq.add(a);
        d = 0;
        vis = new boolean[n+1];
        out:while (dq.size()>0){
            int s = dq.size();
            d++;
            while (s-->0){
                int p = dq.poll();
                vis[p] = true;
                for(int c: g[p]){
                    if(vis[c]) continue;
                    if(c==tar){
                        ans -= d;
                        break out;
                    }
                    dq.add(c);
                }
            }
        }
        if(ans>=0){
            out.println("NO");
        }else {
            out.println("YES");
        }





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
