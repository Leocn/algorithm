package com.example.demo.atcoder.abc294;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] arr = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int loc = 1 , c = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            while (c<m && arr2[c]<arr[i]){
                sb1.append(loc).append(" ");
                c++;
                loc++;
            }
            sb.append(loc).append(" ");
            loc++;
        }
        while (c<m){
            sb1.append(loc).append(" ");
            c++;
            loc++;
        }
        System.out.println(sb);
        System.out.println(sb1);

    }
}
