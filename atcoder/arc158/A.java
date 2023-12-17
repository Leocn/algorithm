package com.example.demo.atcoder.arc158;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        PrintWriter out = new PrintWriter(System.out);

        while (t-->0){
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            int x3 = sc.nextInt();
            long[] arr = new long[]{x1,x2,x3};
            Arrays.sort(arr);
            if((arr[2]-arr[1])%2==1){
                out.println(-1);
                continue;
            }
            if((arr[1]-arr[0])%2==1){
                out.println(-1);
                continue;
            }

            long ans = 0;
            if(arr[1]-arr[0] <arr[2]-arr[1]){
                long d = (arr[1]-arr[0])/2;
                ans += d;
                arr[2]+=3*d;
                arr[1] += 5*d;
                arr[0] += 7*d;
                if((arr[2]-arr[0])%6!=0){
                    out.println(-1);
                    continue;
                }
                ans += (arr[2] - arr[1])/3;
            }else{
                long d= (arr[2]-arr[1])/2;
                ans+=d;
                arr[2]+=3*d;
                arr[1] += 5*d;
                arr[0] += 7*d;
                if((arr[2]-arr[0])%6!=0){
                    out.println(-1);
                    continue;
                }
                ans += (arr[2]-arr[0])/3;
            }
            out.println(ans);
        }
        out.close();

    }
}
