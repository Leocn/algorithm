package com.example.demo.atcoder.arc161;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int loc = 1;
        int tar = n-1;
        int[] res = new int[n];
        for (; loc < n; loc+=2) {
            res[loc] = arr[tar--];
        }
        loc = 0;
        for (; loc < n; loc+=2) {
            res[loc] = arr[tar--];
        }

        for (int i = 1; i <n ; i+=2) {
            if(res[i]-res[i-1]>0 && res[i]-res[i+1]>0){
                continue;
            }else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");



        out.close();

    }

}
