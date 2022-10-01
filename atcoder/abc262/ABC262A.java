package com.example.demo.atcoder.abc262;

import java.util.Scanner;

public class ABC262A {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int s =scanner.nextInt();
        while(s%4!=2){
            s++;
        }
        System.out.println(s);

    }
}
