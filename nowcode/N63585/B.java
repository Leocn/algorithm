package com.example.demo.nowcode.N63585;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long [] arr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
        }
        long ans = Long.MAX_VALUE;
        int x = sc.nextInt()-1, y = sc.nextInt()-1;
        int min = Math.min(x, y);
        int max = Math.max(x,y);
        if(min == max ){
            System.out.println(0);
            return;
        }
        long a = 0;
        for (int i = min; i <max ; i++) {
            a += arr[i];
        }
        ans = Math.min(a, sum-a);
        System.out.println(ans);



    }
}
