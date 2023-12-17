package com.example.demo.nowcode.N55352;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next(), b = sc.next();
        char[] cs = a.toCharArray(), cb = b.toCharArray();
        int n = cs.length, m = cb.length;
        if(a.equals(b)){
            System.out.println("NO");
            return;
        }
        if(n==m){
            for (int i = 0; i < n; i++) {
                if(cs[i]!=cb[i]){
                    cs[i] = cb[i];
                    a = new String(cs);
                }
            }
        }else if(n==m+1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if(cs[i]!=cb[i]){
                    for(int j = i+1; j<n ; j++){
                        sb.append(cs[j]);
                    }
                    break;
                }
                sb.append(cs[i]);
            }
            a = sb.toString();
        }else if(m==n+1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(cs[i]!=cb[i]){
                    for(int j = i+1; j<m ; j++){
                        sb.append(cb[j]);
                    }
                    break;
                }
                sb.append(cb[i]);
            }
            b = sb.toString();
        }
        if(a.equals(b)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }

    }
}
