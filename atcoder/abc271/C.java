package com.example.demo.atcoder.abc271;

import java.util.Scanner;
import java.util.TreeSet;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a  = sc.nextInt();
            if(set.contains(a)){
               count++;
            }else {
                set.add(a);
            }
        }
        int s = 1;
        int ans = 0;
        while (set.size()>0){
            int p = set.pollFirst();
            if(s==p){
                ans ++;
                s++;
            }else{
                if(count>=2){
                    ans ++;
                    s++;
                    count-=2;
                    set.add(p);
                }else if(set.size()+count>=2){
                    for (int i = 0; i < 2-count; i++) {
                        set.pollLast();

                    }
                    count=0;
                    ans++;
                    s++;
                    set.add(p);
                }else {
                    set.add(p);
                    break;
                }

            }
        }
        ans += (count+ set.size())/2;
        System.out.println(ans);

    }
}
