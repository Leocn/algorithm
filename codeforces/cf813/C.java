package com.example.demo.codeforces.cf813;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] re = new int[n];
            for (int i = 0; i < n; i++) {
                re[i] = sc.nextInt();
            }
            Set<Integer> set = new HashSet<>();
            Deque<Integer> deque = new ArrayDeque<>();
            int ans =0;
            deque.push(re[0]);
            for (int i = 1; i <n; i++) {
                if(set.contains(re[i])){
                    while (deque.size()>0){
                        int p = deque.pop();
                        if(!set.contains(p)){
                            set.add(p);
                            ans++;
                        }
                    }
                }
                if (deque.size() <= 0 || deque.peek() > re[i]) {
                    while (deque.size() > 0) {
                        int p = deque.pop();
                        if (!set.contains(p)) {
                            set.add(p);
                            ans++;
                        }
                    }
                }
                deque.push(re[i]);
            }
            System.out.println(ans);
        }
    }
}
