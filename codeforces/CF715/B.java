package com.example.demo.codeforces.CF715;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class B {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {

        solve();

        out.close();
    }
    public static void solve(){
        int n = sc.ni(), m = sc.ni();
        long target = sc.nl();
        int source = sc.ni(), destination = sc.ni();
        ArrayList<Integer>[] arr = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        long[][] cnt = new long[n][n];
        long[][] edges = new long[m][3];
        for (int i = 0; i < m; i++) {
            edges[i] = new long[]{sc.ni(), sc.ni(), sc.ni() };
        }

        for (int i = 0; i < edges.length; i++) {
            long[] e = edges[i];
            if(e[2] == 0){
                cnt[(int)e[0]][(int)e[1]] = 1;
                cnt[(int)e[1]][(int)e[0]] = 1;
                map.put(e[0] +" " +e[1], i);
                map.put(e[1] +" " +e[0], i);
                edges[i][2] = 1;
            }else {
                cnt[(int)e[0]][(int)e[1]] = e[2];
                cnt[(int)e[1]][(int)e[0]] = e[2];
            }

            arr[(int)e[0]].add((int)e[1]);
            arr[(int)e[1]].add((int)e[0]);

        }

        long[] vis  = new long[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        vis[source] = 0;
        PriorityQueue<Integer> dq = new PriorityQueue<>((a,b)->Long.compare(vis[a],vis[b]));
        dq.add(source);
        while (dq.size()>0){
            int p = dq.poll();
            for(int t: arr[p]){
                if(vis[t]> vis[p] + cnt[p][t]){
                    vis[t] = vis[p] + cnt[p][t];
                    dq.add(t);
                }
            }
        }
        if(vis[destination]>target ){
            out.println("NO");
            return;
        }

        long[] dis  = new long[n];
        PriorityQueue<long[]> pq= new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        pq.add(new long[]{0, source});

        while (pq.size()>0){
            long[] a = pq.poll();
            long v = a[0];
            int p= (int)a[1];
            for(int t: arr[p]){
                String str = p+ " " + t;
                if(map.containsKey(str )){
                    long z = target - vis[destination] - dis[p] + vis[t];
                    if(edges[map.get(str)][2]<z){
                        edges[map.get(str)][2]=z;
                        cnt[p][t] = z;
                        cnt[t][p] = z;
                    }
                    map.remove(str);
                    map.remove(t+ " " + p);

                }

                if(dis[t]> v + cnt[p][t]){
                    dis[t] = v + cnt[p][t];
                    pq.add(new long[]{dis[t], t});
                }
            }
        }

        if(dis[destination]!= target){

            out.println("NO");
            return;
        }
        out.println("YES");
        for(long[] e:edges){
            out.println(e[0] + " " + e[1] + " " + e[2]);
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
