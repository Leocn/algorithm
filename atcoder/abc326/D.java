package com.example.demo.atcoder.abc326;

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
    static String aStr;
    static String bStr;
    public static void solve() {
        int n = sc.ni();
        aStr = sc.ns();
        bStr = sc.ns();
        char[][] g = new char[n][n];
        char[] a = aStr.toCharArray();
        char[] b = bStr.toCharArray();
        for(char[] f:g){
            Arrays.fill(f, '.');
        }

        int[] cnt = new int[3];
        Arrays.fill(cnt, n);
        if(!dfs(cnt, g, 0)){
            out.println("No");
        }


    }


    private static boolean dfs(int[] cnt, char[][] g, int loc){
        int n = g.length;
        if(n*n - loc<cnt[0]+cnt[1]+cnt[2]){
            return false;
        }
        if(loc == n*n){
            if(cnt[0]== 0 && cnt[1] == 0 && cnt[2] == 0){
                if(checkTop(g)){
                    out.println("Yes");
                    for (int i = 0; i < n; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < n; j++) {
                            sb.append(g[i][j]);
                        }
                        out.println(sb);
                    }
                    return true;

                }
            }
            return false;
        }
        int h = loc/n, w = loc%n;
        for (int i = 0; i < 3; i++) {
            if(cnt[i]==0) continue;
            char c = (char) (i+'A');
            if(check(c, g, n, h, w)){
                g[h][w] = c;
                cnt[i]--;
                if(dfs(cnt, g, loc+1)){
                    return true;
                }
                g[h][w] = '.';
                cnt[i]++;
            }
        }
        return dfs(cnt, g, loc+1);
    }
    public static boolean check(char c, char[][] g, int n, int i, int j){
        for (int k = 0; k < n; k++) {
            if(g[i][k]== c){
                return false;
            }
        }
        for (int k = 0; k < n; k++) {
            if(g[k][j]==c){
                return false;
            }
        }
        return true;
    }

    public static boolean checkTop(char[][] g){
        StringBuilder a = new StringBuilder();
        out:for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if(g[i][j]!='.'){
                    a.append(g[i][j]);
                    continue out;
                }
            }
        }
        StringBuilder b = new StringBuilder();
        out:for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g.length; j++) {
                if(g[j][i] != '.'){
                    b.append(g[j][i]);
                    continue out;
                }
            }
        }
        return aStr.equals(a.toString()) && bStr.equals(b.toString());
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
