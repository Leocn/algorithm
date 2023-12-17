package com.example.demo.atcoder.abc283;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] cs = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i = 0; i<cs.length; i++){
            if(cs[i]=='('){
                stack.push('(');
            }else if(cs[i]==')'){
                while (stack.size()>0 && stack.peek()!='('){
                    set.remove(stack.pop());
                }
                stack.pop();
            }else{
                if(set.contains(cs[i])){
                    System.out.println("No");
                    return;
                }
                set.add(cs[i]);
                stack.push(cs[i]);
            }
        }
        System.out.println("Yes");


    }
}
