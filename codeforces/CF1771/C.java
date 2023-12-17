package com.example.demo.codeforces.CF1771;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.util.*;

public class C {
    static final int MOD = 998244353;
    static final Random RAND = new Random();

    // 31622^2=999950884
    // 31663^2=1002545569
    static final List<Integer> PRIMES = getPrimesLe(31623);

    static boolean solve(int[] a) {
        int n = a.length;
        Set<Integer> pf = new HashSet<>();
        for (int v : a) {
            List<Integer> b = getPrimeFactors(v);
            for (int w : b) {
                if (pf.contains(w)) {
                    return true;
                }
                pf.add(w);
            }
        }
        return false;
    }

    /**
     * 获取小于n的质数
     * */
    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }

    /**
     ** 获取质数因子
     * */
    public static List<Integer> getPrimeFactors(int k) {
        List<Integer> ans = new ArrayList<>();
        int r = (int) Math.sqrt(k) + 1;
        for (int p : PRIMES) {
            if (p > r) {
                break;
            }
            int exp = 0;
            while (k % p == 0) {
                exp++;
                k /= p;
            }
            if (exp > 0) {
                ans.add(p);
            }
        }
        if (k != 1) {
            ans.add(k);
        }
        return ans;
    }

    static boolean test = false;
    static void doTest() {
        if (!test) {
            return;
        }
        long t0 = System.currentTimeMillis();
        int n = 100000;
        int[] a = new int[n];
        final int maxv = 1000000000;
        for (int i = 0; i < n; i++) {
            a[i] = 1 + RAND.nextInt(maxv);
        }
        boolean ans = solve(a);
        System.out.println(ans? "YES" : "NO");
        System.out.format("%d msec\n", System.currentTimeMillis() - t0);
        System.exit(0);
    }

    public static void main(String[] args) {
        doTest();
        MyScanner in = new MyScanner();
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            boolean ans = solve(a);
            System.out.println(ans? "YES" : "NO");
        }
    }

    static void output(int[] a) {
        if (a == null) {
            System.out.println("-1");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int v : a) {
            sb.append(v);
            sb.append(' ');
            if (sb.length() > 4000) {
                System.out.print(sb.toString());
                sb.setLength(0);
            }
        }
        System.out.println(sb.toString());
    }

    static void myAssert(boolean cond) {
        if (!cond) {
            throw new RuntimeException("Unexpected");
        }
    }

    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            try {
                final String USERDIR = System.getProperty("user.dir");
                String cname = MethodHandles.lookup().lookupClass().getCanonicalName().replace(".MyScanner", "");
                cname = cname.lastIndexOf('.') > 0 ? cname.substring(cname.lastIndexOf('.') + 1) : cname;
                final File fin = new File(USERDIR + "/io/c" + cname.substring(1,5) + "/" + cname + ".in");
                br = new BufferedReader(new InputStreamReader(fin.exists()
                        ? new FileInputStream(fin) : System.in));
            } catch (Exception e) {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreElements()) {
                    st = new StringTokenizer(br.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }


}
