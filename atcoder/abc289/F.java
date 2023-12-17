package com.example.demo.atcoder.abc289;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class F {
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            long sx = sc.ni();
            long sy = sc.ni();
            long tx = sc.ni();
            long ty = sc.ni();

            long a = sc.ni();
            long b = sc.ni();
            long c = sc.ni();
            long d = sc.ni();

            List<String> last = new ArrayList<>();
            if(a==b && sx!=tx ){
                last.add(a + " " + c);
                tx = 2*a-tx;
                ty = 2*c-ty;
            }
            if(c==d && sy!=ty) {
                last.add(a + " " + c);
                tx = 2*a-tx;
                ty = 2*c-ty;
            }
            long absX = tx-sx;
            long absY = ty-sy;
            List<String> str = new ArrayList<>();
            long disX = absX>0?2:-2;
            while (sx!=tx){
                if(a==b || absX%2!=0) {
                    out.println("No");
                    return;
                }
                if(disX>0){
                    str.add(a+" "+c);
                    str.add((a+1) + " " + c);
                }else {
                    str.add((a+1) + " " + c);
                    str.add(a+" "+c);

                }

                sx += disX;
            }

            long disY = absY>0?2:-2;
            while (sy!=ty){
                if(c==d || absY%2!=0){
                    out.println("No");
                    return;
                }
                if(disY>0){
                    str.add(a+" "+c);
                    str.add(a + " " + (c+1));
                }else {
                    str.add(a + " " + (c+1));
                    str.add(a+" "+c);

                }

                sy += disY;
            }
            out.println("Yes");
            for(String s: str){
                out.println(s);
            }
            for(String s: last){
                out.println(s);
            }
        }finally {
            out.close();
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
