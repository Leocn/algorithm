package com.example.demo.codechef;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int s = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            if(s+b+c+d==0){
                System.out.println("IN");
            }else {
                System.out.println("OUT");
            }
        }
    }
}
