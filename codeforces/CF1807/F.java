package com.example.demo.codeforces.CF1807;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class F {

    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        int t = sc.ni();
        out :while (t-->0){
            int m = sc.ni(), n = sc.ni();
            int fy = sc.ni(), fx = sc.ni();
            int ty = sc.ni(), tx = sc.ni();
            String str = sc.ns();
            int[] dir = new int[2];
            if(str.equals("DL")){
                dir = new int[]{-1,1};
            }else if(str.equals("DR")){
                dir = new int[]{1,1};
            }else if(str.equals("UR")){
                dir  = new int[]{1, -1};
            }else {
                dir = new int[]{-1,-1};
            }
            int ans = 0;
            int[][] visCnt = new int[n+1][m+1];
            int nextX = 0, nextY= 0;
            while (true){
                if (fx == tx && fy == ty) {
                    System.out.println(ans);
                    continue out;
                }

                visCnt[fx][fy]++;

                if (visCnt[fx][fy] > 4) {
                    break;
                }

                nextX = fx + dir[0];
                nextY = fy + dir[1];

                boolean bn = false;

                if (nextX < 1 || nextX > n) {
                    dir[0] *= -1;
                    bn = true;
                }

                if (nextY < 1 || nextY > m) {
                    dir[1] *= -1;
                    bn = true;
                }

                if (bn) {
                    ans++;
                    nextX = fx + dir[0];
                    nextY = fy + dir[1];
                }

                fx = nextX;
                fy = nextY;
            }
            System.out.println(-1);

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
