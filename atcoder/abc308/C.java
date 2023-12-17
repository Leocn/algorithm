package com.example.demo.atcoder.abc308;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] arr  = new long[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextLong();
            arr[i][1] = sc.nextLong();
            arr[i][2] = i+1;
        }
        Arrays.sort(arr, (a, b)->{
            long t =  a[0] *(b[0]+b[1]) - b[0]*(a[0] + a[1]);
            if(t== 0 ){
                return Long.compare(a[2], b[2]);
            }else {
                return Long.compare(-t, 0);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][2] ).append(" ");
        }
        System.out.println(sb);

    }
}
