package com.example.demo.atcoder.abc294;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), w = sc.nextInt();
        for (int i = 0; i < h; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < w; j++) {
                int s = sc.nextInt();
                if(s==0){
                    sb.append(".");
                }else {
                    s--;
                    sb.append( (char) (s+'A'));
                }
            }
            System.out.println(sb);
        }

    }
}
