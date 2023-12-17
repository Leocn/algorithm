package com.example.demo.codeforces.CF1833;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

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
    public static void solve(){
        int ans = 0;
        int n = sc.ni();
        int[] arr = sc.na(n);
        ArrayList[] g = new ArrayList[n+1];
        for (int i = 1; i <=n ; i++) {
            g[i]= new ArrayList<>();
        }
        for (int i = 1; i <=n ; i++) {
            g[arr[i-1]].add(i);
        }
        int type1 = 0, type2= 0;
        boolean[] vis = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            if(vis[i+1]){
                continue;
            }
            if(g[i+1].size()==2){
                vis[i+1] = true;

                Deque<Integer> dq = new ArrayDeque<>();
                dq.add(i+1);
                while (dq.size()>0){
                    int p = dq.poll();
                    List<Integer> list = g[p];
                    for(int next :list){
                        if(vis[next]){
                            continue;
                        }
                        dq.add(next);
                        vis[next] = true;
                    }
                }
                type2++;

            }



        }
        for (int i = 0; i < n; i++) {
            if(vis[i+1]){
                continue;
            }
            int tar = i+1;
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            while (!vis[tar]){
                vis[tar] = true;
                tar = arr[tar-1];
                set.add(tar);
                cnt ++;
            }
            if(cnt==2){
                type2++;
            }else {
                if(cnt == set.size()){
                    type1 ++;
                }else {
                    type2++;
                }
            }
        }

        out.println((type1+Math.min(type2,1)) + " " + (type1+type2) );

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
