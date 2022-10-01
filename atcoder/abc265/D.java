package com.example.demo.atcoder.abc265;

import java.util.HashSet;
import java.util.Scanner;

public class D {

    /**
     * set 查找范围
     * */
    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        var n = sc.nextInt();
        var p = sc.nextLong();
        var q= sc.nextLong();
        var r = sc.nextLong();
        var arr = new long[n];
        var sum = new long[n+1];
        var set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            sum[i+1] = arr[i]+sum[i];
            set.add(sum[i+1]);
        }
        for (var i = 0; i < n; i++) {
            long s = sum[i];
            if(set.contains(s+p) && set.contains(s+p+q) && set.contains(s+p+q+r)){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
}
