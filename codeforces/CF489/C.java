package com.example.demo.codeforces.CF489;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), s = sc.nextInt();
        int tem = m, temS= s;
        if(s==0 && m!=1){
            System.out.println(-1 + " " + -1);
            return;
        }
        if(s==0 ){
            System.out.println(0 + " " + 0);
            return;
        }
        StringBuilder sbMax = new StringBuilder();
        while (tem>0){
            if(temS>=9){
                sbMax.append(9);
                temS-= 9;
            }else {
                sbMax.append(temS);
                temS-=temS;
            }
            tem--;
        }
        if(temS>0){
            System.out.println(-1 + " " + -1);
            return;
        }
        StringBuilder sbMin = new StringBuilder();
//        m--;
//        s--;
        while (m>0){
            if(s>=9){
                sbMin.append(9);
                s-= 9;
            }else {
                sbMin.append(s);
                s-=s;
            }
            m--;
        }
        sbMin.reverse();
        char[] cs = sbMin.toString().toCharArray();

        if(cs[0]=='0'){
            cs[0]='1';
            int loc = 1;
            while (cs[loc]=='0'){
                loc++;
            }
            cs[loc]--;
        }
        System.out.println( new String(cs) +" " + sbMax);
    }
}
