package com.example.demo.codeforces.CF1805;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = 1;
        while (t-->0){
            solve();
        }
        out.close();
    }

    static List[] arr;
    static int[] ans;
    static  int[] dist;
    static int n;
    public static void solve(){
         n = sc.ni();
        arr = new ArrayList[n+1];
        for (int i = 1; i <=n; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.ni(), b = sc.ni();
            arr[a].add(b);
            arr[b].add(a);
        }
        ans = new int[n+1];
        dist = new int[n+1];
        dfs(1,-1);
        dfs2(1, -1);

        for (int i = 1; i <=n; i++) {
            dist[i] = Math.max(dist[i],ans[i] )-1;
        }
        Arrays.sort(dist);
        int  loc = n;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >=1 ; i--) {

            while (dist[loc]>=i){
                loc--;
            }
            list.add(loc==n?n:loc+1);

        }
        for (int i = list.size()-1; i >=0 ; i--) {
            sb.append(list.get(i)).append(" ");
        }

        out.println(sb);


    }
    static private void  dfs(int cur, int p){
        List<Integer> list = arr[cur];
        for(int u: list){
            if(u == p){
                continue;
            }
            dfs(u, cur);

            // Calculate height of nodes
            ans[cur] = Math.max(ans[cur],
                    ans[u]);

        }
        ans[cur] +=1;
    }
    static private void dfs2(int c, int p){
        int max1 = 0;
        int max2 = 0;
        List<Integer> list = arr[c];

        for(int t: list){
            if(t != p){
                if(ans[t]>=max1){
                    max2 = max1;
                    max1 = ans[t];
                }else if(ans[t]>max2){
                    max2 = ans[t];
                }
            }
        }
        int sum = 0;
        for(int u: list){
            if(u != p){
            {

                // Calculate the maximum distance
                // with ancestor for every node
                sum = ((max1 == ans[u]) ?
                        max2 : max1);

                if (max1 == ans[u])
                    dist[u] = 1 + Math.max(1 + max2,
                            dist[c]);
                else
                    dist[u] = 1 + Math.max(1 + max1,
                            dist[c]);

                // Calculating for children
                dfs2(u, c);
            }
        }
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
