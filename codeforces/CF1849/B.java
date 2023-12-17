package com.example.demo.codeforces.CF1849;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                int f = sc.nextInt();
                int l = f%k;
                if(l==0){
                    l = k;
                }
                arr[i][0] = i;
                arr[i][1] = l;
            }
            Arrays.sort(arr,(a,b)->{
                if(a[1]==b[1]){
                    return a[0]-b[0];
                }else {
                    return b[1]-a[1];
                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(arr[i][0]+1).append(" ");
            }
            System.out.println(sb);

        }
    }
}
