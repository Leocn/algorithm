package com.example.demo.codeforces.CF435;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        char[] c = s.toCharArray();

        for (int i = 0; i < c.length && n>0; i++) {
            char max = c[i];
            int idx = i;
            for (int j = i; j <= Math.min(c.length - 1, i + n); j++) {
                if (c[j] > max) {
                    max = c[j];
                    idx = j;
                }
            }

            n -= idx - i;
            char t = c[idx];
            if (idx - i >= 0) System.arraycopy(c, i, c, i + 1, idx - i);
            c[i] = t;

        }
        System.out.println(new String(c));
    }
}
