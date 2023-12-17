package com.example.demo.codeforces.CF219;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * 换根DP
 * */
public class D {
    static List[] arr;
    static int cnt0;
    static Set<Long> set;
    static int ans;
    static int[] cnt;
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = sc.ni();
        arr = new List[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = new ArrayList<>();
        }
        set = new HashSet<>();
        cnt = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            int x = sc.ni(), y = sc.ni();
            arr[x].add(y);
            arr[y].add(x);
            set.add(((long)x <<20 ) + y);
        }
        dfs1(1, -1);
        ans = cnt0;
        cnt[1] = ans;
        dfs2(1, -1, cnt0);
        out.println(n-1-ans);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if(cnt[i]==ans){
                sb.append(i).append(" ");
            }
        }
        out.println(sb);
        out.close();

    }

    private static void dfs1(int x, int p){
        List<Integer> list = arr[x];
        for(int y : list){
            if(y==p){
                continue;
            }
            long next = ((long)x <<20 ) + y;
            if(set.contains(next)){
                cnt0++;
            }
            dfs1(y,x);
        }
    }

    private static void dfs2(int x, int p, int a){
        List<Integer> list = arr[x];
        for(int y : list){
            if(y==p){
                continue;
            }
            long next = ((long)x <<20 ) + y;
            int tem = a;
            if(set.contains(next)){
                tem--;
            }else {
                tem++;
            }

            if(tem>ans){
                ans = tem;
            }
            cnt[y] = tem;
            dfs2(y,x, tem);
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
