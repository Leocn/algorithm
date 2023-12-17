package com.example.demo.codeforces.CF1796;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
//        int t = sc.nextInt();
//        int mod = 998244353;
//        while (t-->0){
//            int l = sc.nextInt();
//            int r = sc.nextInt();
//            if(l==r){
//                out.println(1 + " " + 1);
//                continue;
//            }
//            int s = l, cnt = 1;
//            while (s*2<=r){
//                cnt++;
//                s *=2;
//            }
//            if(cnt==1){
//                out.println(1 + " " + (r-l+1));
//                continue;
//            }
//            long sum = cnt -1;
//            long ans = 0;
//            int a = (int) Math.pow(2, sum);
//            ans += r/a- l +1;
//            a/=2;
//            a*=3;
//            if(r/a-l>=0){
//                ans +=(sum)* (r/a- l +1);
//
//            }
//            ans%=mod;
//
//
//            out.println(cnt + " " + ans);
//        }
//        out.close();
        for (int i = 1; i <=1000000 ; i++) {
            for (int j = 1; j <=1000000; j++) {
                dfs(i,j);
            }
        }
    }

    private static  int dfs(int l, int r){
        if(l==r){
            return  1;
        }
        int s = l, cnt = 1;
        while (s*2<=r){
            cnt++;
            s *=2;
        }
        if(cnt==1){
            return  1;
        }
        long sum = cnt -1;
        long ans = 0;
        int a = (int) Math.pow(2, sum);
        ans += r/a- l +1;
        a/=2;
        a*=3;
        if(r/a-l>=0){
            ans +=(sum)* (r/a- l +1);

        }
        if(ans>=998244353){
            System.out.println(ans);
        }
        return -1;
    }
}
