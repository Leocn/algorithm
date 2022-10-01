package com.example.demo.codeforces.cf823;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();

            Long[] arr = new Long[n];
            Long[] re = new Long[n];
            for (int i = 0; i <n; i++) {
               arr[i] = sc.nextLong();
               re[i] = arr[i];
            }
            Arrays.sort(arr);
            long[] time = new long[n];
            for (int i = 0; i < n; i++) {
                time[i] = sc.nextInt();
            }
            if(n==1){
                System.out.println(arr[0]);
                continue;
            }
            double left = arr[0];
            double right = arr[n-1];
            double ans = 0;
            while (left<=right){
                double mid = (left+right)/2;
                double[] a = new double[n];
                double max = -1;
                int loc = 0;
                int sLoc = 0;
                for (int i = 0; i < n; i++) {
                    a[i] = Math.abs(mid-re[i])+time[i];
                    if(arr[i]>=max){
                        sLoc = loc;
                        loc = i;
                        max = a[i];
                    }
                }
                Arrays.sort(a);
                if(a[n-1]-a[n-2]<0.000001 || sLoc == loc){
                    ans = mid;
                    break;
                }else {
                    if(loc<mid){
                        right = mid-0.0000001;
                    }else if(loc>mid){
                        left = mid+0.0000001;
                    }else {
                        ans = mid;
                        break;
                    }
                }
            }



            System.out.println(ans);
        }
    }
}
