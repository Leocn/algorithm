package com.example.demo.codeforces.cf833;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

public class D {
    public static void main(String[] args) {
        RealFastReader rf = new RealFastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = rf.ni();
        while (t-- > 0) {
            int MOD = 998244353;
            int n = rf.ni();
            int m = rf.ni();
            long[] arr = rf.nal(n);
            long sum = 1;
            for (int i = 1; i < n; i++) {
                if(arr[i]== arr[i-1]){
                    sum *= (m/arr[i]);
                    sum %= MOD;
                    continue;
                }

                if(arr[i-1]%arr[i]==0){
                    sum  *= solve( m/arr[i],arr[i-1]/arr[i]);
                    sum %= MOD;
                    continue;
                }
                sum = 0;
                break;

            }
            out.println(sum);

        }
        out.close();
    }


    static long[] p;
    static int cnt = 0;

    static void get_factor(long m){
        p = new long[(int) 1e5+100];
        cnt=0;
        for(int i=2;i*i<=m;i++){
            if(m%i==0){
                p[cnt++]=i;
                while(m%i==0){
                    m/=i;
                }
            }

        }
        if(m>1){
            p[cnt++]=m;
        }

}
    static long solve(long n, long m){
        get_factor(m);
        long ans=0;
        for(int i=1;i < (1 << cnt);i++){
            long temp=1,t=0;
            for(int j=0;j<cnt;j++){
                if(((1<<j)&i)>=1){
                    temp*=p[j];
                    t++;
                }
            }
            if(t%2==1){
                ans+=n/temp;
            }
            else{
                ans-=n/temp;
            }

        }
        return n-ans;
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
//    public static int f1(int n){
//        int res = n;
//        for (int i = 2;i*i<=n;i++){
//            if (n % i==0){
//                res = res / i*(i-1);//res/i
//                while (n % i == 0){
//                    n/=i;
//                }
//            }
//        }
//        if (n>1){
//            res = res/n*(n-1);
//        }
//        return res;
//    }
//    //区间内欧拉函数取值
//    public static int[] f2(int n){
//        int[] count = new int[n+1];
//        for (int i = 1;i <= n;i++){
//            count[i]=i;
//        }
//        for (int i =2 ;i <= n;i++){
//            if (count[i] == i){
//                for (int j = i;j <= n;j+=i){
//                    count[j] = count[j]/i*(i-1);
//                }
//            }
//        }
//        return count;
//    }
}
