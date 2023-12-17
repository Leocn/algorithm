package com.example.demo.codeforces.CF1800;

import java.io.PrintWriter;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        out :while (t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            String a = sc.next();
            String b = sc.next();
            int[] cnt = new int[26];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(i-k<0&&i+k>=n){
                    sb.append(a.charAt(i));
                }else{
                    cnt[a.charAt(i)-'a']++;
                }
            }

            StringBuilder sbB = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if(i-k<0&&i+k>=n){
                    sbB.append(b.charAt(i));
                }else{
                    cnt[b.charAt(i)-'a']--;
                }
            }
            if(!sb.toString().equals(sbB.toString())){
                out.println("NO");
                continue ;
            }
            for (int i = 0; i < 26; i++) {
                if(cnt[i]!=0){
                    out.println("NO");
                    continue out;
                }
            }

            out.println("YES");

        }
        out.close();
    }
}
