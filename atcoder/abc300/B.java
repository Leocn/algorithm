package com.example.demo.atcoder.abc300;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        char[][] record = new char[h][w];
        for (int i = 0; i < h; i++) {
            char[] cs = sc.next().toCharArray();
            record[i] = cs;
        }
        char[][] target = new char[h][w];
        for (int i = 0; i < h; i++) {
            target[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < h; i++) {
            out:for (int j = 0; j < w; j++) {
                for (int k = 0; k < h; k++) {
                    for (int l = 0; l < w; l++) {
                        if(record[(i+k)%h][((j+l)%w)]!=target[k][l]){
                            continue out;
                        }
                    }
                }
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");

    }
}
