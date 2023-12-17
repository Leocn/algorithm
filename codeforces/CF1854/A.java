package com.example.demo.codeforces.CF1854;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class A {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void solve() {
        int n = sc.ni();
        int[] arr = sc.na(n);
        int max = -30, min = 30;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if(n==1 || (max==0 && min==0)){
            out.println(0);
        }else if(max<=0){
            out.println(n-1);
            ne(n);
        }else if(min>=0){
            out.println(n-1);
            po(n);
        }else {
            int cnt1 = 0, cnt2 = 0;
            int loc1 = 0, loc2 = 0;
            for (int i = 0; i < n; i++) {
                if(arr[i]>0){
                    cnt1++;
                }
                if(arr[i]<0){
                    cnt2++;
                }
                if(arr[i] == max){
                    loc1 = i+1;
                }
                if(arr[i] == min){
                    loc2 = i+1;
                }
            }
            if(max>=-min){
                int a = cnt2;
                int b = 5 + cnt1;
                if(a<=b){
                    out.println(a + n-1);
                    for (int i = 0; i < n; i++) {
                        if(arr[i]<0){
                            out.println((i+1) + " " + loc1);
                        }
                    }
                    po(n);
                }else {
                    out.println(b + n-1);
                    for (int i = 0; i < 5; i++) {
                        out.println(loc2 + " " + loc2);
                    }
                    for (int i = 0; i < n; i++) {
                        if(arr[i]>0){
                            out.println((i+1) + " " + loc2);
                        }
                    }
                    ne(n);

                }
            }else {
                int a = 5 + cnt2;
                int b = cnt1;
                if(a<=b){
                    out.println(a + n-1);
                    for (int i = 0; i < 5; i++) {
                        out.println(loc1 + " " + loc1);
                    }
                    for (int i = 0; i < n; i++) {
                        if(arr[i]<0){
                            out.println((i+1) + " " + loc1);
                        }
                    }
                    po(n);
                }else {
                    out.println(b + n-1);
                    for (int i = 0; i < n; i++) {
                        if(arr[i]>0){
                            out.println((i+1) + " " + loc2);
                        }
                    }
                    ne(n);

                }
            }

        }
    }
    private static void ne(int n){
        for (int i = n-1; i >=1; i--) {
            out.println((i) + " " + (i+1));
        }
    }
    private static void po(int n){
        for (int i = 1; i <n ; i++) {
            out.println((i+1) + " " + (i) );
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
