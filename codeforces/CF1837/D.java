package com.example.demo.codeforces.CF1837;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class D {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        int t = sc.ni();
        while (t-->0){
            solve();
        }
        out.close();
    }

    /**
     *
     * 求前缀和，正的在1，负的在2
     */
    public static void solve(){
        int n = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int[] pre = new int[n+1];
        for (int i = 0; i < n; i++) {
            pre[i+1] = pre[i] + (cs[i]=='('?1:-1);
        }
        if(pre[n]!=0){
            out.println(-1);
            return;
        }
        Integer[] ans = new Integer[n];
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if(pre[i] >0){
                ans[i-1] = 1;
            }else if(pre[i]<0){
                ans[i-1] = 2;
            }else {
                ans[i-1] = ans[i-2];
            }
            set.add(ans[i-1]);
        }
        int s = set.size();
        StringBuilder sb = new StringBuilder();
        if(s==1){
            for (int i = 0; i < n; i++) {
                sb.append(1).append(" ");
            }
        }else {
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
        }
        out.println(s);
        out.println(sb);

    }
//    public static void solve(){
//        int n = sc.ni();
//        char[] cs = sc.ns().toCharArray();
//        int c =0 , b = 0;
//        int[] sum = new int[n+1];
//        for (int i = n-1; i >=0; i--) {
//            if(cs[i]=='('){
//                c++;
//                sum[i] = sum[i+1];
//            }else {
//                b++;
//                sum[i] = sum[i+1]+1;
//            }
//        }
//        if(c!=b){
//            out.println(-1);
//            return;
//        }
//        Stack<Integer> stack = new Stack<>();
//        List<Integer> list  = new ArrayList<>();
//        int cnt = 0;
//        for (int i = 0; i < n; i++) {
//            if(cs[i]=='('){
//                cnt++;
//                stack.add(i);
//            }else {
//                if(cnt!=0){
//                    cnt--;
//                    list.add(stack.pop());
//                    list.add(i);
//                }
//                if(sum[i+1] == 0){
//                    break;
//                }
//
//            }
//        }
//        List<Integer> list2 = new ArrayList<>();
//        stack = new Stack<>();
//        cnt = 0;
//        for (int i = n-1; i >=0 ; i--) {
//            if(cs[i]=='('){
//                cnt++;
//                stack.add(i);
//            }else {
//                if(cnt!=0){
//                    cnt--;
//                    list2.add(stack.pop());
//                    list2.add(i);
//                }
//            }
//        }
//        int[] ans =  new int[n];
//        Arrays.fill(ans,1);
//
//        if(list2.size()==n){
//            StringBuilder sb = new StringBuilder();
//            for (int a: ans){
//                sb.append(a).append(" ");
//            }
//            out.println(1);
//            out.println(sb);
//            return;
//        }
//
//
//        Arrays.fill(ans,1);
//        if(list.size()!=0 && list.size()!=n){
//            for(int l: list){
//                ans[l] = 2;
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int a: ans){
//            sb.append(a).append(" ");
//        }
//        if(list.size()==0 || list.size()==n){
//            out.println(1);
//        }else {
//            out.println(2);
//        }
//        out.println(sb);
//
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
