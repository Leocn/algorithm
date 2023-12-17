package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next(), b = sc.next(), c = sc.next();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            char j = a.charAt(i), k = b.charAt(i), m = c.charAt(i);
            if(j==k && k==m){
                continue;
            }else if(j==k){
                ans++;
            }else if(k==m){
                ans++;
            }else if(m==j){
                ans++;
            }else {
                ans+=2;
            }
        }
        System.out.println(ans);

    }
}
