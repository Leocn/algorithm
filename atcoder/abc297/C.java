package com.example.demo.atcoder.abc297;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        String[] arr = new String[h];
        for (int i = 0; i < h; i++) {
            arr[i] = sc.next();
        }
        for (int i = 0; i < h; i++) {
            char[] cs = arr[i].toCharArray();
            for (int j = 0; j < w-1; j++) {
                if(cs[j]=='T' && cs[j+1]=='T'){
                    cs[j] ='P';
                    cs[j+1] ='C';
                    j++;
                }
            }
            arr[i] = new String(cs);
        }
        for (int i = 0; i < h; i++) {
            System.out.println(arr[i]);
        }

    }
}
