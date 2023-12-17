package com.example.demo.codeforces.cf834;

import java.util.Scanner;

public class D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long m = sc.nextLong();
            long k = 1, tem = n;
            int cnt2 = 0, cnt5 = 0;
            while (n>0 && n%2==0){
                n /= 2;
                cnt2++;
            }
            while (n>0 && n%5==0){
                n /= 5;
                cnt5++;
            }
            while (cnt2<cnt5 && k*2<=m){
                cnt5--;
                k*=2;
            }
            while (cnt2>cnt5 && k*5<=m){
                 cnt2--;
                 k*=5;
            }
            while (k*10<=m){
                k*=10;
            }
            long ans = 0;
            if(k==1){
                ans = tem*m;
            }else{
                k*=(m/k);
                ans = tem *k;
            }
            System.out.println(ans);


        }

    }
}
