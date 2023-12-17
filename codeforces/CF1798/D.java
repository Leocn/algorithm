package com.example.demo.codeforces.CF1798;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class D {
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t= sc.ni();
        out:while (t-->0){
            int n = sc.ni();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> pqH = new PriorityQueue<>((a,b)->Integer.compare(b,a));
            long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int a = sc.ni();
                max = Math.max(a, max);
                min = Math.min(a, min);
                if(a>0){
                    pqH.add(a);
                }if(a<0){
                    pq.add(a);
                }
            }

            long sum = 0;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if(pq.size()==0 && pqH.size()==0){
                    if(Math.abs(sum)>=(max-min)){
                        out.println("NO");
                        continue out;
                    }
                    break;
                }
                if(pq.size()==0){
                    ans[i] =pqH.poll();
                    sum+=ans[i];
                    if(Math.abs(sum)>=(max-min)){
                        out.println("NO");
                        continue out;
                    }
                }else if(pqH.size()==0){
                    ans[i] = pq.poll();
                    sum+=ans[i];
                    if(Math.abs(sum)>=(max-min)){
                        out.println("NO");
                        continue out;
                    }
                }else {
                    long sumA = Math.abs(sum + pq.peek());
                    long sumB = Math.abs(sum + pqH.peek());
                    if(Math.abs(sumA)>=Math.abs(sumB)){
                        ans[i]= pqH.poll();
                    }else {
                        ans[i] = pq.poll();
                    }
                    sum+=ans[i];
                    if(Math.abs(sum)>=(max-min)){
                        out.println("NO");
                        continue out;
                    }
                }



            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            out.println("YES");
            out.println(sb);



        }
        out.close();
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
