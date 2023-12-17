package com.example.demo.atcoder.abc294;

import java.util.Arrays;
import java.util.Scanner;
/**
public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
        double[][] arr1= new double[n][];
        double[][] arr2= new double[n][];
        for (int i = 0; i < n; i++) {
            arr1[i] = new double[]{sc.nextInt(), sc.nextInt()};
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = new double[]{sc.nextInt(), sc.nextInt()};
        }
        Arrays.sort(arr2, (a,b)->{
            double x = a[0]/(a[0] + a[1]), y = b[0]/(b[0] + b[1]);
            return Double.compare(y, x);
        });

        double left = 0.00000001, right = 100.0001;
        double ans = 0;

        while (left<right){
            double mid = (left+right)/2;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += find(arr2, mid, arr1[i]);
            }
            if(cnt==k){
                ans = mid;
                break;

            }else if(cnt<k){
                right = mid;
            }else {
                left = mid;
            }

        }
        System.out.println(ans);

    }
    private static int find(double[][] arr2, double target, double[] c){
        int l = 0, right = arr2.length;
        while (l<right){
            int mid = l+right>>1;
            double[] t = arr2[mid];
            if(t[0]/(t[0]+t[1])<target){
                l = mid+1;
            }else {
                right = mid;
            }

        }
        return l;
    }
}
 **/
import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextLong(), M=sc.nextLong(), K=sc.nextLong();
        long[] A=new long[(int)N], B=new long[(int)N], C=new long[(int)M], D=new long[(int)M];
        for (int i = 0; i < N; i++) {A[i]=sc.nextLong(); B[i]=sc.nextLong();}
        for (int i = 0; i < M; i++) {C[i]=sc.nextLong(); D[i]=sc.nextLong();}
        double ng = 0, ok = 1;
        for (int iter = 0; iter < 100; iter++) {
            double x = (ng + ok) / 2;
            double z = x / (1 - x);
            double[] v=new double[(int)M];
            for (int i = 0; i < M; i++) v[i] = C[i] - D[i] * z;
            Arrays.sort(v);
            long num = 0;
            for (int i = 0; i < N; i++) {
                double w = A[i] - B[i] * z;
                num += M - (Arrays.binarySearch(v, -w) < 0 ? -Arrays.binarySearch(v, -w) - 1 : Arrays.binarySearch(v, -w));
            }
            if (num < K) ng = x;
            else ok = x;
        }
        System.out.println(String.format("%.16f", ok * 100));
    }
}
