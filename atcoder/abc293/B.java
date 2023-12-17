package com.example.demo.atcoder.abc293;


import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int c  = scanner.nextInt();
            if(b[i]==0){
                b[c] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 1; i <=n ; i++) {
            if(b[i]==0){
                ans++;
                sb.append(i).append(" ");
            }

        }
        System.out.println(ans);
        System.out.println(sb);

    }
}
