package com.example.demo.atcoder.arc155;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        out:while (t-->0){
            long n = scanner.nextLong();
            long k = scanner.nextLong();
            String str = scanner.next();
            String s = new StringBuilder(str).reverse().toString() + str;
            for (int i = 1; i <=2*n ; i++) {
                if(2*n%i==0 && isP(s.substring(0,i))){
                    int end = i;
                    while (end+i<=2*n && s.substring(end-i,end).equals(s.substring(end,end+i))){
                         end+=i;
                    }
                    if(end==2*n){
                        if((k+n)%i==0){
                            System.out.println("Yes");
                        }else{
                            System.out.println("No");
                        }
                        continue out;
                    }
                }

            }
        }
    }
    private static boolean isP(String str){
        int st = 0, en = str.length()-1;
        while (st<en){
            if(str.charAt(st)!=str.charAt(en)){
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
