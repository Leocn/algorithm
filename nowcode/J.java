package com.example.demo.nowcode;

import java.util.Scanner;
import java.util.Stack;

public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        int[] ans = new int[n];
        for (int i = n-1; i >= 0; i--) {
            while (arr[i]>stack.peek()){
                stack.pop();
            }
            stack.push(arr[i]);
            ans[i] = stack.size()-1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
