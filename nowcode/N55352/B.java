package com.example.demo.nowcode.N55352;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        Arrays.sort(arr,(a, b)->{
            if(a.charAt(1)==b.charAt(1)){
                return a.charAt(0) - b.charAt(0);
            }else {
                return a.charAt(1) - b.charAt(1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
