package com.example.demo.atcoder.abc281;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(str.length()!=8){
            System.out.println("No");
            return;
        }
        char c = str.charAt(0);
        char d = str.charAt(7);
        if(!(c>='A'&& c<='Z') || !(d>='A'&& d<='Z')){
            System.out.println("No");
            return;
        }
        for (int i = 1; i <=6 ; i++) {
            char a = str.charAt(i);
            if(!(a>='0' && a<='9')){
                System.out.println("No");
                return;
            }
        }
        int t = Integer.parseInt(str.substring(1,7));
        if(t>=100000 && t<=999999){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }

    }
}
