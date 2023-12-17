package com.example.demo.codeforces.CF1788;

import java.io.PrintWriter;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        while (t-->0){
            long n = sc.nextLong();
            if(n==1){
                out.println("YES");
                out.println(1 + " "+2);
                continue;
            }
            long sum = (2*n+1)*n;
            long fir = (2*sum/n) - (n-1);
            if(fir%2!=0){
                out.println("NO");
                continue;
            }
            long st = fir/2;
            out.println("YES");
            for (long i = 1; i <=n; i+=2) {
                out.println(i + " " + (st-i));
                st++;

            }
            for (int i = 2; i <=n ; i+=2) {
                out.println(i + " " + (st-i));
                st++;
            }

        }
        out.close();
    }
}
