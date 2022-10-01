package com.example.demo.codechef;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0){
            int n = scanner.nextInt();
            if(n-1>100-n){
                System.out.println("RIGHT");
            }else{
                System.out.println("LEFT");
            }
        }
    }
}
