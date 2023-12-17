package com.example.demo.nowcode.N59717;

import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cnt = new int[32];
        Arrays.fill(cnt, -1);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            char[] cs = Integer.toBinaryString(arr[i]).toCharArray();
            int loc = 0;
            for (int j = cs.length-1; j >=0; j--) {
                cnt[loc] = cs[j]=='0'?i:cnt[loc];
                loc++;
            }
            while (loc<32){
                cnt[loc++] = i;
            }
            int res = n;
            for (int j = 0; j < 32; j++) {
                res = Math.min(res, cnt[j]);
            }
            ans += res+1;

         }
        System.out.println(ans);

    }
}
