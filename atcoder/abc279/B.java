package com.example.demo.atcoder.abc279;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        String str = sc.next();
        boolean tag = false;
        if(target.contains(str)){
            tag = true;
        }
        if(tag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
