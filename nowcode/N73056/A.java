package com.example.demo.nowcode.N73056;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;
import java.util.InputMismatchException;

public class A {

    public int minCnt (String s) {
        char[] cs = s.toCharArray();
        int cnt = 0;
        for(char c: cs){
            cnt += c-'0';
        }
        return cnt - 1;
    }

      public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
      }

    public int getTreeSum (TreeNode tree) {
        return (int) (dfs(tree) %((int)1e9+7));
    }

    public long dfs (TreeNode tree) {
        if(tree == null){
            return 0;
        }
        long left = dfs(tree.left);
        long right = dfs(tree.right);
        long ans = 1;
        ans += Math.max(left, right) *2;
        return ans;
    }

    public int getSubarrayNum (ArrayList<Integer> a, int x) {
        int n = a.size();
        int loc = 0;
        int mod = (int)1e9+7;
        int a5 = 0, a2 = 0, a10 = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int g = a.get(i);
            while (g>0&& g%10==0){
                g/=10;
                a10++;
            }
            while (g>0&& g%5==0){
                g/=5;
                a5++;
            }
            while (g>0&& g%2==0){
                g/=2;
                a2++;
            }
            while (Math.min(a2,a5) + a10 >= x){
                int c = a.get(loc++);
                while (c>0&& c%10==0){
                    c/=10;
                    a10--;
                }
                while (c>0&& c%5==0){
                    c/=5;
                    a5--;
                }
                while (c>0&& c%2==0){
                    c/=2;
                    a2--;
                }
            }
            ans =  (ans +loc)%mod;
        }
        return ans;
    }

    public int numsOfGoodMatrix (int n, int m, int x) {
        int mod = (int)1e9+7;
        BigInteger  mo = BigInteger.valueOf(mod);
        //BigInteger ans = BigInteger.valueOf(x).modPow(BigInteger.valueOf(4), mo);
        BigInteger ans = BigInteger.valueOf(x).modPow( BigInteger.valueOf((long)n*m), mo);
        BigInteger twoInv = BigInteger.valueOf(2).modInverse(mo);
        ans = ans.multiply(twoInv.modPow(BigInteger.valueOf((long)(m-1)*(n-1) ), mo)).mod(mo);
        return ans.intValue();
    }
//    static RealFastReader sc = new RealFastReader(System.in);
//    static PrintWriter out = new PrintWriter(System.out);
//
//    public static void main(String[] args) {
//        int t = sc.ni();
//        while (t-- > 0) {
//            solve();
//        }
//        out.close();
//    }
//
//    public static void solve() {
//        int n = sc.ni();
//    }
//
//    public static class RealFastReader {
//        InputStream is;
//
//        public RealFastReader(final InputStream is) {
//            this.is = is;
//        }
//
//        private byte[] inbuf = new byte[8192];
//        public int lenbuf = 0, ptrbuf = 0;
//
//        public int readByte() {
//            if (lenbuf == -1) {
//                throw new InputMismatchException();
//            }
//            if (ptrbuf >= lenbuf) {
//                ptrbuf = 0;
//                try {
//                    lenbuf = is.read(inbuf);
//                } catch (IOException e) {
//                    throw new InputMismatchException();
//                }
//                if (lenbuf <= 0) {
//                    return -1;
//                }
//            }
//            return inbuf[ptrbuf++];
//        }
//
//        private boolean isSpaceChar(int c) {
//            return !(c >= 33 && c <= 126);
//        }
//
//        private int skip() {
//            int b;
//            while ((b = readByte()) != -1 && isSpaceChar(b))
//                ;
//            return b;
//        }
//
//        public double nd() {
//            return Double.parseDouble(ns());
//        }
//
//        public char nc() {
//            return (char) skip();
//        }
//
//        public String ns() {
//            int b = skip();
//            StringBuilder sb = new StringBuilder();
//            while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b != ' ')
//                sb.appendCodePoint(b);
//                b = readByte();
//            }
//            return sb.toString();
//        }
//
//        public char[] ns(int n) {
//            char[] buf = new char[n];
//            int b = skip(), p = 0;
//            while (p < n && !(isSpaceChar(b))) {
//                buf[p++] = (char) b;
//                b = readByte();
//            }
//            return n == p ? buf : Arrays.copyOf(buf, p);
//        }
//
//        public int[] na(int n) {
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = ni();
//            }
//            return a;
//        }
//
//        public long[] nal(int n) {
//            long[] a = new long[n];
//            for (int i = 0; i < n; i++) {
//                a[i] = nl();
//            }
//            return a;
//        }
//
//        public char[][] nm(int n, int m) {
//            char[][] map = new char[n][];
//            for (int i = 0; i < n; i++) {
//                map[i] = ns(m);
//            }
//            return map;
//        }
//
//        public int[][] nmi(int n, int m) {
//            int[][] map = new int[n][];
//            for (int i = 0; i < n; i++) {
//                map[i] = na(m);
//            }
//            return map;
//        }
//
//        public int ni() {
//            int num = 0;
//            int b;
//            boolean minus = false;
//            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//                ;
//            if (b == '-') {
//                minus = true;
//                b = readByte();
//            }
//
//            while (true) {
//                if (b >= '0' && b <= '9') {
//                    num = num * 10 + (b - '0');
//                } else {
//                    return minus ? -num : num;
//                }
//                b = readByte();
//            }
//        }
//
//        public long nl() {
//            long num = 0;
//            int b;
//            boolean minus = false;
//            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
//                ;
//            if (b == '-') {
//                minus = true;
//                b = readByte();
//            }
//
//            while (true) {
//                if (b >= '0' && b <= '9') {
//                    num = num * 10 + (b - '0');
//                } else {
//                    return minus ? -num : num;
//                }
//                b = readByte();
//            }
//        }
//    }
}
