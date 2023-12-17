package com.example.demo.codeforces.CF1284;

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

    public static void solve() {
        int n = sc.ni();
        int[][] g = sc.nmi(n, 4);
        if(!ifP(g)){
            out.println("NO");
            return;
        }
        for (int i = 0; i < n; i++) {
            int a = g[i][0];
            int b = g[i][1];
            g[i][0] = g[i][2];
            g[i][1] = g[i][3];
            g[i][2] = a;
            g[i][3] = b;
        }
        if(!ifP(g)){
            out.println("NO");
            return;
        }
        out.println("YES");


    }

    private static boolean ifP(int[][] g){
        List<int[]> list = new ArrayList<>();
        for(int[] w: g){
            list.add(new int[]{w[0], w[2], w[3]+1, 1});
            list.add(new int[]{w[1]+1, w[2], w[3]+1, -1});
        }
        list.sort((a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            if(a[3] == b[3]){
                return 0;
            }
            return a[3];
        });
        TreeMap<Integer,Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        for(int[] w: list){
            if(w[3] == 1){
                map1.merge(w[1], 1, Integer::sum);
                map2.merge(w[2], 1, Integer::sum);
            }else {
                move(map1, w[1]);
                move(map2, w[2]);
            }
            if(map1.size()>0){
                int l = map1.lastKey();
                int f = map2.firstKey();
                if(l>=f){
                    return false;
                }
            }
        }
        return true;
    }

    private static void move(TreeMap<Integer, Integer> map, int s){
        int c = map.getOrDefault(s, 0);
        if(c == 1){
            map.remove(s);
        }else {
            map.put(s, c-1);
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
