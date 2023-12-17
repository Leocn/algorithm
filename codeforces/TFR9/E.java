package com.example.demo.codeforces.TFR9;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}
