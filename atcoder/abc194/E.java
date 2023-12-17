package com.example.demo.atcoder.abc194;

import java.util.Scanner;
import java.util.TreeSet;

public class E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cnt = new int[n];
        for (int i = 0; i < m; i++) {
            cnt[arr[i]]++;
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(n);
        int ans = n+1;
        for (int i = 0; i < n; i++) {
            if(cnt[i]==0){
                set.add(i);
            }
        }
        ans = set.first();
        for (int i = m; i <n ; i++) {
            if(cnt[arr[i]]==0){
            }
            cnt[arr[i]]++;
            if(cnt[arr[i-m]]==1){
                set.add(arr[i-m]);

            }
            cnt[arr[i-m]]--;
            ans =Math.min(ans, set.first());
        }
        System.out.println(ans);

    }
}
