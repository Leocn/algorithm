package com.example.demo.atcoder.abc289;

import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Set<Integer>> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int cnt = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            while (cnt-->0){
                set.add(sc.nextInt());
            }
            list.add(set);
        }
        int ans = 0;
        for (int i = 1; i <=Math.pow(2,m)-1 ; i++) {
            HashSet<Integer> set = new HashSet<>();
            int loc = 0;
            int c = i;
            while (c>0 ){
                if((c&1)==1){
                    set.addAll(list.get(loc));
                }
                loc++;
                c=c >> 1;
            }
            if(set.size()==n){
                ans ++;
            }
        }
        System.out.println(ans);
    }
}
