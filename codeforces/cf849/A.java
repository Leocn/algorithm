package com.example.demo.codeforces.cf849;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            String s = sc.next();
            if("codeforces".contains(s)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

}
