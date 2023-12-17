package com.example.demo.codeforces.CF322;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class C {
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

        int x = sc.ni(), y = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int n = cs.length;
        int a = 0, b = 0;
        if(a==x && b==y){
            out.println("Yes");
            return;
        }
        for (int i = 0; i < n; i++) {
            if(cs[i] == 'R'){
                a++;
            }
            if(cs[i]=='U'){
                b++;
            }
            if(cs[i] == 'D'){
                b--;
            }
            if(cs[i] == 'L'){
                a--;
            }
            if(a==x && b==y){
                out.println("Yes");
                return;
            }
        }

        if(a == 0 && b==0){
            out.println("No");
            return;
        }

        int sa = 0, sb = 0;

        for (int i = 0; i < n; i++) {
            if(cs[i] == 'R'){
                sa++;
            }
            if(cs[i]=='U'){
                sb++;
            }
            if(cs[i] == 'D'){
                sb--;
            }
            if(cs[i] == 'L'){
                sa--;
            }
            if(a==0){
                if(sa==x && (y-sb)%b==0 && (y-sb)/b>=0){
                    out.println("Yes");
                    return;
                }
            }else if(b==0) {
                if(sb ==y && (x-sa)%a==0 && (x-sa)/a>=0){
                    out.println("Yes");
                    return;
                }

            }else {
                if((y-sb)%b==0 && (y-sb)/b>=0 && (x-sa)%a==0 && (x-sa)/a== (y-sb)/b){
                    out.println("Yes");
                    return;
                }
            }

        }
        out.println("No");

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
