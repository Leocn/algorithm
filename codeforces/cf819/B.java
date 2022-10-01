package com.example.demo.codeforces.cf819;

import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if(m<n){
                out.println("No");
                continue;
            }
            StringBuilder sb = new StringBuilder();

            if(m%n==0){
                for (int i = 0; i < n; i++) {
                    sb.append(m/n).append(" ");
                }
                out.println("Yes");
                out.println(sb);

            }else{
                if(n%2==0){
                    if(m%2!=0){
                        out.println("No");
                    }else{
                        for (int i = 0; i < n-2 ; i++) {
                            sb.append(1).append(" ");
                        }
                        sb.append((m-n+2)/2).append(" ").append((m-n+2)/2);
                        out.println("Yes");
                        out.println(sb);
                    }
                }else{
                    for (int i = 0; i < n-1 ; i++) {
                        sb.append(1).append(" ");
                    }
                    sb.append(m-n+1);
                    out.println("Yes");
                    out.println(sb);
                }

            }

        }
        out.close();
    }
}
