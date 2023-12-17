package com.example.demo.nowcode.N65507;


import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0){
            char[] cs = sc.next().toCharArray();
            int a = 0, b = 0, c = 0, d = 0;
            for(char ch: cs){
               if(Character.isDigit(ch)) {
                   a++;
               }else if(Character.isUpperCase(ch)){
                   b++;
               }else if(Character.isLowerCase(ch)){
                   c++;
               }else {
                   d++;
               }
            }
            int ans =0;
            if(a>1){
                ans += a*65;
            }else {
                ans += 9;
            }
            if(b>1){
                ans += b*65;
            }else {
                ans += 25;
            }
            if(c>1){
                ans += c*65;
            }else {
                ans += 25;
            }
            if(d>1){
                ans += d*65;
            }else {
                ans += 3;
            }
            System.out.println(ans);

        }

        
    }
}
