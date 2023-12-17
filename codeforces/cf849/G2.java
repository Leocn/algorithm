package com.example.demo.codeforces.cf849;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class G2 {
    public static void main(String[] args) {
        RealFastReader sc = new RealFastReader(System.in);
        int t = sc.ni();
        out:while (t-- > 0) {
            int n = sc.ni();
            long c = sc.ni();
            long[] arr = new long[n+1];
            long[][] b = new long[n+1][2];
            for(int i=1;i<=n;i++){
                arr[i] = sc.ni();
                b[i][0] = i;
                b[i][1] = Math.min( i,n-i+1) + arr[i];
            }
            Arrays.sort(b,(x,y)-> Math.toIntExact(x[1] - y[1]));
            long[] pre = new long[n+1];
            for (int i = 1; i <=n ; i++) {
                pre[i] = pre[i-1]+ b[i][1];
            }
            long ans = 0;
            for (int i = 1; i <=n ; i++) {
                int l=0, r=n;
                while (l<=r){
                    int mid=(l+r)/2;
                    if(mid<i) {
                        if(pre[mid]+arr[(int)b[i][0]]+b[i][0]<=c) {
                            ans=Math.max(ans,mid+1);
                            l=mid+1;
                        }
                        else
                            r=mid-1;
                    }
                    else {
                        if(pre[mid]-b[i][1]+b[i][0]+arr[(int)b[i][0]]<=c) {
                            ans=Math.max(ans,mid);
                            l=mid+1;
                        }
                        else
                            r=mid-1;
                    }
                }
            }

            System.out.println(ans);




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
