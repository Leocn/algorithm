package com.example.demo.codeforces.CF1787;

import java.io.PrintWriter;
import java.util.*;

public class B {
    static final List<Integer> PRIMES = getPrimesLe((int)Math.sqrt(1e9+10)+10);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t-->0){
            int n = sc.nextInt();
            List<Integer> list = getPrimeFactors(n);
            Map<Integer,Integer> map = new HashMap<>();
            long ans =0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            for(int l:list){
                int sum = 0;
                while (n>1&&n%l==0){
                    n/=l;
                    sum++;
                }
                map.put(l, sum);
                min = Math.min(min, sum);
                max = Math.max(max, sum);
            }
            while (max>0){
                Map<Integer, Integer> map1 = new HashMap<>(map);
                long s = 1;
                int m = Integer.MAX_VALUE;
                int mm = 0;
                for(Map.Entry<Integer, Integer> e: map1.entrySet()){
                    int v = e.getValue();
                    if(v>=min){
                        s *= e.getKey();
                        map.put(e.getKey(), v-min);
                        mm = Math.max(v-min, mm);
                        if(v-min>0){
                            m = Math.min(v-min,m);
                        }
                    }
                }
                s*=min;
                min = m;
                ans +=s;
                max = mm;
            }


            out.println(ans);
        }
        out.close();
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


}
