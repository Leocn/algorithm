package com.example.demo.codeforces.CF1172;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] p = new int[n+1];
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 1; i <=n ; i++) {
            p[a[i]] = 0;
        }
        for (int i = 1; i <=n ; i++) {
            p[b[i]] = i;
        }

        if(p[1]>0){
            int loc = 2;
            for (loc = 2; loc<=n && p[loc] == p[1] + loc - 1; ++loc);
            if (p[loc - 1] == n)
            {
                int last = loc;
                for (; last <= n && p[last] <= last - loc; ++last);
                if (last > n)
                {
                    System.out.println( n - loc + 1);
                    return ;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) ans = Math.max(ans, p[i] - i + 1 + n);

        System.out.println(ans);
    }
}
