package com.example.demo.atcoder.abc300;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6000; i++) {
            sb.append('a');
        }
        for (int i = 0; i < 6000; i++) {
            sb.append('b').append('c');
        }
        System.out.println(sb);
    }
}
