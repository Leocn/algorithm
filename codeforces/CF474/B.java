package com.example.demo.codeforces.CF474;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum[i+1] = sum[i]+ arr[i];
        }
        int m = sc.nextInt();
        int[][] ans = new int[m][2];
        for (int i = 0; i < m; i++) {
            ans[i][0] = sc.nextInt();
            ans[i][1] = i;
        }
        Arrays.sort(ans, (a,b)->a[0]-b[0]);
        int[] res = new int[m];
        int loc = 0;
        for (int i = 0; i < m; i++) {
            int s = ans[i][0];
            while (sum[loc]<s){
                loc++;
            }
            res[ans[i][1]] =  loc;
        }
        for (int i = 0; i < m; i++) {
            System.out.println(res[i]);
        }

    }

}
