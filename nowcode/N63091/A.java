package com.example.demo.nowcode.N63091;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m-1; j++) {
                Set<Character> set = new HashSet<>();
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        char c = arr[i+k][j+l];
                        if(c == 'y' || c=='o' || c =='u'){
                            set.add(c);
                        }
                    }
                }
                if(set.size()==3){
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
