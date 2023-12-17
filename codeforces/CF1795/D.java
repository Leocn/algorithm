package com.example.demo.codeforces.CF1795;

import java.io.PrintWriter;
import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int MOD = 998244353;

            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int m = n/3;
            long ans = 1;
            int cntThree = 0;
            int cntTwo = 0;
            for (int i = 0; i < n-2; i+=3) {
                if(arr[i]==arr[i+1] && arr[i] == arr[i+2]){
                    cntThree ++;
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                list.add(arr[i+2]);
                Collections.sort(list);
                if(Objects.equals(list.get(0), list.get(1))){
                    cntTwo++;
                }
            }
            for (int i = 0; i < cntThree; i++) {
                ans = ans*3%MOD;
            }
            for (int i = 0; i < cntTwo; i++) {
                ans = ans*2%MOD;
            }
            for (int i = 0; i < m/2; i++) {
                ans  = ans*(m-i)%MOD;
                ans = ans*(FermatInv(i+1,(long)MOD)%MOD)%MOD;
            }
            out.println(ans%MOD);
        out.close();
    }

    static long PowMod(long a, long n, long mod)
    {
        long ret = 1;
        while(n>0)
        {
            if((n & 1)>0) ret = ret * a % mod;
            a = a * a % mod;
            n >>= 1;
        }
        return ret;
    }
    //求a对mod的逆元
    static long FermatInv(long a, long mod)
    {
        return PowMod(a, mod - 2, mod);
    }
}
