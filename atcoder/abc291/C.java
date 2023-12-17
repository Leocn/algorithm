package com.example.demo.atcoder.abc291;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] cs = str.toCharArray();
        Set<String> set = new HashSet<>();
        set.add("0_0");
        int s = 0, d = 0;
        for(char c: cs){
            if(c=='R'){
                s++;
            }else if(c=='L'){
                s--;
            }else if(c=='D'){
                d--;
            }else {
                d++;
            }
            if(set.contains(s+"_"+d)){
                System.out.println("Yes");
                return;
            }
            set.add(s+"_"+d);
        }
        System.out.println("No");
    }
}
