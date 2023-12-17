package com.example.demo.atcoder.abc307;

import java.util.Scanner;
import java.util.Stack;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] cs  = sc.next().toCharArray();
        Stack<Character> st = new Stack<>();
        int  cnt = 0;
        for (int i = 0; i < n ; i++) {
            if(cs[i]=='('){
                st.push(cs[i]);
                cnt++;
            }else if(cs[i] ==')'){
                if(cnt>0){
                    while (st.lastElement()!='('){
                        st.pop();
                    }
                    st.pop();
                    cnt--;
                }else {
                    st.push(cs[i]);
                }
            }else {st.push(cs[i]);}
        }
        StringBuilder sb = new StringBuilder();
        while (st.size()>0){
            sb.append(st.pop());
        }
        sb.reverse();
        System.out.println(sb);

    }
}
