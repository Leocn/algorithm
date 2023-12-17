package com.example.demo.atcoder.abc291;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[5*n];
        for (int i = 0; i < 5*n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        double sum =0;
        for (int i = n; i <4*n ; i++) {
            sum += arr[i];
        }
        System.out.println(sum/(3*n));

    }
}
