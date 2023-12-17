package com.example.demo.nowcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str = sc.next().toCharArray();
        long ans = 0;
        int unk = 0;
        int[] arr = new int[13];
        Arrays.fill(arr,4);

        for (int i = 0; i < 5; i++) {
            if(str[i] == '?'){
                unk ++;
            }
        }


    }
}
