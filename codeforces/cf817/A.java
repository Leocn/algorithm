package com.example.demo.codeforces.cf817;

import java.util.*;

public class A {
    static Set set;
    static{
        set = new HashSet<Character>();
        set.add('T');
        set.add('r');
        set.add('u');
        set.add('m');
        set.add('i');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();
            if(n!=5){
                System.out.println("No");
                continue;
            }

            Set<Character> se = new HashSet<>();
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                if(se.contains(s.charAt(i))){
                   flag = false;
                   break;
                }
                if(!set.contains(s.charAt(i))){
                    flag = false;
                    break;
                }
                se.add(s.charAt(i));
            }
            if(flag){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }

    }
}
