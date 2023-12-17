package com.example.demo.aoc2023;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class D10 {
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
        boolean[][] vis = new boolean[n][m];
        int sx = 0, sy = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(cs[i][j] == 'S'){
                    sx = i;
                    sy = j;
                    vis[i][j] = true;
                    break;
                }
            }
        }


        Map<Character, Map<String,int[]>> map = new HashMap<>();
        Map<String, int[]> a = new HashMap<>();
        a.put(arrString(new int[]{1,0}), new int[]{1,0});
        a.put(arrString(new int[]{-1,0}), new int[]{-1,0});
        map.put('|', a);

        Map<String, int[]> b = new HashMap<>();
        b.put(arrString(new int[]{0,1}), new int[]{0,1});
        b.put(arrString(new int[]{0,-1}), new int[]{0,-1});
        map.put('-', b);

        Map<String, int[]> c = new HashMap<>();
        c.put(arrString(new int[]{1,0}), new int[]{0,1});
        c.put(arrString(new int[]{0,-1}), new int[]{-1,0});
        map.put('L', c);

        Map<String, int[]> d = new HashMap<>();
        d.put(arrString(new int[]{1,0}), new int[]{0,-1});
        d.put(arrString(new int[]{0,1}), new int[]{-1,0});
        map.put('J', d);

        Map<String, int[]> e = new HashMap<>();
        e.put(arrString(new int[]{0,1}), new int[]{1,0});
        e.put(arrString(new int[]{-1,0}), new int[]{0,-1});
        map.put('7', e);

        Map<String, int[]> f = new HashMap<>();
        f.put(arrString(new int[]{0,-1}), new int[]{1,0});
        f.put(arrString(new int[]{-1,0}), new int[]{0,1});
        map.put('F', f);

        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[][]> dq = new ArrayDeque<>();

        for(int[] dir:dirs){
            int x = sx + dir[0];
            int y = sy + dir[1];
            if(x<0 || x>=n || y<0 || y>=m){
                continue;
            }
            if(cs[x][y] == '.'){
                continue;
            }

//            if((dir[0] == 0 && dir[1]==-1) || (dir[0]==1 && dir[1] == 0)){
//                vis[x][y] = true;
//
//                dq.add(new Pair<>(dir, new int[]{x,y}));
//            }



            if((dir[0] == 0 && dir[1]==-1) || (dir[0]==-1 && dir[1] == 0)){
                vis[x][y] = true;

                dq.add( new int[][]{dir,new int[]{x,y} });
            }



//            if((dir[0] == 0 && dir[1]==-1) || (dir[0]==-1 && dir[1] == 0)){
//                continue;
//            }
//            vis[x][y] = true;
//
//            dq.add(new Pair<>(dir, new int[]{x,y}));

        }
        cs[sx][sy] = 'J';

        int ans = 0;
        int[][] cnt = new int[n][m];
        while (dq.size()>0){
            int size = dq.size();
            ans++;
            while (size-->0){
                int[][] p = dq.poll();
                int[] key = p[0];
                int[] v = p[1];

                char ch = cs[v[0]][v[1]];
                //out.println(v[0] + " " + v[1]  + " " + ans);
                Map<String,int[]> map1 = map.get(ch);
                int[] nd = map1.getOrDefault(arrString(key), null);
                if(nd == null){
                    continue;
                }
                int x = v[0] + nd[0];
                int y = v[1] + nd[1];
                if(x<0 || x>=n || y<0 || y>=m){
                    continue;
                }
                if(cs[x][y] == '.'){
                    continue;
                }
                if(vis[x][y]){
                    continue;
                }
                vis[x][y] = true;

                dq.add(new int[][]{nd, new int[]{x,y} });
            }

        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    int cur = 0;
                    for (int k = i; k >= 0; k--) {
                        if (vis[k][j]) {
                            if (cs[k][j] == '-' || cs[k][j] == '7' || cs[k][j] == 'J') {
                                cur += 1;
                            }
                        }
                    }
                    if(cur%2==1){
                        sum += cur % 2;
                        out.println(i+  " " + j + " " + cur );
                    }

                }
            }
        }
        out.println(sum);

//        for(int[] ss: cnt){
//            StringBuilder sb = new StringBuilder();
//            for(int s:ss){
//                sb.append(s).append(" ");
//            }
//            out.println(sb);
//        }
        out.println(ans);

    }

    private static String arrString(int[] arr){
        return arr[0] + " " + arr[1];
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
