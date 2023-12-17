package com.example.demo.nowcode.N59717;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A {
    static final List<Integer> PRIMES = getPrimesLe((int)1e6+1);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int a = sc.nextInt();
            f(a);

        }

    }
    public static void f(int a) { // l <= x <= r
        while (a>0){
            if(PRIMES.contains(a)){
                a/=10;
            }else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static List<Integer> getPrimesLe(int n) {
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr, true);
        arr[1] = false;
        int p = 2;
        int r = (int) (1 + Math.sqrt(n));
        while (p <= r) {
            int v = p + p;
            while (v <= n) {
                arr[v] = false;
                v += p;
            }
            p++;
            while (p <= r && !arr[p]) {
                p++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (arr[i]) {
                primes.add(i);
            }
        }
        //show(primes);
        return primes;
    }

}
