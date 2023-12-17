package com.example.demo.codeforces.tfr8;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(i+1<n && arr[i+1]-arr[i]<3){
                i++;
            }
            ans++;
        }
        out.println(ans);
        out.close();
    }
}
