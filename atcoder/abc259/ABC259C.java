package com.example.demo.atcoder.abc259;

import java.util.Scanner;

public class ABC259C {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char[] from = scanner.next().toCharArray();
        char[] to = scanner.next().toCharArray();
        char a = from[0];
        char b = to[0];
        if(a!=b){
            System.out.println("No");
            return;
        }
        int startA = 0;
        int startB = 0;
        while(startA<from.length){
            int countA = 0;

            while (startA< from.length&& from[startA] == a ){
                countA++;
                startA ++;
            }

            int countB = 0;
            while(startB<to.length &&to[startB] == a){
                countB++;
                startB++;
            }
            if(countA==1 && ( countB !=1)){
                System.out.println("No");
                return;
            }
            if(countA>1 && (countB<countA)){
                System.out.println("No");
                return;
            }
            if(startA<from.length){
                a = from[startA];
            }

        }
        if(startB!= to.length){
            System.out.println("No");
            return;
        }
        System.out.println("Yes");


    }
}
