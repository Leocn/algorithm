package com.example.demo.codeforces.CF1786;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            tree = new int[n+1];
            Integer[] arr = new Integer[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = new int[n];
            ans[0] = arr[0] - 1;
            TreeSet<Integer> set = new TreeSet<>();
            set.add(arr[0]);
            add(arr[0], 1);
            for (int i = 1; i < n; i++) {
                if (set.contains(arr[i])) {
                    ans[i] = ans[i - 1];
                    continue;
                }
                if(arr[i]>set.last()){
                    int q = query(arr[i]);
                    ans[i] = ans[i-1] + arr[i]- q-1;

                }else {
                    ans[i] = ans[i - 1]-1;
                }

                add(arr[i], 1);
                set.add(arr[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.println(sb);

        }
    }

    static int[] tree;
    static int n;
    static int lowbit ( int x){
        return x & -x;
    }
    static int query ( int x){
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }
    static void add ( int x, int u){
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

}
