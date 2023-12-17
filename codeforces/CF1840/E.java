package com.example.demo.codeforces.CF1840;

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
        char[][] cs = new char[2][];
        cs[0] =  sc.ns().toCharArray();
        cs[1] =  sc.ns().toCharArray();
        int n = cs[0].length;

        int time = sc.ni(), q = sc.ni();
        Set<Integer> set = new HashSet<>();
        Set<Integer> block = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (int i = 0; i < n; i++) {
            if(cs[0][i]!=cs[1][i]){
                set.add(i);
            }
        }
        for (int i = 0; i < q; i++) {
            while (pq.size()>0 &&pq.peek()[1]+time<=i){
                int[] p = pq.poll();
                if(cs[0][p[0]]!=cs[1][p[0]]){
                    set.add(p[0]);
                    block.remove(p[0]);
                }
            }
            int type = sc.ni();
            if(type == 1){
                int loc = sc.ni()-1;
                set.remove(loc);
                block.add(loc);
                pq.add(new int[]{loc, i});
            }else if(type ==2 ){
                int a = sc.ni()-1;
                int x = sc.ni()-1;
                int b = sc.ni()-1;
                int y = sc.ni()-1;

                char tem = cs[a][x];
                cs[a][x] = cs[b][y];
                cs[b][y] = tem;
                if(cs[0][x]!=cs[1][x] && !block.contains(x)){
                    set.add(x);
                }else {
                    set.remove(x);
                }
                if(cs[0][y]!=cs[1][y] && !block.contains(y)){
                    set.add(y);
                }else {
                    set.remove(y);
                }


            }else {
                String ans = set.size()==0?"YES":"NO";
                out.println(ans);
            }
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
