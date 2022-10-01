package com.example.demo.codeforces.cf817;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            char[] s1 = sc.next().toCharArray();
            char[] s2 = sc.next().toCharArray();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if(s1[i]=='G'){
                    s1[i] = 'B';
                }
                if(s2[i]=='G'){
                    s2[i] = 'B';
                }
                if(s1[i]!=s2[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }

        }

    }
}
