package com.example.demo.codeforces.CF936;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class B {
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
        int n = sc.ni(), m = sc.ni();
        ArrayList<Integer>[] g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            int c = sc.ni();
            for (int j = 0; j < c; j++) {
                g[i].add(sc.ni());
            }
        }
        int s = sc.ni();
        int[][] path = new int[n+1][2];
        boolean[][] vis = new boolean[n+1][2];
        dfs(path, vis, g, s, 0);
        for (int i = 1; i <=n; i++) {
            if(vis[i][1] && g[i].size()==0){
                out.println("Win");
                printPath(i,path,1);
                return;
            }
        }
        if(cycle(s, g, new int[n+1])){
            out.println("Draw");
        }else {
            out.println("Lose");
        }
    }


    public static boolean cycle(int cur, ArrayList<Integer>[] g, int[] vis) {
        vis[cur]++;
        for (int w : g[cur]) {
            if (vis[w]==0) {
                if (cycle(w, g, vis)) {
                    return true;
                }
            } else if (vis[w]>=1) {
                return true;
            }
        }
        vis[cur]--;
        return false;
    }

    private static void dfs(int[][] path, boolean[][] vis, ArrayList<Integer>[] g, int cur, int mask){
        vis[cur][mask] = true;
        for(int w: g[cur]){
            if(!vis[w][1-mask]){
                path[w][1-mask] = cur;
                dfs(path, vis, g, w, 1-mask);
            }
        }
    }

    private static void printPath(int cur, int[][] path, int mask){
        int res = path[cur][mask];
        if(res!=0){
            printPath(res, path, 1-mask);
        }
        out.println(cur);
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



//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Stack;
//import java.util.StringTokenizer;
//
//public class B {
//
//    public static void main(String[] args) throws IOException {
//        PrintWriter pw = new PrintWriter(System.out);
//        new B().solve(pw);
//        pw.flush();
//        pw.close();
//    }
//
//    public void solve(PrintWriter pw) throws IOException {
//        FastReader sc = new FastReader();
//        int n = sc.nextInt(), m = sc.nextInt();
//        ArrayList<Integer>[] adj = new ArrayList[n + 1];
//        for (int i = 1; i <= n; i++) {
//            adj[i] = new ArrayList();
//        }
//        for (int i = 1; i <= n; i++) {
//            int c = sc.nextInt();
//            for (int j = 0; j < c; j++) {
//                adj[i].add(sc.nextInt());
//            }
//        }
//        int s = sc.nextInt();
//        int[][] path = new int[n + 1][2];
//        boolean[][] vis = new boolean[n + 1][2];
//        dfs(s, adj, path, vis, 0);
//        for (int i = 1; i <= n; i++) {
//            if (adj[i].isEmpty() && vis[i][1]) {
//                pw.println("Win");
//                path(i, 1, path, pw);
//                pw.println();
//                return;
//            }
//        }
//        if (dfsCycle(s, adj, new boolean[n + 1], new Stack())) {
//            pw.println("Draw");
//        } else {
//            pw.println("Lose");
//        }
//    }
//
//    public boolean dfsCycle(int u, ArrayList<Integer>[] adj, boolean[] vis, Stack<Integer> st) {
//        vis[u] = true;
//        st.push(u);
//        for (Integer v : adj[u]) {
//            if (!vis[v]) {
//                if (dfsCycle(v, adj, vis, st)) {
//                    return true;
//                }
//            } else if (st.contains(v)) {
//                return true;
//            }
//        }
//        st.pop();
//        return false;
//    }
//
//    public void path(int u, int parity, int[][] path, PrintWriter pw) {
//        if (path[u][parity] == 0) {
//            pw.print(u);
//            return;
//        }
//        path(path[u][parity], 1 - parity, path, pw);
//        pw.print(" " + u);
//    }
//
//    public void dfs(int u, ArrayList<Integer>[] adj, int[][] path, boolean[][] vis, int parity) {
//        vis[u][parity] = true;
//        for (Integer v : adj[u]) {
//            if (!vis[v][1 - parity]) {
//                path[v][1 - parity] = u;
//                dfs(v, adj, path, vis, 1 - parity);
//            }
//        }
//    }
//
//    static class FastReader {
//
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader() {
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        public FastReader(String s) {
//            try {
//                br = new BufferedReader(new FileReader(s));
//            } catch (FileNotFoundException e) {
//            }
//        }
//
//        public String next() {
//            if (st == null || !st.hasMoreTokens()) {
//                try {
//                    st = new StringTokenizer(br.readLine());
//                } catch (Exception e) {
//                }
//            }
//            return st.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public String nextLine() {
//            try {
//                return br.readLine();
//            } catch (Exception e) {
//            }
//            return null;
//        }
//
//        public boolean hasNext() throws IOException {
//            if (st != null && st.hasMoreTokens()) {
//                return true;
//            }
//            String s = br.readLine();
//            if (s == null || s.isEmpty()) {
//                return false;
//            }
//            st = new StringTokenizer(s);
//            return true;
//        }
//    }
//}