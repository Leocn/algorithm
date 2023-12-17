package com.example.demo.codeforces.CF1810;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class D {
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
        int q = sc.ni();
        long hMin = 0 , hMax = Long.MAX_VALUE;
        List<Long> list = new ArrayList<>();
        while (q-->0){
            int type = sc.ni();

            if(type==1){
                long a = sc.ni(), b = sc.ni(), n = sc.ni();
                long min = 0, max = 0;
                if(n==1){
                    min = 1;
                    max = a;
                }else {
                    min = (n-2)*(a-b) + a +1;
                    max = (n-1)*(a-b) + a;
                }
                if(max<hMin || min >hMax){
                    list.add(0L);
                }else {
                    hMax = Math.min(max, hMax);
                    hMin = Math.max(min, hMin);
                    list.add(1L);
                }


            }else {
                long a = sc.ni(), b = sc.ni();
                long min = 0, max = 0;

                if(hMin<=a){
                    min = 1;
                }else {
                    long d = (hMin-a)/(a-b);
                    d++;
                    if((hMin-a)%(a-b)!=0){
                        d++;
                    }
                    min+=d;
                }
                if(hMax<=a){
                    max = 1;
                }else {
                    long d = (hMax-a)/(a-b);
                    d++;
                    if((hMax-a)%(a-b)!=0){
                        d++;
                    }
                    max+=d;
                }
                if(max==min){
                    list.add(max);
                }else {
                    list.add(-1L);
                }



            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }
        out.println(sb);
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
