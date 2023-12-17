package com.example.demo.aoc2023;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D1 {
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
        Map<String ,Integer> map = new HashMap<>();
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);

        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            String s = sc.ns();
            char[] cs = s.toCharArray();

            for (int j = 0; j < cs.length; j++) {
                boolean v = false;
                int sum = 0;
                if(Character.isDigit(cs[j])){
                    sum = cs[j] - '0';
                    v = true;
                }

                if(j+3<=cs.length){
                    String sub = s.substring(j, j+3);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }
                if(j+4<=cs.length){
                    String sub = s.substring(j, j+4);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }
                if(j+5<=cs.length){
                    String sub = s.substring(j, j+5);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }

                if(v){
                    ans += 10*sum;
                    break;
                }
            }

            for (int j = cs.length-1; j >=0 ; j--) {
                int sum = 0;
                boolean v = false;
                if(j+3<=cs.length){
                    String sub = s.substring(j, j+3);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }
                if(j+4<=cs.length){
                    String sub = s.substring(j, j+4);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }
                if(j+5<=cs.length){
                    String sub = s.substring(j, j+5);
                    if(map.containsKey(sub)){
                        sum = map.get(sub);
                        v = true;
                    }
                }

                if(Character.isDigit(cs[j])){
                    sum = cs[j] - '0';
                    v = true;
                }

                if(v){
                    ans += sum;
                    break;
                }
            }
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
