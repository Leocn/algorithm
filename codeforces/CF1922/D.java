package com.example.demo.codeforces.CF1922;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    /**
     * 哈希，模拟
     */
    public static void solve() {
        int n = sc.ni();
        int[] a = sc.na(n);
        int[] d = sc.na(n);
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i-1;
        }
        for (int i = 0; i < n; i++) {
            right[i] = i+1;
        }
        int loc = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int res = cal(a,d,i,left,right);
            if(res<0){
                list.add(new int[]{i, res});
            }
        }

        while (true){
            int res = 0;
            Set<Integer> set = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            for(int[] poll: list){
                int p = poll[0];
                int l = left[p];
                int r = right[p];
                if(l>=0){
                    right[l] = r;
                    set.add(l);
                }
                if(r<n){
                    left[r] = l;
                    set.add(r);
                }
                s2.add(p);
                res++;
            }
            ans[loc++] = res;
            set.removeAll(s2);
            if(set.size()==0) break;
            list = new ArrayList<>();
            for(int s: set){
                int r = cal(a,d,s,left,right);
                if(r<0){
                    list.add(new int[]{s, r});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        out.println(sb);
    }

    private static  int cal(int[]a, int[] b, int w, int[] left, int[] right){
        int s = 0;
        if(left[w]!=-1){
            s += a[left[w]];
        }
        if(right[w]!=a.length){
            s += a[right[w]];
        }
        return b[w]- s;
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
