package com.example.demo.codeforces.CF1561;

import java.util.Arrays;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int[][] arr  = new int[n][2];
            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                int from = 0;
                int now = 0;
                for (int j = 0; j < a; j++) {
                    int b = sc.nextInt();
                    if(now<=b){
                        from += b-now+1;
                        now = b+1;
                        now++;

                    }else {
                        now++;
                    }
                }
                arr[i][0] = from;
                arr[i][1] = a;
            }
            Arrays.sort(arr,(a,b)->a[0]-b[0]);
            int ans = arr[0][0];
            int next = ans + arr[0][1];

            for (int i = 1; i < n; i++) {
                if(next<arr[i][0]){
                    ans += arr[i][0]-next;
                    next = arr[i][0]+ arr[i][1];
                }else {
                    next+=arr[i][1];
                }
            }
            System.out.println(ans);
        }
    }
}
