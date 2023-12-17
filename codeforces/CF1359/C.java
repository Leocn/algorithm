package com.example.demo.codeforces.CF1359;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        while (x-->0){
            int h = sc.nextInt();
            int c = sc.nextInt();
            int t = sc.nextInt();
            double l =  1, right = (int)1e6+9;
            if(t<=(c+h)/2){
                System.out.println(2);
                continue;
            }
            double mid = 0;
            for (int i = 0; i < 62; i++) {
                mid = (l+ right)/2;
                double sum = mid*h + (mid-1)*c;
                double tem = sum/(2*mid-1);
                if(tem==t){
                    break;
                }else if(tem<t){
                    right= mid;
                }else {
                    l = mid;
                }
            }
            int ans = 0;
            BigDecimal  max =new BigDecimal(Long.MAX_VALUE);

            for(double i =(int)mid-1; i<= (int)mid+1 ; i++){
                BigDecimal v =  new BigDecimal((i) * h + (i - 1) * c).divide(new BigDecimal (2 * i - 1),20, RoundingMode.CEILING);
                BigDecimal diff = v.subtract(new BigDecimal(t)).abs();
                if(diff.compareTo(max) <0){
                    ans = (int)i;
                    max = diff;
                }
            }
            System.out.println((int)ans*2-1);

        }

    }
}
