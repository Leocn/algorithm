package com.example.demo.aoc2023;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D11 {
    static Scanner sc = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    public static void solve() {
        long ans = 0;
        List<String> list = new ArrayList<>();
        while (sc.hasNextLine()){

            String s = sc.nextLine();
            if(s.equals("ex")){
                break;
            }
            list.add(s);
        }
        int n = list.size(), m = list.get(0).length();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = list.get(i).toCharArray();
        }
        List<Integer> rows = new ArrayList<>();

        out:for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cs[i][j] !='.'){
                    continue out;
                }
            }
            rows.add(i);
        }
        List<Integer> cols = new ArrayList<>();
        out:for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(cs[j][i] !='.'){
                    continue out;
                }

            }
            cols.add(i);
        }



        List<Integer> resRows = new ArrayList<>();
        List<Integer> resCols = new ArrayList<>();

        long pre = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(cs[i][j] == '#'){
//                    for (int k = 0; k < resRows.size(); k++) {
//                        int sum =   i - resRows.get(k);
//                        for (int l = resRows.get(k); l <=i ; l++) {
//                            if(rows.contains(l)){
//                                sum++;
//                            }
//                        }

//                    }

                    ans += (long) resRows.size() * i - pre;
                    pre += i;
                    resRows.add(i);
                }
            }
        }

        pre = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(cs[j][i] == '#'){
//                    for (int k = 0; k < resCols.size(); k++) {
//                        int sum = i - resCols.get(k);
//                        for (int l = resCols.get(k); l <=i; l++) {
//                            if(cols.contains(l)){
//                                sum++;
//                            }
//                        }
//                        ans+= sum;
//                    }
                    ans += (long) resCols.size() * i - pre;
                    pre += i;
                    resCols.add(i);
                }

            }
        }
        int loc = 0;
        for (int i = 0; i < rows.size(); i++) {
            while (loc < resRows.size() && resRows.get(loc)<rows.get(i)){
                loc++;
            }
            ans += (long) loc *(resRows.size()-loc)*999999;
        }
        loc = 0;
        for (int i = 0; i < cols.size(); i++) {
            while (loc < resCols.size() && resCols.get(loc)<cols.get(i)){
                loc++;
            }
            ans += (long) loc *(resCols.size()-loc)*999999;
        }
        out.println(ans);

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
