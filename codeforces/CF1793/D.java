package com.example.demo.codeforces.CF1793;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class D {
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.ni();
        int[] p = sc.na(n);
        int[] q = sc.na(n);
        Map<Integer, Integer> mapP = new HashMap<>();
        Map<Integer, Integer> mapQ = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mapP.put(p[i],i);
            mapQ.put(q[i],i);
        }
        long ans = 1;
        int st = 1;
        long left = -1, right =-1;
        while (st<=n){

            long loc1 = mapP.get(st);
            long loc2 = mapQ.get(st);

            if(st==1){
                left = Math.min(loc1,loc2);
                right = Math.max(loc1, loc2);
                long dis1 = left;
                long dis2 = n-1-right;
                long dis3 = right-left-1;
                ans+= (dis1+1)*dis1/2 + dis2*(dis2+1)/2;
                ans +=(dis3+1)*dis3/2;


            }else{
                long min = Math.min(loc1,loc2);
                long max = Math.max(loc1, loc2);
                if ((min < left || min > right) && (max < left || max > right)) {
                    long a = 0;
                    long b = 0;

                    if (max < left) {
                        a = left - max - 1;
                        b = n - 1 - right;

                    } else if (min > right) {
                        a = min - right - 1;
                        b = left;
                    } else {
                        a = max - right - 1;
                        b = left - min - 1;
                    }


                    ans += 1 + a + b + a * b;
                }
                left = Math.min(min, left);
                right = Math.max(right, max);

            }
            st++;
        }
        out.println(ans);
        out.close();

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
