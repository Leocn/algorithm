package com.example.demo.codeforces.CF1709;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

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

    public static void solve() {
        int n = sc.ni(), m = sc.ni();
        int[] g = sc.na(m);
        int q = sc.ni();
        MinMaxSegmentTree seg = new MinMaxSegmentTree(g);
        while (q-->0){
            int fx = sc.ni(), fy = sc.ni();
            int tx = sc.ni(), ty = sc.ni();
            int k = sc.ni();
            int dy = Math.abs(fy- ty);
            int dx = Math.abs(fx- tx);
            if(dy%k!=0 || dx%k!=0){
                out.println("NO");
                continue;
            }
            int s = seg.queryMax(Math.min(fy, ty)-1, Math.max(fy, ty)-1);
            int res = fx + (n-fx)/k * k;
            if(res>s) {
                out.println("YES");
            }else {
                out.println("NO");
            }

        }
    }
    static public class MinMaxSegmentTree {

        private static class TreeNode {
            int start, end, min, max;
            TreeNode left, right;

            TreeNode(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        private TreeNode buildTree(int[] nums, int start, int end) {
            if (start > end) return null;
            TreeNode cur = new TreeNode(start, end);
            if (start == end) {
                cur.min = nums[start];
                cur.max = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                cur.left = buildTree(nums, start, mid);
                cur.right = buildTree(nums, mid + 1, end);
                cur.min = Math.min(cur.left.min, cur.right.min);
                cur.max = Math.max(cur.left.max, cur.right.max);
            }
            return cur;
        }

        private void updateTree(TreeNode node, int i, int val) {
            if (node.start == node.end) {
                node.min = val;
                node.max = val;
            } else {
                int mid = node.start + (node.end - node.start) / 2;
                if (i <= mid) updateTree(node.left, i, val);
                else updateTree(node.right, i, val);
                node.min = Math.min(node.left.min, node.right.min);
                node.max = Math.max(node.left.max, node.right.max);
            }
        }

        private int queryTree(TreeNode node, int i, int j, boolean min) {
            if (node.start == i && node.end == j) return min ? node.min : node.max;
            else {
                int mid = node.start + (node.end - node.start) / 2;
                if (j <= mid) {
                    return queryTree(node.left, i, j, min);
                } else if (i >= (mid + 1)) {
                    return queryTree(node.right, i, j, min);
                } else {
                    int left = queryTree(node.left, i, mid, min), right = queryTree(node.right, mid + 1, j, min);
                    return min ? Math.min(left, right) : Math.max(left, right);
                }
            }
        }

        static TreeNode root;

        MinMaxSegmentTree(int[] nums) {
            root = buildTree(nums, 0, nums.length - 1);
        }

        public void update(int i, int val) {
            updateTree(root, i, val);
        }

        public int queryMin(int i, int j) {
            return queryTree(root, i, j, true);
        }

        public int queryMax(int i, int j) {
            return queryTree(root, i, j, false);
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
