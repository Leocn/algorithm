package com.example.demo.atcoder.arc156;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int MOD = (int) 998244353;
        Arrays.sort(arr);
        long ans = 1;
        int loc = -1;
        int cnt = 0;
        while (k>0){
            while (cnt <n &&arr[cnt]<=loc){
                cnt++;
            }
            loc++;
            ans *=(loc+1);
            k--;
        }
        System.out.println(ans);

    }
}
