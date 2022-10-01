package com.example.demo.codeforces;

import java.util.Scanner;

public class CF806A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String x = sc.next();
            if(x.equalsIgnoreCase("YES")){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
