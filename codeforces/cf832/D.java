package com.example.demo.codeforces.cf832;



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class D {
    public static void main(String[] args) {
        RealFastReader rf = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int n = rf.ni();
        int q = rf.ni();
        int[] arr = rf.na(n);
        int[]  sum = new int[n+1];
        int[] s = new int[n+1];
        for(int i=0; i<n; i++){
            sum[i+1] = sum[i]^arr[i];
            s[i+1] = s[i];
            if(arr[i]==0){
                s[i+1]++;
            }
        }
        while (q-->0){
            int l = rf.ni()-1;
            int r = rf.ni()-1;
            if(s[r+1]-s[l]==r-l+1){
               out.println(0);
                continue;
            }
            if(l==r){
                if(arr[l]==0) {
                    out.println(0);
                }else{
                    out.println(-1);
                }
                continue;
            }
            if(r== l+1){
                if(arr[l]== 0 && arr[r]==0){
                    out.println(0);
                }else {
                    out.println(-1);
                }
                continue;
            }

            if((r-l)%2==0){
                if(sum[r+1]==sum[l]){
                    out.println(1);
                }else{
                    out.println(-1);
                }
                continue;
            }
            if((r-l)%2==1){
                if(sum[r+1]==sum[l]){
                    if(arr[r]==0 || arr[l]==0){
                        out.println(1);
                    }else{
                        out.println(2);
                    }

                }else{
                    out.println(-1);
                }
            }

        }
        out.close();




    }

    static public class RealFastReader {
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
