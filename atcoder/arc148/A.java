package com.example.demo.atcoder.arc148;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        var co = 0;
        var d = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i]%2==0){
                co++;
            }else {
                d++;
            }
        }
        if(co == n || d ==n){
            System.out.println("1");
            return;
        }
        Arrays.sort(arr);
        int[] ds = new int[n-1];
        for (int i = 0; i <n-1 ; i++) {
            ds[i] = arr[i+1] - arr[i];
        }
        int ans =  ds[n-2];
        for (int i = 0; i <n-1 ; i++) {
            if(ds[i]==0){
                continue;
            }
            ans = gcd(ds[i],ans);
            if(ans == 1){
                System.out.println("2");
                return;
            }

        }

        System.out.println("1");

    }
    public static int gcd(int x, int y){
        if(y==0){
            return x;
        }
        return gcd(y,x%y);
    }


}
