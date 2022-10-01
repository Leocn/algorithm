package com.example.demo.codeforces.ecf134;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int d = sc.nextInt();
            if((n-sx <=d  &&  m-sy <= d) || (sx-1 <=d  &&  sy-1 <= d) || (n-sx <=d  &&  sx-1  <= d)  || (m-sy <=d  &&   sy-1  <= d)){
                System.out.println(-1);
            }else {
                System.out.println(m+n -2);
            }
        }
    }
}
