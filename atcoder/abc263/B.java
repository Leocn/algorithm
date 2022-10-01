package com.example.demo.atcoder.abc263;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[n+1];
        for (int i = 2; i <n+1 ; i++) {
            s[i] = scanner.nextInt();

        }
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(s[n]);

        int ans =1;
        while (deque.size()>0){
           int p = deque.poll();
           if(p==1){
               break;
           }
           ans ++;
           deque.add(s[p]);

        }
        System.out.println(ans);
    }
}
