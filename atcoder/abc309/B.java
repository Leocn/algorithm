package com.example.demo.atcoder.abc309;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] cs = new char[n][n];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.next().toCharArray();
        }
        char tem = cs[0][n-1];

        List<Character> list = new ArrayList<>();
        list.add(cs[1][0]);
        for (int i = 0; i < n; i++) {
            list.add(cs[0][i]);
        }
        for (int i = 1; i <n ; i++) {
            list.add(cs[i][n-1]);
        }
        for (int i = n-2; i >=0 ; i--) {
            list.add(cs[n-1][i]);
        }
        for (int i = n-2; i >=2 ; i--) {
            list.add(cs[i][0]);
        }

        int loc = 0;
        for (int i = 0; i < n ; i++) {
            cs[0][i] = list.get(loc++);
        }
        for (int i = 1; i <n ; i++) {
            cs[i][n-1] = list.get(loc++);
        }
        for (int i = n-2; i >=0 ; i--) {
            cs[n-1][i] =  list.get(loc++);
        }
        for (int i = n-2; i >=1 ; i--) {
            cs[i][0] =  list.get(loc++);
        }
        for (int i = 0; i < n; i++) {
            System.out.println(new String(cs[i]));
        }


    }
}
