package com.example.demo.codeforces.ecf134;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while (t-->0){
            String a = sc.next();
            String b = sc.next();
            Set<Character> set = new HashSet<>();
            set.add(a.charAt(0));
            set.add(a.charAt(1));
            set.add(b.charAt(0));
            set.add(b.charAt(1));

            System.out.println(set.size()-1);

        }

    }
}
