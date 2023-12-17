package com.example.demo.nowcode.N60245;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();











        char[][] cs = new char[4*n][4*n];
        for(char[] c: cs){
            Arrays.fill(c,'.');
        }
        for (int i = 0; i < 3*n; i++) {
            for (int j = 0; j < 4*n; j++) {
                if(j/n==0 || j/n==3){
                    cs[i][j] = '*';
                }
            }
        }
        int c = 1;                           
        for (int i = 3*n; i < 4*n; i++) {
            for (int j = c; j <c+n ; j++) {
                cs[i][j]= '*';
            }
            for (int j = 4*n-c-1; j>=3*n-c ; j--) {
                cs[i][j]= '*';
            }
            c++;
        }
        for (int i = 0; i < 4*n; i++) {
            System.out.println(new String (cs[i]));
        }
    }
}
