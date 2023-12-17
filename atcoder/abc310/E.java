package com.example.demo.atcoder.abc310;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        int[] cnt = new int[2];
        cnt[cs[0]-'0']++;
        long ans = cs[0]-'0';
        for (int i = 1; i < n ; i++) {
            int[] next = new int[2];
            int now = cs[i]-'0';
            next[1] += cnt[0];
            next[now==1?0:1] += cnt[1];
            next[now]++;
            ans += next[1];
            cnt = next;
        }
        System.out.println(ans);

    }
}
