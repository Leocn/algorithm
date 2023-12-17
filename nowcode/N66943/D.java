package com.example.demo.nowcode.N66943;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

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

    static ArrayList<int[]>[] g;
    static long[][] cnt;
    public static void solve() {
        int n = sc.ni();
        g = new ArrayList[n];
        for (int i = 0; i <n ; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.ni() - 1;
            int b = sc.ni() - 1;
            int w = sc.ni();
            g[a].add(new int[]{b ,w});
            g[b].add(new int[]{a, w});
        }
        cnt = new long[n][2];
        dfs(0, -1);
        out.println(Math.max(cnt[0][0], cnt[0][1]));

    }
    static private long[] dfs(int cur, int p){
        long res = 0;
        long res2 = 0;
        long sum = 0;
        for(int[] q : g[cur]){
            if(q[0] == p){
                continue;
            }
            int w = q[1];
            long[] r = dfs(q[0], cur);

            res += r[1];
            sum += r[1];
        }

        for(int[] q : g[cur]){
            if(q[0] == p){
                continue;
            }
            int w = q[1];
            res2 = Math.max(res2, sum - cnt[q[0]][1] + cnt[q[0]][0] + w);
        }
        res2 = Math.max(res, res2);
        cnt[cur] = new long[]{res, res2};
        return new long[]{res, res2};
    }
//    static private void dfs2(int cur, int p, long[] s){
//        ans = Math.max(ans, Math.max(cnt[cur][0]+s[1], cnt[cur][1]+s[0]));
//        List<long[]> list1 = new ArrayList<>();
//        List<long[]> list2 = new ArrayList<>();
//        for(int[] q : g[cur]){
//            if(q[0] == p){
//                continue;
//            }
//            int w = q[1];
//            list1.add( new long[]{cnt[q[0]][1], q[0]});
//            list2.add(new long[]{cnt[q[0]][0]+ w, q[0]});
//        }
//        Collections.sort(list1, (a,b)->Long.compare(a[0],b[0]));
//        Collections.sort(list2, (a,b)->Long.compare(a[0],b[0]));
//        for(int[] q : g[cur]){
//            if(q[0] == p){
//                continue;
//            }
//            int w = q[1];
//            long a = s[1], b = s[0];
//            if(list1.size()==1){
//
//            }else {
//                if(list2.get(list2.size()-1)[1] == q[0]){
//                    a = Math.max(a, list2.get(list2.size()-2)[0]);
//                }else {
//                    a = Math.max(a, list2.get(list2.size()-1)[0]);
//                }
//                if(list1.get(list1.size()-1)[1] == q[0]){
//                    b = Math.max(b, list1.get(list1.size()-2)[0]);
//                }else {
//                    b = Math.max(b, list1.get(list1.size()-1)[0]);
//                }
//
//
//            }
//            dfs2(q[0], cur , new long[]{a, b+w});
//        }
//
//    }

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
