package com.example.demo.codeforces.CF1781;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.InputMismatchException;

public class C {
    static RealFastReader sc = new RealFastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.ni();
        while (t-- > 0) {
            solve();
        }
        out.close();
    }

    /**
     * 枚举剩余的字符种类 1-26
     * left[i]记录 (char)(i+'a') 可以剩余的个数
     * need[i]记录 (char)(i+'a') 需要的个数
     * */
    public static void solve() {
        int n = sc.ni();
        char[] cs = sc.ns().toCharArray();
        int[][] cnt = new int[26][2];
        for (int i = 0; i < 26; i++) {
            cnt[i][1] = i;
        }
        for(char c: cs){
            cnt[c-'a'][0]++;
        }
        Arrays.sort(cnt, (a,b)->b[0]-a[0]);
        int[] leftF = new int[26];
        int[] needF = new int[26];

        int ans = Integer.MAX_VALUE;

        for (int k = 1; k <=26; k++) {
            if(n%k== 0){
                int c = n/k;
                int[] left = new int[26];
                int[] need = new int[26];
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    int w = cnt[j][1];
                    left[w] =  Math.min(cnt[j][0], c);
                    if(cnt[j][0]<c){
                        need[w] = c - cnt[j][0];
                        sum += need[w];
                    }
                }
                if(sum<ans){
                    ans = sum;
                    leftF = left;
                    needF = need;
                }
            }
        }

        out.println(ans);
        for (int i = 0; i < n; i++) {
            int loc = cs[i] -'a';
            if(leftF[loc]>0){
                leftF[loc]--;
            }else {
                for (int j = 0; j < 26; j++) {
                    if(needF[j]>0){
                        needF[j]--;
                        cs[i] = (char) (j+'a');
                        break;
                    }
                }
            }
        }
        out.println(new String(cs));

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
