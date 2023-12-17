package com.example.demo.atcoder.arc163;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    static Scanner sc;
    public static void main(String[] args) {
       sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       long a1 = sc.nextInt();
       long a2 = sc.nextInt();
       long[] arr  = new long[n-2];
        for (int i = 0; i < n-2; i++) {
            arr[i] = sc.nextLong();
        }
        long ans = Long.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < n-m-1; i++) {
            ans = Math.min(ans, (a1<=arr[i]?0: a1-arr[i]) +(a2>=arr[i+m-1]?0:arr[i+m-1]-a2)  );
        }
        System.out.println(ans);
    }

}
