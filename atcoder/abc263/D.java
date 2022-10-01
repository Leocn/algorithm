package com.example.demo.atcoder.abc263;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        long l = scanner.nextLong();
        long r = scanner.nextLong();

        float[] s = new float[n+1];
        float[] sum = new float[n+1];
        int index = 0;
        double[] ds = new double[n+1];
        double max = 0;
        for (int i = 1; i < n+1; i++) {
            s[i] = scanner.nextLong();
            sum[i] = sum[i-1] + s[i];
            ds[i] = sum[i] /i;
            if(ds[i]>=max){
                max = ds[i];
                index = i;
            }
        }
        float ans = sum[n];
        if(max>l){
            ans += index*l;
            ans -= sum[index];
        }
        for (int i = 1; i <=index ; i++) {
            s[i] = l;
        }
        max = 0;
        float[] sumR = new float[n+2];
        for (int i = n; i >=1; i--) {
            sumR[i] = sumR[i+1] + s[i];
            ds[i] = sumR[i] /(n-i+1);
            if(ds[i]>=max){
                max = ds[i];
                index = i;
            }
        }
        if(max>r){
            ans += (n-index+1)*r;
            ans -= sumR[index];
        }
        System.out.println((int) ans);
    }
}
