package com.example.demo.atcoder.abc341;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class E {
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
        int n = sc.ni();
        int q = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int[] g = new int[n];
        for (int i = 0; i < n; i++) {
            if((i%2==0 &&cs[i]=='1') || (i%2==1 && cs[i]=='0')){
                g[i] = 1;
            }
        }
        SegmentTree tree = new SegmentTree(g);
        for (int i = 0; i < q; i++) {
            int type = sc.ni();
            int a = sc.ni()-1, b = sc.ni()-1;
            if(type==1){
                tree.updateRange(a,b);
            }else {
                int res = tree.queryRange(a,b);
                if(res==0 || res == b-a+1){
                    out.println("Yes");
                }else {
                    out.println("No");
                }
            }
        }
    }
    public static class SegmentTree {
        private int[] tree;
        private boolean[] lazy; // 用于标记该区间是否需要翻转
        private int n;

        public SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            lazy = new boolean[4 * n];
            build(arr, 0, n - 1, 0);
        }

        private void build(int[] arr, int start, int end, int treeIndex) {
            if (start == end) {
                tree[treeIndex] = arr[start];
                return;
            }
            int mid = start + (end - start) / 2;
            build(arr, start, mid, 2 * treeIndex + 1);
            build(arr, mid + 1, end, 2 * treeIndex + 2);
            tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
        }

        public void updateRange(int l, int r) {
            updateRange(0, n - 1, l, r, 0);
        }

        private void updateRange(int start, int end, int l, int r, int treeIndex) {
            if (lazy[treeIndex]) {
                tree[treeIndex] = (end - start + 1) - tree[treeIndex]; // 翻转操作
                if (start != end) { // 非叶子节点
                    lazy[2 * treeIndex + 1] = !lazy[2 * treeIndex + 1];
                    lazy[2 * treeIndex + 2] = !lazy[2 * treeIndex + 2];
                }
                lazy[treeIndex] = false;
            }
            if (start > end || start > r || end < l) {
                return;
            }
            if (start >= l && end <= r) {
                tree[treeIndex] = (end - start + 1) - tree[treeIndex];
                if (start != end) {
                    lazy[2 * treeIndex + 1] = !lazy[2 * treeIndex + 1];
                    lazy[2 * treeIndex + 2] = !lazy[2 * treeIndex + 2];
                }
                return;
            }
            int mid = start + (end - start) / 2;
            updateRange(start, mid, l, r, 2 * treeIndex + 1);
            updateRange(mid + 1, end, l, r, 2 * treeIndex + 2);
            tree[treeIndex] = tree[2 * treeIndex + 1] + tree[2 * treeIndex + 2];
        }

        public int queryRange(int l, int r) {
            return queryRange(0, n - 1, l, r, 0);
        }

        private int queryRange(int start, int end, int l, int r, int treeIndex) {
            if (start > end || start > r || end < l) {
                return 0;
            }
            if (lazy[treeIndex]) {
                tree[treeIndex] = (end - start + 1) - tree[treeIndex];
                if (start != end) {
                    lazy[2 * treeIndex + 1] = !lazy[2 * treeIndex + 1];
                    lazy[2 * treeIndex + 2] = !lazy[2 * treeIndex + 2];
                }
                lazy[treeIndex] = false;
            }
            if (start >= l && end <= r) {
                return tree[treeIndex];
            }
            int mid = start + (end - start) / 2;
            return queryRange(start, mid, l, r, 2 * treeIndex + 1) + queryRange(mid + 1, end, l, r, 2 * treeIndex + 2);
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
