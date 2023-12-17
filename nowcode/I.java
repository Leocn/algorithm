package com.example.demo.nowcode;

import java.util.Scanner;
import java.util.Stack;

public class I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            if(arr[i]>=stack.peek()){
                stack.push(arr[i]);
            }
        }
        System.out.println(stack.size()-1);
    }
}
