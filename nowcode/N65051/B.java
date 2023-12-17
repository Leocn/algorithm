package com.example.demo.nowcode.N65051;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] cs = new char[n][m];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.next().toCharArray();
        }
        char[] tar = "meituan".toCharArray();
        int loc = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tar[loc]==cs[i][j]){
                    loc++;
                    break;
                }
            }
            if(loc==tar.length){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
